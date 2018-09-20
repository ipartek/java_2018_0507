package com.ipartek.formacion.javaee.supermercado.accesodatos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.javaee.supermercado.pojo.Producto;

public class ProductoArrayDAO implements CrudAble<Producto>{

	private List<Producto> productos = new ArrayList<>();

	private static ProductoArrayDAO INSTANCE;

	private ProductoArrayDAO() {
	}
	
	public static synchronized ProductoArrayDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new ProductoArrayDAO();
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
	public boolean insert(Producto video) {
		boolean resul = false;

		if (video != null) {
			resul = productos.add(video);
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
		
		for (int i = 0; i < productos.size(); i++) {
			
			pIteracion = productos.get(i);   
			
			if ( id == pIteracion.getId() ) {
				resul = productos.remove(pIteracion);
				break;
			}
		}
		
		return resul;
	}

}
