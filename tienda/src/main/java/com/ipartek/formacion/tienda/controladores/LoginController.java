package com.ipartek.formacion.tienda.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.tienda.modelos.Usuario;
import com.ipartek.formacion.tienda.repositorios.UsuarioRepository;

@RequestMapping("/home")
@Controller
public class LoginController{

	@Autowired
	private UsuarioRepository repositorio;

	@PostMapping
	public String comprobarLogin(Usuario usuario, BindingResult binding, Model model, HttpServletRequest request) {
        if(binding.hasErrors()) {
        	model.addAttribute("error", "Error en el login");
        	return "index";
        }

    	try {
			Usuario checkedUser = repositorio.searchUser(usuario);
			request.getSession().setAttribute("user", checkedUser);
			return "home";
		} catch (Exception e) {
			model.addAttribute("error", "El usuario no existe");
			return "index";
		}
	}
}
