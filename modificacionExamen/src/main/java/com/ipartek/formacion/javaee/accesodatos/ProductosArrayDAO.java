package com.ipartek.formacion.javaee.accesodatos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.javaee.modelo.pojo.Producto;

public class ProductosArrayDAO implements CrudAble<Producto>{

	private List<Producto> producto = new ArrayList<>();
	private static ProductosArrayDAO INSTANCE;
	
	private ProductosArrayDAO() {
	}
	public static synchronized ProductosArrayDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ProductosArrayDAO();
		}
		return INSTANCE;
	}
	
	@Override
	public List<Producto> getAll() {
		return producto;
	}

	@Override
	public Producto getById(long id) {
		Producto resul = null;
		//foreach
		for (Producto productoIteracion : producto) {
			if ( id == productoIteracion.getId() ) {
				resul = productoIteracion;
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean insert(Producto prod) {
		boolean resul = false;

		if (prod != null) {
			resul = producto.add(prod);
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
			Iterator<Producto> it = producto.iterator();
			while( it.hasNext() ) {
				productoIteracion = it.next();
				if ( productoIteracion.getId() == productoUpdate.getId() ) {
					producto.set(i, productoUpdate);
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
		
		Producto rIteracion = null;
		
		//buscar libro a eliminar
		for (int i = 0; i < producto.size(); i++) {
			
			rIteracion = producto.get(i);   //producto sobre el que iteramos
			
			if ( id == rIteracion.getId() ) {    // producto encontrado
				resul = producto.remove(rIteracion);
				break;
			}
		}
		
		return resul;
	}
}
