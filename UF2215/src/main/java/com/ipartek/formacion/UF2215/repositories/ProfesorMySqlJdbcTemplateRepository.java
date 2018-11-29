package com.ipartek.formacion.UF2215.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.UF2215.model.Profesor;

@Repository
public class ProfesorMySqlJdbcTemplateRepository implements RestAble<Profesor> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public List<Profesor> obtenerTodos() {
		return jdbcTemplate.query("select * from profesor", new ProfesorMapper());
	}
	
	private static final class ProfesorMapper implements RowMapper<Profesor> {
		public Profesor mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Profesor(rs.getLong("codigo"), rs.getString("nombre"),rs.getString("apellidos")
			);
		}
	}
}
