package com.ipartek.formacion.editorialrestspring.modelos;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EditorialRowMapper implements RowMapper<Editorial>{
	public Editorial mapRow(ResultSet rs, int rowNum) throws SQLException {
		Editorial editorial = new Editorial();
		editorial.setId(rs.getLong("id"));
		editorial.setNombre(rs.getString("editorial"));
		return editorial;
	}
}
