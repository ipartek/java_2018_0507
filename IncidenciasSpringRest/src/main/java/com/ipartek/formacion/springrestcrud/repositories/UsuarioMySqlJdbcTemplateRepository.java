package com.ipartek.formacion.springrestcrud.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.springrestcrud.entidades.Usuario;

@Repository
public class UsuarioMySqlJdbcTemplateRepository implements CrudAble<Usuario> {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Usuario> getAll() {
		return jdbcTemplate.query("select * from usuario", new UsuarioMapper());
	}
	
	private static final class UsuarioMapper implements RowMapper<Usuario> {
		public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Usuario(rs.getLong("id"),rs.getString("email"),rs.getString("password"),
					 rs.getString("equipo")
					);
		}
	}
	@Override
	public List<Usuario> getUsuarioLogin(Usuario usuario) {	
		System.out.println(usuario.getEmail() + " - " +usuario.getPassword());
		return jdbcTemplate.query("select * from usuario where email=? and password=?",
				new Object[] { usuario.getEmail(),usuario.getPassword() }
		, new UsuarioMapper());
	}

	
	@Override
	public Usuario getById(Long id) {
		return jdbcTemplate.queryForObject("call getById(?)", new Object[] { id },
				new UsuarioMapper());
	}

	@Override
	public void insert(Usuario usuario) {
		jdbcTemplate.update("insert into usuario (email,password,equipo"
				+ ") values (?,?,?)",
				new Object[] { 
							usuario.getEmail(),usuario.getPassword(),usuario.getEquipo(), 
						});

	}

	@Override
	public void update(Usuario usuario) {
		jdbcTemplate.update("update usuario set email=?,password=?,equipo=? where id=?",
				new Object[] { 
						usuario.getEmail(),usuario.getPassword(),usuario.getEquipo(),usuario.getId() });
	}

	@Override
	public void delete(Long id) {
		
		//TODO:Hacer??
		jdbcTemplate.update("call borrar(?)", new Object[] { id });
		
	}	
}
