package com.ipartek.formacion.prestamolibrosspring.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.prestamolibrosspring.model.Libro;

@Repository // Quitando y poniendo el @repository se cambia con que se rellena el objeto editorial al ponerle el autowired
public class LibrolMySqlJdbcTemplateRepository implements CrudAble<Libro> {
	
	
private static LibrolMySqlJdbcTemplateRepository INSTANCE;
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Libro> getAll() {
		// Compatible con <Java8
		return jdbcTemplate.query("call getAllLibro()", new LibroMapper());

//		return jdbcTemplate.query( "select id, nombre from editoriales", new RowMapper<Editorial>() {
//		    public Editorial mapRow(ResultSet rs, int rowNum) throws SQLException {
//		    	return new Editorial(rs.getLong("id"), rs.getString("nombre"));
//		    }
//		});

		// return jdbcTemplate.query("select id, nombre from editoriales", (rs, rowNum)
		// -> // >=Java8
		// new Editorial(rs.getLong("id"), rs.getString("nombre")));
	}

	@Override
	public Libro getById(Long id) {
		return jdbcTemplate.queryForObject("call getByIdLibro(?)", new Object[] { id },
				new LibroMapper());
	}

	@Override
	public Long insert(Libro libro) {
		return jdbcTemplate.queryForObject("call insertarLibro(?,?,?)",
				new Object[] { libro.getTitulo(),libro.getEditorial(),libro.getIsbn() }, Long.class);

//		KeyHolder keyHolder = new GeneratedKeyHolder();

//		>=Java8
//		jdbcTemplate.update(connection -> {
//			PreparedStatement ps = connection.prepareStatement("insert into editoriales (nombre) values (?)",
//				Statement.RETURN_GENERATED_KEYS);
//			ps.setString(1, editorial.getNombre());
//			return ps;
//		}, keyHolder);

		// <Java8
//		jdbcTemplate.update(new PreparedStatementCreator() {
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				PreparedStatement ps = con.prepareStatement("insert into editoriales (nombre) values (?)", 
//						Statement.RETURN_GENERATED_KEYS);
//				ps.setString(1, editorial.getNombre());
//				return ps;
//			}
//		}, keyHolder);
		
//		return (long) keyHolder.getKey();
	}

	@Override
	public void update(Libro libro) {
		jdbcTemplate.update("call modificarLibro(?,?)",
				new Object[] { libro.getTitulo(), libro.getId() });
	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("call borrarLibro(?)", new Object[] { id });
	}

	private static final class LibroMapper implements RowMapper<Libro> {
		public Libro mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Libro(rs.getString("titulo"),rs.getString("editorial"), rs.getLong("isbn"),rs.getInt("idlibro"));
		}
	}
	
	
}
