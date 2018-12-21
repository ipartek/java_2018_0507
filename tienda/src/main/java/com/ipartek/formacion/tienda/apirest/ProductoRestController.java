package com.ipartek.formacion.tienda.apirest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.tienda.modelos.Producto;
import com.ipartek.formacion.tienda.repositorios.CrudAble;
import com.ipartek.formacion.tienda.repositorios.ProductoRepository;

@RestController
public class ProductoRestController implements RestAble<Producto>{
	
	@Autowired
	private CrudAble<Producto> repositorio;
	
	@Autowired
	private ProductoRepository repositorio2;

	@Override
	@GetMapping("/api/productos")
	public List<Producto> obtenerTodos() {
		return repositorio.getAll();
	}

	@Override
	@GetMapping("/api/productos/{id}")
	public Producto obtenerPorId(@PathVariable("id") Long id) {
		return repositorio.getById(id);
	}

	@Override
	@PostMapping("/api/productos")
	public void crear(@RequestBody Producto producto) {
		repositorio.insert(producto);
	}

	@Override
	@PutMapping("/api/productos")
	public void modificar(@RequestBody Producto producto) {
		repositorio.update(producto);
	}

	@Override
	@DeleteMapping("/api/productos/{id}")
	public void borrar(@PathVariable("id") Long id) {
		repositorio.delete(id);
	}
	
	@GetMapping("/api/productos/almacen/{id}")
	public List<Producto> productosPorAlmacen(@PathVariable("id") Long id){
		//Si es sin ubicacion
		if (id == 3) {
			return repositorio2.getByAlmacenVacio();
		}else { //Con ubicacion
			return repositorio2.getByAlmacen(id);
		}
		
	}
	
	@PutMapping("/api/productos/completo")
	public void modificarCompleto(@RequestBody Producto producto) {
		repositorio2.updateCompleto(producto);
	}

	@DeleteMapping("/api/productos/completo/{id}")
	public void borrarCompleto(@PathVariable("id") Long id) {
		repositorio2.deleteCompleto(id);
	}
}
