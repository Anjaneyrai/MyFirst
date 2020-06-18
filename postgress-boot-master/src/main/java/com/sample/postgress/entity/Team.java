package com.sample.postgress.entity;

public class Team {
int Team_id;
String Team_name;
String Team_email;

public Team() {
	super();
}
public Team(int team_id, String team_name, String team_email) {
	super();
	Team_id = team_id;
	Team_name = team_name;
	Team_email = team_email;
}
public int getTeam_id() {
	return Team_id;
}
public void setTeam_id(int team_id) {
	Team_id = team_id;
}
public String getTeam_name() {
	return Team_name;
}
public void setTeam_name(String team_name) {
	Team_name = team_name;
}
public String getTeam_email() {
	return Team_email;
}
public void setTeam_email(String team_email) {
	Team_email = team_email;
}


}


