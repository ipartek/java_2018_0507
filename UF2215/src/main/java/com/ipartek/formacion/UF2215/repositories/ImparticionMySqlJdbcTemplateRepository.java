package com.ipartek.formacion.UF2215.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.UF2215.model.Imparticion;

@Repository
public class ImparticionMySqlJdbcTemplateRepository implements RestAble<Imparticion> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public List<Imparticion> obtenerTodos() {
		return jdbcTemplate.query("SELECT alumno.nombre,alumno.apellidos,curso.nombre,curso.identificador,curso.nHoras ,profesor.nombre " + 
				"FROM alumno " + 
				"INNER JOIN imparticion ON alumno.codigo = imparticion.alumno_codigo " + 
				"inner join curso on imparticion.curso_codigo=curso.codigo " + 
				"inner join profesor on profesor.codigo=curso.profesor_codigo", new ImparticionMapper());
	}
	
	
	private static final class ImparticionMapper implements RowMapper<Imparticion> {
		public Imparticion mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Imparticion(
					
			rs.getString("alumno.nombre"),rs.getString("alumno.apellidos"),rs.getString("curso.nombre")
			,rs.getString("curso.identificador"),rs.getString("curso.nHoras")
			,rs.getString("profesor.nombre")
			
		);
		}
	}
}
