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
	public void borrarArticulo(long a){
		for(int i=0;i<articulosCarrito.size();i++){
			if(articulosCarrito.get(i).getId()==a)
				articulosCarrito.remove(i);
		}
	}
	public ArrayList<Articulo> getObtenerArrayArticu(){
		
		return articulosCarrito;
	}
	public int getObtenerIntArticu(){
		System.out.println(articulosCarrito.size());
		return articulosCarrito.size();
	}
	public Articulo obtenerElementoCarrito(int id) {
		return articulosCarrito.get(id);
	}
	public int getPrecioTotal() {
		int precioFinal=0,aux=0;
		for(int i=0;i<articulosCarrito.size();i++) {
			aux=articulosCarrito.get(i).getPrecio();
			precioFinal=precioFinal+aux;
		}
		System.out.println("precFinal"+precioFinal);
		return precioFinal;
	}
}
