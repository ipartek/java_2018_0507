package com.ipartek.formacion.GestionIncidencias.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/logout")
@Controller
public class LogoutController{
	
	@PostMapping
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}
}
