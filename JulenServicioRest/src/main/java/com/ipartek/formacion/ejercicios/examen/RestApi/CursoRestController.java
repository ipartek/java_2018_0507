package com.ipartek.formacion.ejercicios.examen.RestApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.ejercicios.examen.modelo.Curso;
import com.ipartek.formacion.ejercicios.examen.repositories.CursoMySqlJdbcTemplateRepository;

@RestController //Lo convertimos en un servicio REST
public class CursoRestController{

	@Autowired
	private CursoMySqlJdbcTemplateRepository repositorio; //con el repositorio vamos a llamar a los metodos que hemos
	//creado en el "DAO"
	
	@GetMapping("api/cursos") //ruta para acceder a la lista de cursos
	public List<Curso> GetAll() {
		return repositorio.GetAll();
	}

	@GetMapping("api/cursos/{id}") //ruta para acceder a la lista de cursos y con el Id a un curso en especial
	public Curso GetById(@PathVariable("id") Long id) {
		return repositorio.GetById(id);
	}

	@GetMapping("api/profes")//ruta para acceder a la lista de cursos y sus profesores
	public List<Curso> CurPro(){	
		return repositorio.CurPro();
	}
	
	@GetMapping("api/alumnos")//ruta para acceder a la lista de cursos, profesores y alumnos
	public List<Curso> CuProAl(){
		return repositorio.CuProAl(); 
	}
}
