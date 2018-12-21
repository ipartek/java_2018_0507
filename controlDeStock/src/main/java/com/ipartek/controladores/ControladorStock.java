package com.ipartek.controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ipartek.dao.UsuarioMySqlJdbcTemplateRepository;
import com.ipartek.modelos.Producto;

@Controller
public class ControladorStock {
	
	@Autowired
	private UsuarioMySqlJdbcTemplateRepository repositorio;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/login")
	public String comprobarUsuario(@RequestParam("usuario") String usuario,@RequestParam("password") String password) {
        
		repositorio.getByUsuario(usuario);
		
		String cont = jdbcTemplate.queryForObject( "select password from usuario where nombre = ?", new Object[] { usuario }, String.class); 
		String admin = jdbcTemplate.queryForObject( "select admin from usuario where nombre = ?", new Object[] { usuario }, String.class);
		int admin1 = Integer.parseInt(admin);
		
		if(password != null && password.equals(cont)) {
			if(admin1 == 0) {
				return "home";
			}else {
				return "homeadmin";
			}
		}else {
			return "index";
		}
	}

}
