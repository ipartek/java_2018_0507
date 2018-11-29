package com.ipartek.formacion.ejercicios.examen.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.ejercicios.examen.RestApi.RestAble;
import com.ipartek.formacion.ejercicios.examen.modelo.Curso;


@Repository
public class CursoMySqlJdbcTemplateRepository implements RestAble<Curso>{

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Curso> GetAll() {
		String sql = "SELECT codigo, nombre, identificador, nHoras FROM curso ";
		return jdbcTemplate.query(sql, new CursoMapper());
	}

	@Override
	public Curso GetById(Long id) {
		String sql = "select codigo, nombre, identificador, nHoras from curso where codigo = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{id}, new CursoMapper());
	}

	private static final class CursoMapper implements RowMapper<Curso> {
		public Curso mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Curso(rs.getLong("codigo"), rs.getString("nombre"),rs.getString("identificador"),rs.getInt("nHoras"));
		}
	}
}
