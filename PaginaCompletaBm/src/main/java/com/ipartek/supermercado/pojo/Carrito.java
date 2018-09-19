package com.ipartek.supermercado.pojo;

import java.util.ArrayList;

public class Carrito {
	ArrayList<Articulo> articulosCarrito=new ArrayList<Articulo>();
	public Carrito(){
		
	}
	public Carrito(Articulo a){
		articulosCarrito.add(a);
	}
	public void insertarArticulo(Articulo a){
		articulosCarrito.add(a);
	}
	public ArrayList<Articulo> obtenerArrayArticu(){
		return articulosCarrito;
	}
	public Articulo obtenerElementoCarrito(int id) {
		return articulosCarrito.get(id);
	}
}
