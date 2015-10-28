package org.hannes.marktime;

import org.apache.log4j.Logger;

public class Team {
	final static Logger logger = Logger.getLogger(Team.class);
	public int          heat;
	public int			startNum;
	public int			teamNum;
	public String		name;
	public String       dhmix;
	public String       type;
	public String		category;
	public RelativeTime	start;
	public RelativeTime	finish;
	
	Team(String[] parms, long offset) {
		try {
			heat=Integer.parseInt(parms[0]);
		} catch (Exception e) {
			
		}
		try {
			startNum=Integer.parseInt(parms[1]);
		} catch (Exception e) {
			
		}
		try {
			teamNum=Integer.parseInt(parms[2]);
		} catch (Exception e) {
			
		}
		this.name=parms[3];
		dhmix=parms[4];
		category=parms[5];
		type=parms[6];
		if (parms.length==9) {
			try {
				start = new RelativeTime();
				start.parse(parms[7], offset);
				finish = new RelativeTime();
				finish.parse(parms[8],offset);
			} catch (Exception e) {
				start=new RelativeTime();
				finish=new RelativeTime();
			}			
		} else {
			start=new RelativeTime();
			finish=new RelativeTime();
		}
		logger.info("Startnum="+startNum+" TeamNum="+teamNum+" Name="+name+" Type="+type+" Category="+category+" Start="+start.toString()+" Finish="+finish.toString());
	}
	
	public Object[] giveData() {
		Object[] data= { heat, startNum, name, dhmix, category, type, start.toString(), finish.toString() }; 
		return data;
	}
	
	public String toString() {
		return heat+","+startNum+","+teamNum+","+name+","+dhmix+","+category+","+type+","+start+","+finish;
	}
	
	public String getTimes() {
		return teamNum+","+start+","+finish;
	}
	
	public void update(Team team) {
		heat		=team.heat;
		startNum	=team.startNum;
		teamNum		=team.teamNum;
		name		=team.name;
		dhmix		=team.dhmix;
		type		=team.type;
		category	=team.category;
	}
}