package com.ipartek.formacion.editorialrestspring.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.editorialrestspring.modelos.Alumno;

@Repository
public class AlumnoRepository implements CrudAble<Alumno> {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Alumno> getAll() {
		return jdbcTemplate.query("call alumnos_getAll()", new AlumnoMapper());
	}

	@Override
	public Alumno getById(Long id) {
		return jdbcTemplate.queryForObject("call alumnos_getById(?)", new Object[] { id },
				new AlumnoMapper());
	}

	@Override
	public Long insert(Alumno alumno) {
		return jdbcTemplate.queryForObject("call alumnos_insert(?,?,?)",
				new Object[] { alumno.getNombre(), alumno.getApellido(), alumno.getDni() }, Long.class);
	}

	@Override
	public void update(Alumno alumno) {
		jdbcTemplate.update("call alumnos_update(?,?,?,?)",
				new Object[] {alumno.getId(), alumno.getNombre(), alumno.getApellido(), alumno.getDni()});
	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("call alumnos_DeleteById(?)", new Object[] { id });
	}

	private static final class AlumnoMapper implements RowMapper<Alumno> {
		public Alumno mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Alumno(rs.getLong("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("dni"));
		}
	}
}
