package com.ipartek.formacion.springrestcrud.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.springrestcrud.entidades.Comentario;
import com.ipartek.formacion.springrestcrud.entidades.Equipo;
import com.ipartek.formacion.springrestcrud.entidades.Estado;
import com.ipartek.formacion.springrestcrud.entidades.Incidencia;
import com.ipartek.formacion.springrestcrud.entidades.Usuario;
import com.ipartek.formacion.springrestcrud.repositories.CrudAble;


@Controller
public class ListadoIncidencias {
	@Autowired
	private final CrudAble<Incidencia> repositorio_i=null;
	@Autowired
	private final CrudAble<Usuario> repositorio_u = null;
	@Autowired
	private final CrudAble<Equipo> repositorio_e=null;
	@Autowired
	private final CrudAble<Estado> repositorio_estad=null;
	@Autowired
	private final CrudAble<Comentario> repositorio_comen=null;
		
	
	
	@RequestMapping("/")
	public String inicio(Usuario usuario, Model modelo) {
		
		System.out.println("Usuario recibido " + usuario.getEmail() + " -  "+usuario.getPassword());
		
		
		//TODO:Comprobar contra usuario en la bd
		System.out.println("repositioriou getusuariologin" + repositorio_u.getUsuarioLogin(usuario));
		
		//Este if no funciona
		if(repositorio_u.getUsuarioLogin(usuario).isEmpty()) {
			System.out.println("Usuario Erroneo");
			return "login";
		}else {
			List<Incidencia> lista = repositorio_i.getAll();
			List<Equipo> lista_e = repositorio_e.getAll();
			List<Usuario> lista_u = repositorio_u.getAll();
			List<Comentario> lista_com = repositorio_comen.getAll();
			
			modelo.addAttribute("listaincidencia",lista);
			modelo.addAttribute("listaequipo",lista_e);
			modelo.addAttribute("listausuario",lista_u);
			modelo.addAttribute("listacomentario",lista_com);
			
			return "home";
		}
	}
	
	
	@GetMapping("/AgregarIncidencia")
	public String AgregarIncidencia(Model modelo) {
		
		modelo.addAttribute("listausuarios",repositorio_u.getAll());
		modelo.addAttribute("listaequipos",repositorio_e.getAll());
		modelo.addAttribute("listaestados",repositorio_estad.getAll());
		
		
		return "agregarincidencia";
	}
	
	@GetMapping("/ListadoIncidencias")
	public String listadoIncidencias(Model modelo) {
		
		List<Incidencia> lista = repositorio_i.getAll();
		
		modelo.addAttribute("listaincidencia",lista);
		modelo.addAttribute("listausuarios",repositorio_u.getAll());
		modelo.addAttribute("listaequipos",repositorio_e.getAll());
		modelo.addAttribute("listaestados",repositorio_estad.getAll());
		
		return "verincidencias";
	}
	
	
	@GetMapping("/buscarIncidencia")
	public String buscarIncidencia(Long id_buscar,Model modelo) {

		System.out.println("ID recibido:" + id_buscar);
		Incidencia incidencia = repositorio_i.getById(id_buscar);
		System.out.println("Incidencia encontrada: " + incidencia);
		if(incidencia!=null) {
			
			modelo.addAttribute("incidencia",incidencia);
			modelo.addAttribute("listausuarios",repositorio_u.getAll());
			modelo.addAttribute("listaequipos",repositorio_e.getAll());
			modelo.addAttribute("listaestados",repositorio_estad.getAll());
			
			return "verincidencia";
		}else {
			
			modelo.addAttribute("incidencia",repositorio_i.getAll());
			modelo.addAttribute("listausuarios",repositorio_u.getAll());
			modelo.addAttribute("listaequipos",repositorio_e.getAll());
			modelo.addAttribute("listaestados",repositorio_estad.getAll());
			return "verincidencias";
		}
		
	}
	
	
	
	@GetMapping("/buscarIncidenciaxEquipo")
	public String buscarIncidenciaxEquipo(String equipo,Model modelo) {

		System.out.println("Equipo recibido:" + equipo);
		
		
		
		List<Incidencia> lista = repositorio_i.getByEquipo(equipo);
				
		modelo.addAttribute("listaincidencia",lista);
		modelo.addAttribute("listausuarios",repositorio_u.getAll());
		modelo.addAttribute("listaequipos",repositorio_e.getAll());
		modelo.addAttribute("listaestados",repositorio_estad.getAll());
		
		return "verincidencias";		
	}
	@GetMapping("/buscarIncidenciaxEstado")
	public String buscarIncidenciaxEstado(String estado,Model modelo) {

		//System.out.println("estado recibido:" + estado);
		
		List<Incidencia> lista = repositorio_i.getByEstado(estado);
				
		modelo.addAttribute("listaincidencia",lista);
		modelo.addAttribute("listausuarios",repositorio_u.getAll());
		modelo.addAttribute("listaequipos",repositorio_e.getAll());
		modelo.addAttribute("listaestados",repositorio_estad.getAll());
		
		return "verincidencias";		
	}
	
	@GetMapping("/buscarIncidenciaxUsuario")
	public String buscarIncidenciaxUsuario(String usuario,Model modelo) {

		System.out.println("Usuario recibido:" + usuario);
		
		
		List<Incidencia> lista = repositorio_i.getByUsuario(usuario);
		
		for(Incidencia str : lista)
		{
		    //imprimimos el objeto pivote
		    System.out.println(str);
		}
		
		modelo.addAttribute("listaincidencia",lista);
		modelo.addAttribute("listausuarios",repositorio_u.getAll());
		modelo.addAttribute("listaequipos",repositorio_e.getAll());
		modelo.addAttribute("listaestados",repositorio_estad.getAll());
		
		return "verincidencias";		
	}
	

	@RequestMapping("/crearIncidencia")
	public String crearIncidencia(Model modelo) {
		List<Usuario> lista = repositorio_u.getAll();
		List<Equipo> lista_equipo=repositorio_e.getAll();
	
	/*	for(Equipo str : lista_equipo)
		{
		    System.out.println(str);
		}
	*/	
		modelo.addAttribute("listausuarios",lista);
		modelo.addAttribute("listaequipos",lista_equipo);
		modelo.addAttribute("listaestados",repositorio_estad.getAll());
		
		return "agregarincidencia";
	}
		

	@RequestMapping("/addIncidencia")
	public String addIncidencia(Incidencia incidencia,Model modelo) {
	//	System.out.println("en AddIncidencia");
		repositorio_i.insert(incidencia);
		List<Incidencia> lista = repositorio_i.getAll();
		modelo.addAttribute("listaincidencia",lista);
		modelo.addAttribute("listausuarios",repositorio_u.getAll());
		modelo.addAttribute("listaequipos",repositorio_e.getAll());
		modelo.addAttribute("listaestados",repositorio_estad.getAll());
		return "verincidencias";
	}
	
	@RequestMapping("/modifIncidencia")
	public String modifIncidencia(Incidencia incidencia,Model modelo) {
	//	System.out.println("en modifIncidencia");
	
		repositorio_i.update(incidencia);
	//		System.out.println(	"Al modificar incidencia.getEstado() " + incidencia.getEstado());
		List<Incidencia> lista = repositorio_i.getAll();
	
		modelo.addAttribute("listaincidencia",lista);
		modelo.addAttribute("listausuarios",repositorio_u.getAll());
		modelo.addAttribute("listaequipos",repositorio_e.getAll());
		modelo.addAttribute("listaestados",repositorio_estad.getAll());
		
		return "verincidencias";
	}
}
