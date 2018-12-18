package com.ipartek.formacion.springrestcrud.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.springrestcrud.entidades.Comentario;
import com.ipartek.formacion.springrestcrud.entidades.Incidencia;
import com.ipartek.formacion.springrestcrud.entidades.Usuario;
import com.ipartek.formacion.springrestcrud.repositories.CrudAble;


/**
 * Servlet implementation class AgregarPersonaServlet
 */

@Controller
public class ListadoComentarios {
	@Autowired
	private final CrudAble<Comentario> repositorio_com = null;
	@Autowired
	private final CrudAble<Incidencia> repositorio_inc = null;
	@Autowired
	private final CrudAble<Usuario> repositorio_u = null;
	
	
	
	@GetMapping("/AgregarComentario")
	public String AgregarComentario(Model modelo) {
		//System.out.println("en agregar comentario");
		List<Incidencia> lista_inc = repositorio_inc.getAll();
		List<Usuario> lista_usu = repositorio_u.getAll();
		modelo.addAttribute("listaincidencia",lista_inc);
		modelo.addAttribute("listausuario",lista_usu);
		
		return "agregarcomentario";
	}
	
	@GetMapping("/ListadoComentarios")
	public String listadoComentario(Model modelo) {
		//System.out.println("EN listadocomentarios");
		List<Comentario> lista_com = repositorio_com.getAll();
		
		modelo.addAttribute("listacomentarios",lista_com);
			
		return "vercomentarios";
	}
	

	@RequestMapping("/addComentario")
	public String addEquipo(Comentario comentario,Model modelo) {
		repositorio_com.insert(comentario);
		
		List<Comentario> lista = repositorio_com.getAll();	
		modelo.addAttribute("listacomentarios",lista);
			
		return "vercomentarios";
	}
	
	@RequestMapping("/modifComentario")
	public String modifEquipo(Comentario comentario,Model modelo) {
		//System.out.println("En modif comentario");
		//Update
		repositorio_com.update(comentario);
		//EndUpdate
		
		List<Comentario> lista = repositorio_com.getAll();
		
		modelo.addAttribute("listacomentarios",lista);
		
		//el nombre del jsp
		return "vercomentarios";
	}
	
	@GetMapping("/buscarComentarioxIncidencia")
	public String buscarComentarioxIncidencia(String incidencia_id,Model modelo) {

		//System.out.println("incidencia_id:" + incidencia_id);
		
		List<Comentario> lista = repositorio_com.getByIdIncidencia(incidencia_id);
				
		modelo.addAttribute("listacomentarios",lista);
	
		return "vercomentarios";		
	}
	
}
