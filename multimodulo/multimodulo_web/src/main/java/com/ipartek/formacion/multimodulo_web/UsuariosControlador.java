package com.ipartek.formacion.multimodulo_web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ipartek.formacion.multimodulo_modelo.Usuario;
import com.ipartek.formacion.multimodulo_repositorio.UsuarioRepository;

@Controller
@RequestMapping(path="/usuarios")
public class UsuariosControlador {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping(path="/update")
	public @ResponseBody String update(@RequestParam(required=false) Long id, @RequestParam String email
			, @RequestParam String password) {
		
		Usuario usuario = new Usuario(id, email, password);
		
		usuarioRepository.save(usuario);
		
		return "Guardado";
	}
	
	@GetMapping(path="/delete")
	public @ResponseBody String delete(@RequestParam Long id) {
		usuarioRepository.deleteById(id);
		
		return "Borrado";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Usuario> obtenerTodos() {
		return usuarioRepository.findAll();
	}

	@GetMapping(path="/one")
	public @ResponseBody Optional<Usuario> obtenerUno(@RequestParam Long id) {
		return usuarioRepository.findById(id);
	}

}
