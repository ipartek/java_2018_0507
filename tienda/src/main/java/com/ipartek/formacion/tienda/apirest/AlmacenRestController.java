package com.ipartek.formacion.tienda.apirest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.tienda.modelos.Almacen;
import com.ipartek.formacion.tienda.repositorios.AccesoDatosException;
import com.ipartek.formacion.tienda.repositorios.CrudAble;

@RestController
public class AlmacenRestController implements RestAble<Almacen>{

	@Autowired
	private CrudAble<Almacen> repositorio;
	
	@Override
	@GetMapping("/api/almacenes")
	public List<Almacen> obtenerTodos() {
		return repositorio.getAll();
	}

	@Override
	@GetMapping("/api/almacenes/{id}")
	public Almacen obtenerPorId(@PathVariable("id") Long id) {
		return repositorio.getById(id);
	}

	@Override
	@PostMapping("/api/almacenes")
	public void crear(Almacen t) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	@Override
	@PutMapping("/api/almacenes")
	public void modificar(Almacen t) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	@Override
	@DeleteMapping("/api/almacenes/{id}")
	public void borrar(@PathVariable("id") Long id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

}
