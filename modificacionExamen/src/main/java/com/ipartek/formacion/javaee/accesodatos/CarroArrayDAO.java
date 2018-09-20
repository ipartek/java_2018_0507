package com.ipartek.formacion.javaee.accesodatos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.javaee.modelo.pojo.Carro;

public class CarroArrayDAO implements CrudAble<Carro>{
	private List<Carro> carrito = new ArrayList<>();
	private static CarroArrayDAO INSTANCE;
	
	
	private CarroArrayDAO() {
	}
	public static synchronized CarroArrayDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CarroArrayDAO();
		}
		return INSTANCE;
	}
	
	@Override
	public List<Carro> getAll() {
		return carrito;
	}

	@Override
	public Carro getById(long id) {
		Carro resul = null;
		//foreach
		for (Carro carritoIteracion : carrito) {
			if ( id == carritoIteracion.getId() ) {
				resul = carritoIteracion;
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean insert(Carro carro) {
		boolean resul = false;

		if (carro != null) {
			resul = carrito.add(carro);
		}
		return resul;
	}
	
	@Override
	public boolean update(Carro carritoUpdate) {
		boolean resul = false;
		Carro carritoIteracion = null;
		int i = 0;
		if ( carritoUpdate != null ) {
			//Iterator		
			Iterator<Carro> it = carrito.iterator();
			while( it.hasNext() ) {
				carritoIteracion = it.next();
				if ( carritoIteracion.getId() == carritoUpdate.getId() ) {
					carrito.set(i, carritoUpdate);
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
		
		Carro rIteracion = null;
		
		//buscar producto a eliminar del carrito
		for (int i = 0; i < carrito.size(); i++) {
			
			rIteracion = carrito.get(i);   
			
			if ( id == rIteracion.getId() ) {    
				resul = carrito.remove(rIteracion);
				break;
			}
		}
		return resul;
	}
}
