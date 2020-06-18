package com.sample.postgress.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.sample.postgress.entity.User_link_team;
public class User_link_teamRowMapper implements RowMapper<User_link_team>
{

	@Override
	public User_link_team mapRow(ResultSet rs, int arg) throws SQLException {
		User_link_team user=new User_link_team();
		user.setId(rs.getInt("id"));
		user.setTeam(rs.getInt("team_id"));
		user.setUser(rs.getInt("user_id"));
		return user;
	}
	
}