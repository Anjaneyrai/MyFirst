CREATE TABLE agreement_audit (id SERIAL NOT NULL,agreement INT REFERENCES agreement(id) NOT NULL,action VARCHAR(200) NOT NULL,date TIMESTAMP NOT NULL,user_id INT REFERENCES user_table(user_id) NOT NULL,team INT REFERENCES team(team_id) NOT NULL,Comment varchar(200),PRIMARY KEY(id));    
CREATE TABLE agreement_detail(id SERIAL  NOT NULL,product INT REFERENCES product(id)  NOT NULL,agreement INT REFERENCES agreement(id)  NOT NULL,status VARCHAR(200),team INT REFERENCES team(team_id) NOT NULL,price float,PRIMARY KEY (id));
CREATE TABLE agreement_team_link(id SERIAL  NOT NULL,team INT REFERENCES team(team_id) NOT NULL,agreement INT REFERENCES agreement(id)  NOT NULL,PRIMARY KEY (id));
CREATE TABLE agreement(id  INT NOT NULL,creation_Date TIMESTAMP,update_Date TIMESTAMP,name VARCHAR(200),initiator INT REFERENCES user_table(user_id),PRIMARY KEY(id));
CREATE TABLE product(id SERIAL NOT NULL, name varchar(200) NOT NULL,description varchar(200) DEFAULT NULL ,PRIMARY KEY(id));
CREATE TABLE user_link_team(id INT NOT NULL,team_id INT REFERENCES team(team_id) NOT NULL,user_id INT REFERENCES user_table(user_id) NOT NULL,PRIMARY KEY (id));
CREATE TABLE team (team_id SERIAL NOT NULL, team_name varchar(200) NOT NULL,team_email varchar(200) NOT NULL,PRIMARY KEY(team_id)); 
CREATE TABLE user_table(
 user_id SERIAL NOT NULL,
  first_name varchar(100) NOT NULL ,
 last_name varchar(100) DEFAULT NULL,
 email varchar(200) NOT NULL,
password varchar(100), PRIMARY KEY (user_id)
);