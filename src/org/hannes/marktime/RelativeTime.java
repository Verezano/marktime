package org.hannes.marktime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class RelativeTime {
	private SimpleDateFormat fmt;
	private long offset=0;
	private long time=0;
	
	private void setFormatter() {
		fmt = new SimpleDateFormat("HH:mm:ss.SSS");
		TimeZone tz = TimeZone.getTimeZone("GMT");
		fmt.setTimeZone(tz);		
	}
	
	public RelativeTime() {
		setFormatter();
		offset=new Date().getTime();
		time=offset;
	}
	
	public RelativeTime(Date date) {
		setFormatter();
		offset=date.getTime();
		time=new Date().getTime();
	}
	
	public long getTime() {
		return time;
	}
	
	public long getOffset() {
		return offset;
	}
	
	public void set() {
		time=new Date().getTime();		
	}
	
	public void set(Date date) {
		time=date.getTime();
	}
	
	public void set(long offset, long time) {
		this.offset=offset;
		this.time=time;
	}
	public void parse(String source, long offset) {
		try {
			Date wrk=fmt.parse(source);
			time=offset+wrk.getTime();
			this.offset=offset;
		} catch (Exception e) {			
		}
	}
	
	public String toString() {
		Date out=new Date();
		out.setTime(time-offset);
		return fmt.format(out);
	}
	
	public RelativeTime clone() {
		RelativeTime result=new RelativeTime();
		result.fmt=fmt;
		result.offset=offset;
		result.time=time;
		return result;
	}
}