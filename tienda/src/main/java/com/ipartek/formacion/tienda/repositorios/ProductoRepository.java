package com.ipartek.formacion.tienda.repositorios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.tienda.modelos.Almacen;
import com.ipartek.formacion.tienda.modelos.Producto;
import com.ipartek.formacion.tienda.modelos.Stock;

@Repository
public class ProductoRepository implements CrudAble<Producto>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Producto> getAll() {
		return jdbcTemplate.query("call productos_getAll()", new ProductoMapper());
	}

	@Override
	public Producto getById(Long id) {
		return jdbcTemplate.queryForObject("call productos_getById(?)", new Object[] { id },
				new ProductoMapper());
	}

	@Override
	public void insert(Producto producto) {
		jdbcTemplate.update("call productos_insert(?,?,?,?)",
				new Object[] { producto.getNombre(), producto.getDescripcion(), producto.getPrecio(), producto.getImagen() });
	}

	@Override
	public void update(Producto producto) {
		jdbcTemplate.update("call productos_update(?,?,?,?,?)",
				new Object[] { producto.getId(), producto.getNombre(), producto.getDescripcion(), producto.getPrecio(), producto.getImagen() });
	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("call productos_delete(?)", new Object[] { id });
	}
	
	public List<Producto> getByAlmacen(Long id) {
		return jdbcTemplate.query("call productos_getByAlmacen(?)", new Object[] { id },
				new ProductoMapper2());
	}
	
	public List<Producto> getByAlmacenVacio() {
		return jdbcTemplate.query("call productos_getByAlmacenVacio()",
				new ProductoMapper2());
	}
	
	public void insertCompleto(Producto producto) {
		insert(producto);
		
		jdbcTemplate.update("call productos_insert_stock(?,?,?)",
				new Object[] { producto.getStock().getStock(), producto.getAlmacen().getId()});
	}
	
	public void updateCompleto(Producto producto) {
		update(producto);
	
		jdbcTemplate.update("call productos_update_stock(?,?,?)",
				new Object[] { producto.getStock().getId(), producto.getStock().getStock(), producto.getAlmacen().getId()});
	}

	public void deleteCompleto(Long id) {
		delete(id);
		
		jdbcTemplate.update("call productos_delete_stock(?)", new Object[] {id});
	}
	
	private static final class ProductoMapper implements RowMapper<Producto> {
		public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Producto(rs.getLong("id"), rs.getString("nombre"), rs.getString("descripcion"), rs.getBigDecimal("precio"), rs.getString("imagen"), null, null);
		}
	}
	
	private static final class ProductoMapper2 implements RowMapper<Producto> {
		public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
			Stock stock = new Stock(null, null, null, rs.getLong("s.stock"));
			Almacen almacen = new Almacen(null, rs.getString("a.nombre"), null,null, null);
			return new Producto(rs.getLong("p.id"), rs.getString("p.nombre"), rs.getString("p.descripcion"), rs.getBigDecimal("p.precio"), rs.getString("p.imagen"), almacen, stock);
		}
	}

}
