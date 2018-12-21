package com.ipartek.formacion.ejercicios.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.ejercicios.modelos.Producto;



@Repository
public class ProductoJdbc implements CrudAble<Producto> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Producto> getAll() {
		String sql ="SELECT id, nombre, imagen,descripcion,precio from producto";
		return jdbcTemplate.query(sql, new ProductoMapper());
	}

	@Override
	public Producto getById(Long id) {
		String sql ="SELECT id, nombre, imagen,descripcion,precio from producto where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new ProductoMapper());
	}

	@Override
	public Producto Validar(Producto t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Producto prod) {
		String sql="Insert into producto (nombre,imagen,descripcion,precio) VALUES (?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] {prod.getNombre(),prod.getImagen(),prod.getDesripcion(),prod.getPrecio()});
		
	}

	@Override
	public void update(Producto t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		String sql= "Delete from producto where id = ?";
		jdbcTemplate.update(sql, new Object[] {id});
		
	}
	
	private static final class ProductoMapper implements RowMapper<Producto> {
		public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Producto(rs.getLong("id"), rs.getString("nombre"),rs.getString("imagen"),
					rs.getString("descripcion"),rs.getDouble("precio"));
		}
	}

}
