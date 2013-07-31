package com.makotogroup.intro;

public class Character {
	
	public Character(String name, String region, String server, String guild,
			int dps, String date, String time, int ilvl) {
		this.name = name;
		this.region = region;
		this.server = server;
		this.guild = guild;
		this.dps = dps;
		this.date = date;
		this.time = time;
		this.ilvl = ilvl;
	}
	
	public Character() {
		// TODO Auto-generated constructor stub
	}

	private String name;
	private String region;
	private String server;
	private String guild;
	private int dps;
	private String  date;
	private String time;
	private int ilvl;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public String getGuild() {
		return guild;
	}
	public void setGuild(String guild) {
		this.guild = guild;
	}
	public int getDps() {
		return dps;
	}
	public void setDps(int dps) {
		this.dps = dps;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getIlvl() {
		return ilvl;
	}
	public void setIlvl(int ilvl) {
		this.ilvl = ilvl;
	}
}


