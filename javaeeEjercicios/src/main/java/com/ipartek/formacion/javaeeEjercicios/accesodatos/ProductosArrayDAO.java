package com.ipartek.formacion.javaeeEjercicios.accesodatos;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.javaeeEjercicios.pojos.Producto;


public class ProductosArrayDAO implements CrudAble<Producto>{

	private List<Producto> productos = new ArrayList<>();
	private static ProductosArrayDAO INSTANCE;
	
	public ProductosArrayDAO() {
		// TODO Auto-generated constructor stub
	}

	public static synchronized ProductosArrayDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new ProductosArrayDAO();
		}

		return INSTANCE;
	}

	@Override
	public List<Producto> getAll() {
		return productos;
	}

	@Override
	public Producto getById(long id) {
		Producto resul = null;
		//foreach
		for (Producto productoIteracion : productos) {
			if ( id == productoIteracion.getId() ) {
				resul = productoIteracion;
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean insert(Producto producto) {
		boolean resul = false;

		if (producto != null) {
			resul = productos.add(producto);
		}
		return resul;
	}

	@Override
	public boolean update(Producto productoUpdate) {
		boolean resul = false;
		Producto productoIteracion = null;
		int i = 0;
		if ( productoUpdate != null ) {
			//Iterator		
			Iterator<Producto> it = productos.iterator();
			while( it.hasNext() ) {
				productoIteracion = it.next();
				if ( productoIteracion.getId() == productoUpdate.getId() ) {
					productos.set(i, productoUpdate);
					resul = true;
					break;					
				}	
				i++;
			}		
		}	
		return resul;
	}

	@Override
	public boolean delete(long id) {
		boolean resul = false;
		
		Producto pIteracion = null;
		
		//buscar video a eliminar
		for (int i = 0; i < productos.size(); i++) {
			
			pIteracion = productos.get(i);   //producto sobre el que iteramos
			
			if ( id == pIteracion.getId() ) {    // producto encontrado
				resul = productos.remove(pIteracion);
				break;
			}
		}
		
		return resul;
	}

}
