package com.ipartek.formacion.GestionIncidencias.repositorios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.GestionIncidencias.modelos.Usuario;


@Repository
public class UsuarioRepository implements CrudAble<Usuario> {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Usuario> getAll() {
		return jdbcTemplate.query("call usuarios_getAll()", new UsuarioMapper());
	}

	@Override
	public Usuario getById(Long id) {
		return jdbcTemplate.queryForObject("call usuarios_getById(?)", new Object[] { id },
				new UsuarioMapper());
	}

	@Override
	public Long insert(Usuario usuario) {
		return jdbcTemplate.queryForObject("call usuarios_insert(?,?,?,?)",
				new Object[] { usuario.getNombre(), usuario.getEmail(), usuario.getPassword(), usuario.getRol() }, Long.class);
	}

	@Override
	public void update(Usuario usuario) {
		jdbcTemplate.update("call usuarios_update(?,?,?,?,?)",
				new Object[] { usuario.getId(), usuario.getNombre(), usuario.getEmail(), usuario.getPassword(), usuario.getRol() });
	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("call usuarios_delete(?)", new Object[] { id });
	}
	
	public Usuario searchUser(Usuario usuario) {
		return jdbcTemplate.queryForObject("call usuarios_search(?,?)",
				new Object[] { usuario.getEmail(), usuario.getPassword()},
				new UsuarioMapper());
	}

	private static final class UsuarioMapper implements RowMapper<Usuario> {
		public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Usuario(rs.getLong("id"), rs.getString("nombre"), rs.getString("email"), rs.getString("password"), rs.getString("rol"));
		}
	}
}
