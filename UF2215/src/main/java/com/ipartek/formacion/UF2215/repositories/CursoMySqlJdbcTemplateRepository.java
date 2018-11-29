package com.ipartek.formacion.UF2215.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.UF2215.model.Curso;

@Repository
public class CursoMySqlJdbcTemplateRepository implements RestAble<Curso> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public List<Curso> obtenerTodos() {
		return jdbcTemplate.query("select * from curso", new CursoMapper());
	}
	
	private static final class CursoMapper implements RowMapper<Curso> {
		public Curso mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Curso(rs.getLong("codigo"), rs.getString("nombre"), rs.getString("identificador")
					,rs.getString("nHoras"),rs.getString("profesor_codigo")
			);
		}
	}
}
