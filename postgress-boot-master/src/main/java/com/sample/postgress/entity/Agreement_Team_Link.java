package com.sample.postgress.entity;

public class Agreement_Team_Link {
	Integer id;
	int team;
	int agreement;
	
	
	public Agreement_Team_Link() {
		super();
	}
	public Agreement_Team_Link(Integer id, int team, int agreement) {
		super();
		this.id = id;
		this.team = team;
		this.agreement = agreement;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getTeam() {
		return team;
	}
	public void setTeam(int team) {
		this.team = team;
	}
	public int getAgreement() {
		return agreement;
	}
	public void setAgreement(int agreement) {
		this.agreement = agreement;
	}
	
	
}
