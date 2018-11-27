package com.ipartek.formacion.prestamolibrosspring.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.prestamolibrosspring.model.Editorial;
import com.ipartek.formacion.prestamolibrosspring.model.Libro;
import com.ipartek.formacion.prestamolibrosspring.restapi.RestAble;

@Repository
public class LibroMySqlJdbcTemplateRepository implements RestAble<Libro>{
	
	@Autowired
	private JdbcTemplate jbdccTemplate;

	@Override
	public List<Libro> obtenerTodos() {
		return jbdccTemplate.query("call getLibros()", new LibrolMapper());
	}

	@Override
	public Libro obtenerPorId(Long id) {
		return jbdccTemplate.queryForObject("call getLibrosId(?)", new Object[] {id}, new LibrolMapper());
	}

	@Override
	public Long crear(Libro libro) {
		jbdccTemplate.queryForObject("call insertarL", new Oject[] {libro.getTitulo(),libro.getIsbn(), 
	}

	@Override
	public void modificar(Libro libro) {
		jbdccTemplate.update("Call modificarL(?,?,?)", new Object[] {libro.getId(), libro.getTitulo(), libro.getIsbn()});
	}

	@Override
	public void borrar(Long id) {
		jbdccTemplate.update("Call borrarL(?)", new Object[] {id});
	}
	
	private static final class LibrolMapper implements RowMapper<Libro> {
		public Libro mapRow(ResultSet rs, int rowNum) throws SQLException {
			Editorial ed;
			ed = new Editorial(rs.getLong("id"),rs.getString("nombre"));
			return new Libro(rs.getLong("id"), rs.getString("titulo"), rs.getString("isbn"), ed);
		}
	}

}
