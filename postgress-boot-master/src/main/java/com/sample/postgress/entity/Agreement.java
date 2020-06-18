package com.sample.postgress.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Agreement {
int id;
Timestamp creation_Date;
Timestamp update_Date;
String name;
User initiator;
public Agreement() {
	super();
}
public Agreement(int id, Timestamp creation_Date, Timestamp update_Date, String name, User initiator) {
	super();
	this.id = id;
	this.creation_Date = creation_Date;
	this.update_Date = update_Date;
	this.name = name;
	this.initiator = initiator;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getCreation_Date() {
	return creation_Date;
}
public void setCreation_Date(Timestamp creation_Date) {
	this.creation_Date = creation_Date;
}
public Date getUpdate_Date() {
	return update_Date;
}
public void setUpdate_Date(Timestamp update_Date) {
	this.update_Date = update_Date;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public User getInitiator() {
	return initiator;
}
public void setInitiator(User initiator) {
	this.initiator = initiator;
}

}
