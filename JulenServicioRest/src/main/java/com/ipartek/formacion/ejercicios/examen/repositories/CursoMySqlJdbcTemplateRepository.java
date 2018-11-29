package com.ipartek.formacion.ejercicios.examen.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.ipartek.formacion.ejercicios.examen.modelo.Curso;
import com.ipartek.formacion.ejercicios.examen.modelo.Profesor;


@Repository
public class CursoMySqlJdbcTemplateRepository{

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public List<Curso> GetAll() {
		String sql = "SELECT codigo, nombre, identificador, nHoras FROM curso ";
		return jdbcTemplate.query(sql, new CursoMapper());
	}

	public Curso GetById(Long id) {
		String sql = "select codigo, nombre, identificador, nHoras from curso where codigo = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{id}, new CursoMapper());
	}
	
	public List<Curso> CurPro(){
		String sql = "SELECT c.codigo, c.nombre, c.identificador, c.nHoras, p.codigo, p.nombre, p.apellidos\r\n" + 
				"from curso c\r\n" + 
				"inner join profesor p on c.profesor_codigo = p.codigo";
		
		return jdbcTemplate.query(sql, new CursoMapper());
	}
	
	
	private static final class CursoMapper implements RowMapper<Curso> {
		public Curso mapRow(ResultSet rs, int rowNum) throws SQLException {
			Profesor pro;
			pro = new Profesor(rs.getLong("p.codigo"), rs.getString("p.nombre"), rs.getString("p.apellidos"));
			return new Curso(rs.getLong("c.codigo"), rs.getString("c.nombre"),rs.getString("c.identificador"),rs.getInt("c.nHoras"),pro);
		}
	}
}
