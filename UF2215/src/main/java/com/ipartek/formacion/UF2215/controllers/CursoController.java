package com.ipartek.formacion.UF2215.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.UF2215.model.Alumno;
import com.ipartek.formacion.UF2215.model.Curso;
import com.ipartek.formacion.UF2215.model.Imparticion;
import com.ipartek.formacion.UF2215.model.Profesor;
import com.ipartek.formacion.UF2215.repositories.RestAble;

@RestController
public class CursoController {

	@Autowired
	private final RestAble<Curso> repositorio = null;
	
	@Autowired
	private final RestAble<Profesor> repositorioprof = null;
	
	@Autowired
	private final RestAble<Alumno> repositorioalumnos = null;
	@Autowired
	private final RestAble<Imparticion> repositorioimparticion = null;
	
	
	@GetMapping("/api/cursos")
	public List<Curso> obtenerCursos() {
		System.out.println("Registros de cursos:" + repositorio.obtenerTodos().toString());
		return repositorio.obtenerTodos();
	}
	
	@GetMapping("/api/profesores")
	public List<Profesor> obtenerProfesores() {
		System.out.println("Registros de profesores:" + repositorioprof.obtenerTodos().toString());
		return repositorioprof.obtenerTodos();
	}
	
	@GetMapping("/api/alumnos")
	public List<Alumno> obtenerAlumnos() {
		System.out.println("Registros de alumnos:" +repositorioalumnos.obtenerTodos().toString());
		return repositorioalumnos.obtenerTodos();
	}
	@GetMapping("/api/imparticion")
	public List<Imparticion> obtenerImparticion() {
		System.out.println("Registros de imparticion:" + repositorioimparticion.obtenerTodos().toString());
		return repositorioimparticion.obtenerTodos();
	}
	
}

