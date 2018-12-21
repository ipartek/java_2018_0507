package com.ipartek.controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.dao.UsuarioMySqlJdbcTemplateRepository;
import com.ipartek.modelos.Producto;


@RestController
public class ControladorRest {
	@Autowired
	private UsuarioMySqlJdbcTemplateRepository repositorio;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/api/productos")
	public List<Producto> getAll() {
		
		return jdbcTemplate.query( "SELECT idproducto, nombre, imagen, descripcion, precio from producto;", new RowMapper<Producto>() {
		    public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
		    	return new Producto(rs.getInt("idproducto"), rs.getString("nombre"), rs.getString("imagen"), rs.getString("descripcion"),  rs.getLong("precio"));
		    }
		});
	}
	
}
