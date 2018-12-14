package com.ipartek.formacion.ejercicios.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.ejercicios.modelo.Usuario;


@Repository
public class UsuariosJdbc implements CrudAble<Usuario>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Usuario> getAll() {
		
		String sql = "SELECT id, email, password from usuario";
		return jdbcTemplate.query(sql, new UsuariolMapper());
	}

	@Override
	public Usuario getById(Long id) {
		String sql = "SELECT id, email, password from usuario where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new UsuariolMapper());
	}

	@Override
	public void insert(Usuario t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Usuario t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	private static final class UsuariolMapper implements RowMapper<Usuario> {
		public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Usuario(rs.getLong("id"), rs.getString("email"), rs.getString("password"));
		}
	}

}
