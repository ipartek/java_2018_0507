package com.ipartek.formacion.prestamolibrosspring.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.prestamolibrosspring.model.Editorial;


@Repository
public class EditorialMySqlJdbcTemplateRepository implements CrudAble<Editorial> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Editorial> getAll() {
		// Compatible con <Java8
		return jdbcTemplate.query("call getAll()", new EditorialMapper());

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
	public Editorial getById(Long id) {
		return jdbcTemplate.queryForObject("call getById(?)", new Object[] { id },
				new EditorialMapper());
	}

	@Override
	public Long insert(Editorial editorial) {
		return jdbcTemplate.queryForObject("call insertar(?)",
				new Object[] { editorial.getNombre() }, Long.class);

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
	public void update(Editorial editorial) {
		jdbcTemplate.update("call modificar(?,?)",
				new Object[] { editorial.getNombre(), editorial.getId() });
	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("call borrar(?)", new Object[] { id });
	}

	private static final class EditorialMapper implements RowMapper<Editorial> {
		public Editorial mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Editorial(rs.getLong("id"), rs.getString("nombre"));
		}
	}
}
