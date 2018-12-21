package com.ipartek.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ipartek.modelos.Producto;
import com.ipartek.modelos.Usuario;

@Repository
public class UsuarioMySqlJdbcTemplateRepository implements CrudAble{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Usuario getByUsuario(String usuario) {
		return new Usuario();
	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getById(Long id) {
		return jdbcTemplate.queryForObject("call getById(?)", new Object[] { id },
				new ProductoMapper());
		}

	

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("call borrar(?)", new Object[] { id });
		
	}
	
	private static final class ProductoMapper implements RowMapper<Producto> {
		public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Producto(rs.getInt("idproducto"), rs.getString("nombre"), rs.getString("imagen"), rs.getString("descripcion"),  rs.getLong("precio"));
		}
	}

	@Override
	public void update(Object t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long insert(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

}
