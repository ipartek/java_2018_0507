package com.javierlete.testjsp.repositories;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.javierlete.testjsp.model.Usuario;

@Repository
public class UsuarioMySqlJdbcTemplateRepository implements CrudAble<Usuario> {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Usuario> getAll() {
		// Compatible con <Java8
		System.out.println("entregamos todos los registros de la tabla cursos");
		return jdbcTemplate.query("select * from usuario", new UsuarioMapper());
		
	}
	


	private static final class UsuarioMapper implements RowMapper<Usuario> {
		public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Usuario(rs.getString("email"), rs.getString("password"));
		}
	}
}
