package com.sample.postgress.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.postgress.entity.Team;
public class Team_RowMapper implements RowMapper<Team>{

	@Override
	public Team mapRow(ResultSet rs, int arg1) throws SQLException {
		Team team=new Team();
		team.setTeam_id(rs.getInt("team_id"));
		team.setTeam_email(rs.getString("team_email"));
		team.setTeam_name(rs.getString("team_name"));
		
		return team;
	}
	
}
