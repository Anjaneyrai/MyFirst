package com.sample.postgress.entity;

public class User_link_team {
int id;
int team;
int user;

public User_link_team() {
	super();
}
public User_link_team(int id, int team, int user) {
	super();
	this.id = id;
	this.team = team;
	this.user = user;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getTeam() {
	return team;
}
public void setTeam(int team) {
	this.team = team;
}
public int getUser() {
	return user;
}
public void setUser(int user) {
	this.user = user;
}

}
