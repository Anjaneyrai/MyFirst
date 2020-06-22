package com.sample.postgress.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;
import com.sample.postgress.entity.Agreement_Detail;
import com.sample.postgress.entity.Agreement_Team_Link;
import com.sample.postgress.entity.Message;
import com.sample.postgress.entity.Product;
import com.sample.postgress.entity.Team;
import com.sample.postgress.entity.User;
import com.sample.postgress.entity.User_link_team;
import com.sample.postgress.mapper.Agreement_DetailRowMapper;
import com.sample.postgress.mapper.Agreement_Team_Link_RowMapper;
import com.sample.postgress.mapper.ProductRowMapper;
import com.sample.postgress.mapper.Team_RowMapper;
import com.sample.postgress.mapper.UserRowMapper;
import com.sample.postgress.mapper.User_link_teamRowMapper;
@Repository
public class ProductDaoImpl implements ProductDao {

	NamedParameterJdbcTemplate template;
private MailSender mailsender;
	public ProductDaoImpl(NamedParameterJdbcTemplate template,MailSender mailsender) {
		this.template=template;
		this.mailsender=mailsender;
	}
	@Autowired	
	 JdbcTemplate temp=new JdbcTemplate();
	@Override
	public List<Product> findAll() {
		return template.query("select *from product" ,new ProductRowMapper());
	}
	@Override
	public void insert(Product p) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(Product p) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Product p) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Product getProduct(int id) {
		String sql="select * from product where id=?";
		return temp.queryForObject(sql,new Object[] {id}, new ProductRowMapper());
	}
	@Override
	public List<Message> initiateAgreement(int product_id, String  email, double price,String pass) {
		    String sql="select count(*) from user_table where email=? and password=?";
		    int check=temp.queryForObject(sql,new Object [] {email,pass},Integer.class);
		    if(check!=1) {List<Message> m =new ArrayList<Message>();
		    Message me=new Message("Invalid Credentials");
		    m.add(me); return m;}
		    User user=new User();
		     sql="select * from user_table where email=? and password=?";
		    user=temp.queryForObject(sql,new Object[] {email,pass},new UserRowMapper());
			 sql="select count(*) from agreement";
			Date date=new Date();
			Timestamp ts=new Timestamp(date.getTime());
		int numOfagreements=temp.queryForObject(sql, Integer.class);
	sql="insert into agreement (id,creation_date,update_date,name,initiator) values(:id,:creation_date,:update_date,:name,:initiator)";
 KeyHolder holder = new GeneratedKeyHolder();
    SqlParameterSource param = new MapSqlParameterSource()
			.addValue("id",100+numOfagreements+1)
			.addValue("creation_date",ts)
			.addValue("update_date",ts)
			.addValue("name", "Agreement"+(numOfagreements+1)+ "Initiated")
			.addValue("initiator", user.getUser_id())
			;
    template.update(sql,param, holder);
    sql="select * from user_link_team where user_id=?";
   User_link_team us=new User_link_team();
    us=temp.queryForObject(sql,new Object[] {user.getUser_id()},new User_link_teamRowMapper());
    sql="select count(*) from agreement_team_link";
    int numOfagreteamlink=temp.queryForObject(sql, Integer.class);
    sql="insert into agreement_team_link(id,team,agreement)values(:id,:team,:agreement)";
 
   holder = new GeneratedKeyHolder();
   param = new MapSqlParameterSource()
		   .addValue("id", numOfagreteamlink+1)
			.addValue("team",us.getTeam())
			.addValue("agreement",100+numOfagreements+1)
			;
    template.update(sql,param, holder);
   
    sql="insert into agreement_detail(id,product,agreement,status,team,price)values(:id,:product,:agreement,:status,:team,:price)";
     holder = new GeneratedKeyHolder();
    param = new MapSqlParameterSource()
    		.addValue("id", numOfagreements+1)
 			.addValue("product",product_id)
 			.addValue("agreement",100+numOfagreements+1)
 			.addValue("status","active")
 			.addValue("team",us.getTeam())
 			.addValue("price", price)
 			;
     template.update(sql,param, holder);
     Message me=new Message("Agreement Initiated Succesfully");
     List<Message> m =new ArrayList<Message>();m.add(me);
    return m;
	}

	@Override
	public List<Agreement_Detail> getAll(int name) {
		String sql="select * from agreement_detail where product=? and status!='accepted and finalized'";
		return temp.query(sql,new Object[] {name},new Agreement_DetailRowMapper());
		//return null;
	}

	@Override
	public List<Message> accept(int product_id,int agreement_id,String email,String password) {
		String sql="select count(*) from user_table where email=? and password=?";
	    int check=temp.queryForObject(sql,new Object [] {email,password},Integer.class);
	    if(check!=1) {List<Message> m =new ArrayList<Message>();
	    Message me=new Message("Invalid Credentials");
	    m.add(me); return m;}
	    Date date=new Date();
		Timestamp ts=new Timestamp(date.getTime());
		 User user=new User();
	     sql="select * from user_table where email=? and password=?";
	    user=temp.queryForObject(sql,new Object[] {email,password},new UserRowMapper());
		String sq="select * from agreement_team_link where agreement=?";
	     Agreement_Team_Link ag=new Agreement_Team_Link();
	     ag=temp.queryForObject(sq, new Object[] {agreement_id},new Agreement_Team_Link_RowMapper());
		sql="select * from user_link_team where user_id=?";
		   User_link_team us=new User_link_team();
		    us=temp.queryForObject(sql,new Object[] {user.getUser_id()},new User_link_teamRowMapper());
		    if(us.getTeam()==ag.getTeam()) {List<Message> m =new ArrayList<Message>();
		    Message me=new Message("You cannot accept Your Team Agreement");
		    m.add(me); return m;}
		    sql="select count(*) from agreement_audit";
		    int x=temp.queryForObject(sql, Integer.class);
	    sql="insert into agreement_audit(id,agreement,action,date,user_id,team,comment)values(:id,:agreement,:action,:date,:user_id,:team,:comment)";
	    	
	     KeyHolder holder = new GeneratedKeyHolder();
	    MapSqlParameterSource param = new MapSqlParameterSource()
	    		.addValue("id", x+1)
	 			.addValue("agreement",agreement_id)
	 			.addValue("action","Approval email sent")
	 			.addValue("date",ts)
	 			.addValue("user_id",user.getUser_id())
	 			.addValue("team",us.getTeam())
	 			.addValue("comment","Both teams agreed")
	 			;
	     template.update(sql,param, holder);
	     sql = "update agreement_detail set status=:status where agreement=:agreement";
	     holder=new GeneratedKeyHolder();
	     param = new MapSqlParameterSource()
	    		 .addValue("agreement",agreement_id)
	    		 .addValue("status", "accepted and finalized")
	    		 ;
	     template.update(sql,param, holder);
	    
	     sql="select * from team where team_id=?";
	     Team team=new Team();
	     team=temp.queryForObject(sql, new Object[] {ag.getTeam()},new Team_RowMapper());
	     
	     SimpleMailMessage mail=new SimpleMailMessage();
	    
	     mail.setTo(team.getTeam_email());
	     mail.setSubject("Approval of Agreement");
	     mail.setText("Hello Team "+team.getTeam_name()+" your agreement is approved");
	     mailsender.send(mail);
	     
	     Message me=new Message("Approval Mail Sent");
	     List<Message> m =new ArrayList<Message>();m.add(me);
	    return m;
	}
	@Override
	public List<Message> reject(int product_id,int agreement_id,String email,String password) {
		String sql="select count(*) from user_table where email=? and password=?";
	    int check=temp.queryForObject(sql,new Object [] {email,password},Integer.class);
	    if(check!=1) {List<Message> m =new ArrayList<Message>();
	    Message me=new Message("Invalid Credentials");
	    m.add(me); return m;}
	    User user=new User();
	     sql="select * from user_table where email=? and password=?";
	    user=temp.queryForObject(sql,new Object[] {email,password},new UserRowMapper());
		
	    Date date=new Date();
		Timestamp ts=new Timestamp(date.getTime());
		sql="select * from user_link_team where user_id=?";
		   User_link_team us=new User_link_team();
		    us=temp.queryForObject(sql,new Object[] {user.getUser_id()},new User_link_teamRowMapper());
		    String sq="select * from agreement_team_link where agreement=?";
		    Agreement_Team_Link ag=new Agreement_Team_Link();
		     ag=temp.queryForObject(sq, new Object[] {agreement_id},new Agreement_Team_Link_RowMapper());
		     if(us.getTeam()==ag.getTeam()) {List<Message> m =new ArrayList<Message>();
			    Message me=new Message("You cannot reject Your Team Agreement");
			    m.add(me); return m;}
		     sql="select count(*) from agreement_audit";
			    int x=temp.queryForObject(sql, Integer.class);
	    sql="insert into agreement_audit(id,agreement,action,date,user_id,team,comment)values(:id,:agreement,:action,:date,:user_id,:team,:comment)";
	    	
	     KeyHolder holder = new GeneratedKeyHolder();
	    MapSqlParameterSource param = new MapSqlParameterSource()
	    		.addValue("id",x+1)
	 			.addValue("agreement",agreement_id)
	 			.addValue("action","Rejection email sent")
	 			.addValue("date",ts)
	 			.addValue("user_id",user.getUser_id())
	 			.addValue("team",us.getTeam())
	 			.addValue("comment","Teams Disagreed")
	 			;
	     template.update(sql,param, holder);
	     sql = "update agreement_detail set status=:status where agreement=:agreement";
	     holder=new GeneratedKeyHolder();
	     param = new MapSqlParameterSource()
	    		 .addValue("agreement",agreement_id)
	    		 .addValue("status", "rejected")
	    		 ;
	     template.update(sql,param, holder);
	    
	     sql="select * from team where team_id=?";
	     Team team=new Team();
	     team=temp.queryForObject(sql, new Object[] {ag.getTeam()},new Team_RowMapper());
	     
	     SimpleMailMessage mail=new SimpleMailMessage();
	    
	     mail.setTo(team.getTeam_email());
	     mail.setSubject("Rejection of Agreement");
	     mail.setText("Hello Team "+team.getTeam_name()+" your agreement is rejected");
	     mailsender.send(mail);
	     Message me=new Message("Rejection Mail Sent");
	     List<Message> m =new ArrayList<Message>();   
		    m.add(me); return m;
	}


}
