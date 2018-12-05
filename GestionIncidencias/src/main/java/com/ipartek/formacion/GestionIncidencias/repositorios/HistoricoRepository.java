package com.ipartek.formacion.GestionIncidencias.repositorios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.GestionIncidencias.modelos.Historico;
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

	private static final class HistoricoMapper implements RowMapper<Historico> {
		public Historico mapRow(ResultSet rs, int rowNum) throws SQLException {
			Usuario usuario = new Usuario(rs.getLong("u.id"), rs.getString("u.nombre"), rs.getString("u.email"), rs.getString("u.password"));
		
			return new Historico(rs.getLong("h.id"), null, usuario, rs.getDate("h.fecha"), rs.getString("h.comentario"), rs.getString("h.estado"));
		}
	}
}
