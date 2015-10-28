package org.hannes.marktime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

public class Logic {
	final static Logger logger = Logger.getLogger(Logic.class);
	private UI				gui;
	private RelativeTime	start;
	private Thread      	t;
	private String			host;
	private String      	userName;
	private String      	password;
	private String      	sessionId;
	private ShowTime    	showTime;
	private List<Team>  	teams;
	private int				laneCount;
	private DataStore   	dataStore;
	private Sync            sync;
	private Thread      	s;
	
	public Logic(UI gui) {
		logger.info("Start");
		this.gui=gui;
		dataStore=new DataStore();
		logger.info("Read local team data");
		teams=dataStore.readTeams();
		laneCount=dataStore.laneCount();
		restartTimer();
		host=dataStore.host();
		gui.showTeams(teams);
		gui.showLanes(laneCount);
	}
	
	public void finalize() throws Throwable {
		logger.info("Exit");
	}
	
	private void restartTimer() {
		logger.info("Check if timer as running...");
		start=dataStore.readTime();
		Date now=new Date();
		if ((now.getTime()-start.getOffset())<3600*1000*23) {
			RelativeTime wrk=start.clone();
			wrk.set(now);
			logger.info("Continue timer at "+wrk.toString());
			startTime(start);
		} else {
			logger.info("Timer not running or expired");
		}
	}
	
	private String getSessionId(String hdr) {
		String result=new String("");
		String[] flds=hdr.split(";");
		for (int i=0;i<flds.length;i++) {
			String[] val=flds[i].split("=");
			if (val[0].equals("PHPSESSID")) {
				result=val[1];
			}
		}
		return result;
	}
	
	public void login(String name, String pwd) {
		this.userName=name;
		logger.info("Login user: "+name);
		this.password=pwd;
		try {
			gui.showSync(true);
			URL url=new URL("http://"+host+"/index.php?Module=ModAuth&Action=Verify&User="+userName+"&Pwd="+password);
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("cookie", "PHPSESSID="+sessionId);
			conn.setRequestProperty("User-Agent", "MarkTime");
			if (conn.getResponseCode()==HttpURLConnection.HTTP_OK) {
				gui.showLoginMsg("Aangemeld", true);
				sessionId=getSessionId(conn.getHeaderField("Set-Cookie"));
				gui.showOnline(true);
				int cnt=getTeams();
				gui.showTeams(teams);
				gui.showLoginMsg("Aangemeld, "+cnt+" teams opgehaald", true);
				startSync(sessionId);
			} else {
				gui.showLoginMsg("Naam/wachtwoord combinatie incorrect", false);
			}
			gui.showSync(false);
		} catch (Exception e) {
			
		} finally {
			gui.showSync(false);
		}
	}
	
	private int getTeams() {
		int teamCount=0;
		try {
			gui.showSync(true);
			URL url=new URL("http://"+host+"/index.php?Module=Reports&Report=StartCsvList&Action=run");
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("cookie", "PHPSESSID="+sessionId);
			conn.setRequestProperty("User-Agent", "MarkTime");
			if (conn.getResponseCode()==HttpURLConnection.HTTP_OK) {
				StringBuffer buf=new StringBuffer();
				BufferedReader data=new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line;
				while ((line=data.readLine()) != null) {
					buf.append(line);
				}
				String wrk=buf.toString();
				System.out.println(wrk);
				String[] t=wrk.split("\\|");
				for (int i=0;i<t.length;i++) {
					String[] parms=t[i].split("~");
					if (parms.length==7) {
						Team team=new Team(parms, start.getOffset());
						dataStore.add(team);
						teamCount++;
					}
				}
				dataStore.saveTeams(teams);
			} else { 
				logger.error("Failed to retrieve team data");
			}
		} catch (Exception e) {
		} finally {
			gui.showSync(false);			
		}
		logger.info("Got "+teamCount+" teams from server");
		return teamCount;
	}
	
	public void sync() {
		start=new RelativeTime();
		startTime(start);
		
	}
	
	private void startTime(RelativeTime start) {
		logger.info("startTime");
		if (t==null) {
			showTime=new ShowTime(start,gui);
			t=new Thread(showTime);
			t.start();
			dataStore.saveTime(start);
			gui.setStartActive(false);
			gui.setResetActive(true);
			int next=dataStore.lastStart();
			Boolean more=true;
			for (int i=0;i<laneCount && more;i++) {
				next=dataStore.giveNextTeam(next);
				if (next>0) {
					gui.setLane(i,next);
				} else {
					more=false;
				}
			}
		}		
	}
	
	public void reset() {
		logger.info("Reset timer");
		if (t!=null) {
			if (gui.confirmReset()) {
				showTime.stopRunning();
				t.interrupt();
				try {
					t.join();
				} catch (Exception e) {
				}
				t=null;
				RelativeTime rt=new RelativeTime();
				rt.set(0,0);
				dataStore.saveTime(rt);
				dataStore.resetLastStart();
				dataStore.resetTeams();
				gui.showTeams(teams);
				gui.showTime(rt.toString());
				gui.setStartActive(true);
				gui.setResetActive(false);
				gui.clearData();
			}
		}
	}
	
