package com.ipartek.formacion.editorialrestspring.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.editorialrestspring.modelos.Editorial;

@Repository
public class EditorialRepository implements CrudAble<Editorial> {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Editorial> getAll() {
		return jdbcTemplate.query("call editoriales_getAll()", new EditorialMapper());
	}

	@Override
	public Editorial getById(Long id) {
		return jdbcTemplate.queryForObject("call editoriales_getById(?)", new Object[] { id },
				new EditorialMapper());
	}

	@Override
	public Long insert(Editorial editorial) {
		return jdbcTemplate.queryForObject("call editoriales_insert(?)",
				new Object[] { editorial.getNombre() }, Long.class);
	}

	@Override
	public void update(Editorial editorial) {
		jdbcTemplate.update("call editoriales_update(?,?)",
				new Object[] { editorial.getId(), editorial.getNombre() });
	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("call editoriales_DeleteById(?)", new Object[] { id });
	}

	private static final class EditorialMapper implements RowMapper<Editorial> {
		public Editorial mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Editorial(rs.getLong("id"), rs.getString("editorial"));
		}
	}
}
