package com.sample.postgress.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.postgress.entity.Agreement_Detail;
public class Agreement_DetailRowMapper implements RowMapper<Agreement_Detail> {

	@Override
	public Agreement_Detail mapRow(ResultSet rs, int arg) throws SQLException {
	   Agreement_Detail ad = new Agreement_Detail();
	   ad.setId(rs.getInt("id"));
	   ad.setProduct(rs.getInt("product"));
	   ad.setAgreement(rs.getInt("agreement"));
	   ad.setStatus(rs.getString("status"));
	   ad.setTeam(rs.getInt("team"));
	   ad.setPrice(rs.getInt("price"));
	   return ad;
	}

}
