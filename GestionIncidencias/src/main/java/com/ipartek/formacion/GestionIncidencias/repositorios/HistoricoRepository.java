package com.ipartek.formacion.GestionIncidencias.repositorios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.GestionIncidencias.modelos.Historico;
import com.ipartek.formacion.GestionIncidencias.modelos.Incidencia;
import com.ipartek.formacion.GestionIncidencias.modelos.Usuario;


@Repository
public class HistoricoRepository implements CrudAble<Historico> {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Historico> getAll() {
		return jdbcTemplate.query("call historicos_getAll()", new HistoricoMapper());
	}

	@Override
	public Historico getById(Long id) {
		return jdbcTemplate.queryForObject("call historicos_getById(?)", new Object[] { id },
				new HistoricoMapper());
	}

	@Override
	public Long insert(Historico historico) {
		return jdbcTemplate.queryForObject("call historicos_insert(?,?,?,?,?)",
				new Object[] { historico.getIncidencia().getId(), historico.getUsuario().getId(), historico.getFecha(), historico.getComentario(), historico.getEstado()}, Long.class);
	}

	@Override
	public void update(Historico historico) {
		jdbcTemplate.update("call historicos_update(?,?,?,?,?,?)",
				new Object[] { historico.getId(), historico.getIncidencia().getId(), historico.getUsuario().getId(), historico.getFecha(), historico.getComentario(), historico.getEstado()});
	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("call historicos_delete(?)", new Object[] { id });
	}
	
	public List<Historico> getHistoricoByIncidenciaId(Long id) {
		return jdbcTemplate.query("call historicos_getByPeticionId(?)", new Object[] { id },
				new HistoricoOpenMapper());
	}

	private static final class HistoricoMapper implements RowMapper<Historico> {
		public Historico mapRow(ResultSet rs, int rowNum) throws SQLException {
			Usuario usuario = new Usuario(rs.getLong("u.id"), rs.getString("u.nombre"), rs.getString("u.email"), rs.getString("u.password"), rs.getString("u.rol"));
		
			return new Historico(rs.getLong("h.id"), null, usuario, rs.getDate("h.fecha"), rs.getString("h.comentario"), rs.getString("h.estado"));
		}
	}
	
	private static final class HistoricoOpenMapper implements RowMapper<Historico> {
		public Historico mapRow(ResultSet rs, int rowNum) throws SQLException {
			Usuario usuario = new Usuario(rs.getLong("h.usuario"), 
										rs.getString("u.nombre"), 
										rs.getString("u.email"), 
										rs.getString("u.password"),
										rs.getString("u.rol"));
			Incidencia incidencia = new Incidencia(rs.getLong("h.incidencia"),
													rs.getDate("i.fecha"),
													rs.getString("i.titulo"),
													rs.getString("i.descripcion"),
													rs.getLong("i.usuarioCreador"),
													rs.getLong("i.usuarioAsignado"));
			return new Historico(rs.getLong("h.id"), incidencia, usuario, rs.getDate("h.fecha"), rs.getString("h.comentario"), rs.getString("h.estado"));
		}
	}
}
