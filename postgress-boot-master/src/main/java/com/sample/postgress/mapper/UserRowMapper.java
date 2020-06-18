package com.sample.postgress.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.postgress.entity.User;
public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user=new User();
	    user.setUser_id(rs.getInt("user_id"));
	    user.setFirst_name(rs.getString("first_name"));
	    user.setLast_name(rs.getString("last_name"));
	    user.setEmail(rs.getString("email"));
	    user.setPassword(rs.getString("password"));
		return user;
	}
	
}
