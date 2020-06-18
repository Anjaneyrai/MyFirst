package com.sample.postgress.entity;

import java.security.Timestamp;


public class Agreement_Audit {
int id;
Agreement agreement;
String action;
Timestamp date;
User user;
Team team;
String Comment;


public Agreement_Audit() {
	super();
}
public Agreement_Audit(int id, Agreement agreement, String action, Timestamp date, User user, Team team, String comment) {
	super();
	this.id = id;
	this.agreement = agreement;
	this.action = action;
	this.date = date;
	this.user = user;
	this.team = team;
	this.Comment = comment;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Agreement getAgreement() {
	return agreement;
}
public void setAgreement(Agreement agreement) {
	this.agreement = agreement;
}
public String getAction() {
	return action;
}
public void setAction(String action) {
	this.action = action;
}
public Timestamp getDate() {
	return date;
}
public void setDate(Timestamp date) {
	this.date = date;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Team getTeam() {
	return team;
}
public void setTeam(Team team) {
	this.team = team;
}
public String getComment() {
	return Comment;
}
public void setComment(String comment) {
	Comment = comment;
}


}
