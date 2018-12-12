package com.ipartek.formacion.GestionIncidencias.repositorios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.GestionIncidencias.modelos.Incidencia;
import com.ipartek.formacion.GestionIncidencias.modelos.Usuario;

@Repository
public class IncidenciaRepository implements CrudAble<Incidencia> {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Incidencia> getAll() {
		return jdbcTemplate.query("call incidencias_getAll()", new IncidenciaMapper());
	}

	@Override
	public Incidencia getById(Long id) {
		return jdbcTemplate.queryForObject("call incidencias_getById(?)", new Object[] { id },
				new IncidenciaMapper());
	}

	@Override
	public Long insert(Incidencia incidencia) {
		return jdbcTemplate.queryForObject("call incidencias_insert(?,?,?,?,?)",
				new Object[] { incidencia.getUsuarioCreador(), incidencia.getUsuarioAsignado(), incidencia.getFecha(), incidencia.getTitulo(), incidencia.getDescripcion() }, Long.class);
	}

	@Override
	public void update(Incidencia incidencia) {
		jdbcTemplate.update("call incidencias_update(?,?,?,?,?,?)",
				new Object[] { incidencia.getId(), incidencia.getUsuarioCreador(), incidencia.getUsuarioAsignado(), incidencia.getFecha(), incidencia.getTitulo(), incidencia.getDescripcion()});
	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("call incidencias_delete(?)", new Object[] { id });
	}
	
	public List<Incidencia>  getByIdUsuario(Long id) {
		return jdbcTemplate.query("call incidencias_getByUserId(?)", new Object[] { id },
				new IncidenciaMapper());
	} 

	private static final class IncidenciaMapper implements RowMapper<Incidencia> {
		public Incidencia mapRow(ResultSet rs, int rowNum) throws SQLException {
			Usuario usuarioCreador = new Usuario(rs.getLong("i.usuarioCreador"), rs.getString("u.nombre"), rs.getString("u.email"),rs.getString("u.password"));
			Usuario usuarioAsignado = new Usuario(rs.getLong("i.usuarioAsignado"), rs.getString("v.nombre"), rs.getString("v.email"),rs.getString("v.password"));
			
			return new Incidencia(rs.getLong("i.id"), 
									rs.getDate("i.fecha"), 
									usuarioCreador, 
									rs.getString("titulo"), 
									rs.getString("descripcion"),
									usuarioAsignado);
		}
	}
}
