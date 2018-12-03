package com.ipartek.formacion.springrestcrud.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.springrestcrud.entidades.Incidencia;

@Repository
public class IncidenciasMySqlJdbcTemplateRepository implements CrudAble<Incidencia> {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Incidencia> getAll() {
		return jdbcTemplate.query("select * from incidencia", new IncidenciaMapper());
	}

	private static final class IncidenciaMapper implements RowMapper<Incidencia> {
		public Incidencia mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Incidencia(rs.getLong("id"), rs.getString("fecha"),rs.getString("usuario_creador"),
					 rs.getString("titulo"), rs.getString("descripcion"), rs.getString("equipo"), 
					 rs.getString("usuario_asignado")
					);
		}
	}

	@Override
	public Incidencia getById(Long id) {
		return jdbcTemplate.queryForObject("call getById(?)", new Object[] { id },
				new IncidenciaMapper());
	}

	@Override
	public Long insert(Incidencia incidencia) {
		//CREAR PROCEDURES
			return jdbcTemplate.queryForObject("call insertar(?)",
					new Object[] { incidencia.getFecha(),incidencia.getUsuario_creador() , 
							incidencia.getTitulo(),incidencia.getDescripcion(),incidencia.getEquipo(),
							incidencia.getUsuario_asignado(), }, Long.class);

	}

	@Override
	public void update(Incidencia incidencia) {
		jdbcTemplate.update("call modificar(?,?)",
				new Object[] { incidencia.getTitulo(), incidencia.getId() });
		
	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("call borrar(?)", new Object[] { id });
		
	}	
}
