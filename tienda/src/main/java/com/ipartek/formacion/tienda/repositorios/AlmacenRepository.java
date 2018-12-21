package com.ipartek.formacion.tienda.repositorios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.tienda.modelos.Almacen;

@Repository
public class AlmacenRepository implements CrudAble<Almacen>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Almacen> getAll() {
		return jdbcTemplate.query("call almacenes_getAll()", new AlmacenMapper());
	}

	@Override
	public Almacen getById(Long id) {
		return jdbcTemplate.queryForObject("call almacenes_getById(?)", new Object[] {id},
				new AlmacenMapper());
	}

	@Override
	public void insert(Almacen t) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	@Override
	public void update(Almacen t) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	@Override
	public void delete(Long id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
	
	private static final class AlmacenMapper implements RowMapper<Almacen> {
		public Almacen mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Almacen(rs.getLong("id"), rs.getString("nombre"), rs.getString("latitud"), rs.getString("longitud"), null);
		}
	}
}
