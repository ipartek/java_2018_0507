package com.ipartek.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ipartek.dao.UsuarioMySqlJdbcTemplateRepository;

@Controller
public class ControladorIncidencias {
	
	@Autowired
	private UsuarioMySqlJdbcTemplateRepository repositorio;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/login")
	public String comprobarUsuario(@RequestParam("email") String email,@RequestParam("password") String password) {
        
		repositorio.getByEmail(email);
		
		String cont = jdbcTemplate.queryForObject( "select password from usuario where email = ?", new Object[] { email }, String.class); 
		
		if(password != null && password.equals(cont)) {
			return "home";
		}else {
			return "index";
		}
	}

}
