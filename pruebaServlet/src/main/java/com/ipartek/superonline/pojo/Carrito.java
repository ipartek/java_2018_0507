package com.ipartek.superonline.pojo;

import java.util.ArrayList;

import com.ipartek.superonline.pojo.Producto;

public class Carrito {
	ArrayList<Producto> articulosCarrito=new ArrayList<Producto>();
	public Carrito(){
		
	}
	public Carrito(Producto a){
		articulosCarrito.add(a);
	}
	public void insertarArticulo(Producto a){
		articulosCarrito.add(a);
	}
	
	public Producto obtenerElementoCarrito(int id) {
		return articulosCarrito.get(id);
	}
	public ArrayList<Producto> getObtenerArrayArticu(){
		return articulosCarrito;
	}
	
	
}