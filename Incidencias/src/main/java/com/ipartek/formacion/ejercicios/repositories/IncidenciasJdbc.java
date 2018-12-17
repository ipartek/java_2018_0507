package com.ipartek.formacion.ejercicios.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.ejercicios.modelo.Incidencia;



@Repository
public class IncidenciasJdbc implements CrudAble <Incidencia> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Incidencia> getAll() {
		String sql ="SELECT id, fecha, titulo, descripcion, usuario_id from incidencia";
		return jdbcTemplate.query(sql, new IncidenciaMapper());
	}

	@Override
	public Incidencia getById(Long id) {
		String sql ="SELECT id, fecha, titulo, descripcion, usuario_id from incidencia where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new IncidenciaMapper());
	}

	@Override
	public void insert(Incidencia t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Incidencia t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	private static final class IncidenciaMapper implements RowMapper<Incidencia> {
		public Incidencia mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Incidencia(rs.getLong("id"), rs.getDate("fecha"), rs.getString("titulo"),rs.getString("descripcion"),rs.getLong("usuario_id"));
		}
	}

}
