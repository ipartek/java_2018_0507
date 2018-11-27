package com.ipartek.formacion.editorialrestspring.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.editorialrestspring.modelos.Libro;
import com.ipartek.formacion.editorialrestspring.modelos.Editorial;

@Repository
public class LibroRepository implements CrudAble<Libro> {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Libro> getAll() {
		return jdbcTemplate.query("call libros_getAll()", new LibroMapper());
	}

	@Override
	public Libro getById(Long id) {
		return jdbcTemplate.queryForObject("call libros_getById(?)", new Object[] { id },
				new LibroMapper());
	}

	@Override
	public Long insert(Libro libro) {
		return jdbcTemplate.queryForObject("call libros_insert(?,?,?)",
				new Object[] { libro.getTitulo(), libro.getIsbn(), libro.getEditorial().getId() }, Long.class);
	}

	@Override
	public void update(Libro libro) {
		jdbcTemplate.update("call libros_update(?,?,?,?)",
				new Object[] { libro.getId(), libro.getTitulo(), libro.getIsbn(), libro.getEditorial().getId()});
	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("call libros_DeleteById(?)", new Object[] { id });
	}

	private static final class LibroMapper implements RowMapper<Libro> {
		public Libro mapRow(ResultSet rs, int rowNum) throws SQLException {
			Editorial editorial = new Editorial(rs.getLong("e.id"),
					rs.getString("e.editorial"));
			Libro libro = new Libro(rs.getLong("l.id"), 
				rs.getString("l.titulo"),
				rs.getString("l.ISBN"),
				editorial);
				
			return libro;
		}
	}
}
