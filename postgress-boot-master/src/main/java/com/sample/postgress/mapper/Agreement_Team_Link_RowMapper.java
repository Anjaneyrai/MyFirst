package com.sample.postgress.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.postgress.entity.Agreement_Team_Link;
public class Agreement_Team_Link_RowMapper implements RowMapper<Agreement_Team_Link> {

	@Override
	public Agreement_Team_Link mapRow(ResultSet rs, int arg) throws SQLException {
		Agreement_Team_Link ag=new  Agreement_Team_Link();
		ag.setId(rs.getInt("id"));
		ag.setTeam(rs.getInt("team"));
		ag.setAgreement(rs.getInt("agreement"));
		return ag;
	}

	
}
