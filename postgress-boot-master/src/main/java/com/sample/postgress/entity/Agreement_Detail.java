package com.sample.postgress.entity;

public class Agreement_Detail {
int id;
int product;
int  agreement;
int  team;
double price;
String status;
public Agreement_Detail() {
	super();
}

public Agreement_Detail(int id, int product, int agreement, int team, double price, String status) {
	super();
	this.id = id;
	this.product = product;
	this.agreement = agreement;
	this.team = team;
	this.price = price;
	this.status = status;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getProduct() {
	return product;
}
public void setProduct(int product) {
	this.product = product;
}
public int getAgreement() {
	return agreement;
}
public void setAgreement(int agreement) {
	this.agreement = agreement;
}
public int getTeam() {
	return team;
}
public void setTeam(int team) {
	this.team = team;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}

	
}