	public void start(String boot1, String boot2) {
		logger.info("Start lane1: "+boot1+"   lane2: "+boot2);
		int startNummer1=0;
		int startNummer2=0;
		start.set(new Date());
		try {
			startNummer1=Integer.parseInt(boot1);
			dataStore.setTeamStart(startNummer1,start.clone());
		} catch (Exception e) {
			startNummer1=0;
		}
		if (laneCount>1) {
			try {
				startNummer2=Integer.parseInt(boot2);
				dataStore.setTeamStart(startNummer2,start.clone());
			} catch (Exception e) {
				startNummer2=0;
			}
		}
		gui.setPrev(startNummer1, startNummer2, start);
		int last=(startNummer2>startNummer1)? startNummer2:startNummer1;
		dataStore.setLastStart(last);

		int next1=0;
		int next2=0;
		if (laneCount>1 && startNummer2>0) {
			next1=dataStore.giveNextTeam(last);
			next2=dataStore.giveNextTeam(next1);
			gui.setStart(next1, next2);
		} else if (startNummer1>0) {
			next1=dataStore.giveNextTeam(startNummer1);
			if (laneCount>1) {
				next2=dataStore.giveNextTeam(next1);
			}
		}
		if (next1%2==0) {
			int wrk=next2;
			next2=next1;
			next1=wrk;
		}
		gui.setStart(next1, next2);
		gui.showTeams(teams);
		sync.putData(dataStore.timeString());
	}
	
	private void updateFinish(String bootNum, String finishTijd) {
		if (bootNum.length()>0) {
			int bootNummer=Integer.parseInt(bootNum);
			dataStore.setTeamFinish(bootNummer, finishTijd);
		}
	}
	
	public void finish(String bootNum,
			String bootNummer_2, String finishTijd_2,
			String bootNummer_3, String finishTijd_3,
			String bootNummer_4, String finishTijd_4,
			String bootNummer_5, String finishTijd_5
	) {
		logger.info("Finish boatnum= "+bootNum+" prev= "+bootNummer_2+" time= "+finishTijd_2);
		if (bootNum.length()>0) {
			int bootNummer=Integer.parseInt(bootNum);
			dataStore.setTeamFinish(bootNummer,start.clone());
		}
		updateFinish(bootNummer_2, finishTijd_2);
		updateFinish(bootNummer_3, finishTijd_3);
		updateFinish(bootNummer_4, finishTijd_4);
		updateFinish(bootNummer_5, finishTijd_5);
		gui.shiftFinishTimes(start.clone());
		gui.showTeams(teams);
		sync.putData(dataStore.timeString());
	}
	
	
	public void setLaneCount(int lanes) {
		logger.info("Set lane count to "+lanes);
		laneCount=lanes;
		dataStore.setLaneCount(lanes);
		gui.showLanes(lanes);
	}

	private class ShowTime implements Runnable {
		private UI gui;
		private RelativeTime start;
		private Boolean running=true;
		
		public ShowTime(RelativeTime start, UI gui) {
			this.gui=gui;
			this.start=start;
		}
		
		public void stopRunning() {
			running=false;
		}
		
		public void run() {
	        while (running) {
	        	start.set(new Date());
	        	gui.showTime(start.toString());
	        	try {
	        		Thread.sleep(100);
	        	} catch (Exception e) {
	        		running=false;
	        	}
	        }
		}
	}
	
	private void startSync(String sessionId) {
		if (sync==null) {
			sync=new Sync(sessionId);
			s=new Thread(sync);
			s.start();
		}
	}
	
	private class Sync implements Runnable {
		private String results;
		private Boolean changed=false;
		private Boolean running=false;
		private String sessionId;
		
		public Sync(String sessionId) {
			this.sessionId=sessionId;
		}
		
		public synchronized void putData(String data) {
			results=new String(data);
			changed=true;
		}

		public synchronized String getData() {
			changed=false;
			return new String(results);
		}
		
		private synchronized Boolean isChanged() {
			return changed;
		}

		private void send(String data) {
			try {
				gui.showSync(true);
				URL url=new URL("http://"+host+"/index.php?Module=TabMaint&Table=Ploeg&Action=sync&Data="+data);
				logger.info(url.toString());
				HttpURLConnection conn=(HttpURLConnection)url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("cookie", "PHPSESSID="+sessionId);
				conn.setRequestProperty("User-Agent", "MarkTime");
				if (conn.getResponseCode()!=HttpURLConnection.HTTP_OK) {
					gui.showOnline(false);
				}
			} catch (Exception e) {
				logger.error(e.getMessage());
			} finally {
				gui.showSync(false);
			}
		}
		
		public void run() {
			running=true;
	        while (running) {
	        	// use isChanged and getData to prevent concurrencty problems
	        	if (isChanged()) {
	        		send(getData());
	        	}
	        	try {
	        		Thread.sleep(100);
	        	} catch (Exception e) {
	        		running=false;
	        	}
			}
		}
	}
}