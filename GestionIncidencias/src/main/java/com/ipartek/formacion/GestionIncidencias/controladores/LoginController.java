package com.ipartek.formacion.GestionIncidencias.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.GestionIncidencias.modelos.Usuario;
import com.ipartek.formacion.GestionIncidencias.repositorios.UsuarioRepository;

@RequestMapping("/home")
@Controller
public class LoginController{

	@Autowired
	private UsuarioRepository repositorio;

	@PostMapping
	public String comprobarLogin(Usuario usuario, BindingResult binding) {
        if(binding.hasErrors()) {
        	return "index";
        }

    	try {
			@SuppressWarnings("unused")
			Usuario checkedUser = repositorio.searchUser(usuario);
			return "home";
		} catch (Exception e) {
			return "index";
		}
	}
}
