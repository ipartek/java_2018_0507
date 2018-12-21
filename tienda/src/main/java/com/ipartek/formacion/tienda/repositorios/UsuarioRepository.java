package com.ipartek.formacion.tienda.repositorios;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.tienda.modelos.Usuario;


@Repository
public class UsuarioRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Usuario searchUser(Usuario usuario) {
		return jdbcTemplate.queryForObject("call usuarios_login(?,?)",
				new Object[] { usuario.getNombre(), usuario.getContraseña()},
				new UsuarioMapper());
	}

	private static final class UsuarioMapper implements RowMapper<Usuario> {
		public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Usuario(rs.getLong("id"), rs.getString("nombre"), rs.getString("contraseña"), rs.getString("rol"));
		}
	}
}
