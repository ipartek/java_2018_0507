package com.ipartek.formacion.UF2215.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.UF2215.model.Alumno;

@Repository
public class AlumnoMySqlJdbcTemplateRepository implements RestAble<Alumno> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public List<Alumno> obtenerTodos() {
		return jdbcTemplate.query("select * from alumno", new AlumnoMapper());
	}
	
	private static final class AlumnoMapper implements RowMapper<Alumno> {
		public Alumno mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Alumno(rs.getLong("codigo"), rs.getString("nombre"),rs.getString("apellidos")
			);
		}
	}
}
