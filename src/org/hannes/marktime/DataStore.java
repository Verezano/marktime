package org.hannes.marktime;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DataStore {
	final static Logger logger = Logger.getLogger(DataStore.class);
	private Properties prop;
	private String host;
	private long time;
	private int laneCount;
	private int lastStart;
	private List<Team> teams;
	
	DataStore() {
		teams=new ArrayList<Team>();
		time=0;
		laneCount=2;
		lastStart=0;
		prop=new Properties();
		readProperties();
	}
	
	protected void finalize() throws Throwable {
		saveProperties();
	}
	
	private void readProperties() {
		InputStream input;
		try {
			input = new FileInputStream("config.properties");
			prop.load(input);
			input.close();
			String lc=prop.getProperty("laneCount");
			try {
				laneCount=Integer.parseInt(lc);
			} catch (Exception e) {
				laneCount=2;
			}
			String ls=prop.getProperty("lastStart");
			try {
				lastStart=Integer.parseInt(ls);
			} catch (Exception e) {
				lastStart=0;
			}
			host=prop.getProperty("host");
		} catch (Exception e) {
			
		}
	}
	
	private void saveProperties() {
		OutputStream output = null;
		try {
			prop.setProperty("lastStart", Integer.toString(lastStart));
			prop.setProperty("laneCount", Integer.toString(laneCount));
			output = new FileOutputStream("config.properties");
			prop.store(output, null);
		} catch (Exception e) {
			
		}
	}
	
	public int laneCount() {
		return laneCount;
	}
	
	public int lastStart() {
		return lastStart;
	}
	
	public String host() {
		return host;
	}
	
	public void setLaneCount(int lanes) {
		System.out.println("lane count "+lanes);
		laneCount=lanes;
		saveProperties();
	}
	
	public void setLastStart(int last) {
		if (last>0) {
			lastStart=last;
			saveProperties();
		}
	}
	
	public void resetLastStart() {
		lastStart=0;
	}
	
	public List<Team> readTeams() {
		String ts=prop.getProperty("teams");
		teams=new ArrayList<Team>();
		long offset=readTime().getOffset();
		if (ts!=null) {
			String[] t=ts.split("\\|");
			for (int i=0;i<t.length;i++) {
				String[] parms=t[i].split(",");
				if (parms.length==9) {
					Team team=new Team(parms, offset);
					teams.add(team);
				}
			}
		}
		return teams;
	}
	
	public String teamsString() {
		Iterator<Team> it=teams.iterator();
		StringBuffer buf=new StringBuffer();
		Boolean first=true;
		while (it.hasNext()) {
			Team team=it.next();
			if (first) {
				first=false;
			} else {
				buf.append('|');
			}
			buf.append(team.toString());
		}
		return buf.toString();
	}
		
	public String timeString() {
		Iterator<Team> it=teams.iterator();
		StringBuffer buf=new StringBuffer();
		Boolean first=true;
		while (it.hasNext()) {
			Team team=it.next();
			if (first) {
				first=false;
			} else {
				buf.append('|');
			}
			buf.append(team.getTimes());
		}
		return buf.toString();
	}
		
	public void saveTeams(List<Team> teams) {
		prop.setProperty("teams", teamsString());
		saveProperties();
	}
	
	int giveNextTeam(int last) {
		int result=-1;
		if (last>=0) {
			Iterator<Team> it=teams.iterator();
			Boolean found=false;
			while (it.hasNext() && !found) {
				Team t=it.next();
				if (t.startNum>last) {
					result=t.startNum;
					found=true;
				}
			}
		}
		return result;
	}
	
	public void resetTeams() {
		Iterator<Team> it=teams.iterator();
		logger.info("resetTeams ==> old value= "+teamsString());
		while (it.hasNext()) {
			Team t=it.next();
			t.start=new RelativeTime();
			t.finish=new RelativeTime();
		}		
		saveTeams(teams);
	}
	
	public void add(Team team) {
		Iterator<Team> it=teams.iterator();
		Boolean found=false;
		while (it.hasNext() && !found) {
			Team t=it.next();
			if (t.startNum==team.startNum) {
				t.update(team);
				found=true;
			}
		}	
		if (!found) {
			teams.add(team);
		}
		saveTeams(teams);
		
	}
	
	public int teamCount() {
		return teams.size();
	}
	
	public RelativeTime readTime() {
       	RelativeTime time=new RelativeTime();
       	try {
       		this.time=Long.parseLong(prop.getProperty("timestamp"));
       		time.set(this.time, this.time);
       	} catch (Exception e) {
       		time.set(0,0);
       	}
       	return time;
	}
	
	public void saveTime(RelativeTime time) {
		prop.setProperty("timestamp", Long.toString(time.getOffset()));
		saveProperties();
	}
	
	public void setTeamStart(int team, RelativeTime start) {
		Iterator<Team> it=teams.iterator();
		Boolean found=false;
		while (it.hasNext() && !found) {
			Team t=it.next();
			if (t.startNum==team) {
				t.start=start;
				found=true;
			}
		}		
		if (found) {
			saveTeams(teams);
		}
	}
	
	public void setTeamFinish(int team, RelativeTime start) {
		Iterator<Team> it=teams.iterator();
		Boolean found=false;
		while (it.hasNext() && !found) {
			Team t=it.next();
			if (t.startNum==team && t.finish.toString().equals("00:00:00.000")) {
				t.finish=start;
				found=true;
			}
		}		
		if (found) {
			saveTeams(teams);
		}
	}

	public void setTeamFinish(int team, String finish) {
		Iterator<Team> it=teams.iterator();
		Boolean found=false;
		while (it.hasNext() && !found) {
			Team t=it.next();
			if (t.startNum==team && t.finish.toString().equals("00:00:00.000")) {
				long offset=readTime().getOffset();
				t.finish.parse(finish, offset);
				found=true;
			}
		}		
		if (found) {
			saveTeams(teams);
		}
	}
}