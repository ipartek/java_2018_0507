package com.ipartek.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class Producto {
	
	private int id;
	private String nombre;
	private String imagen;
	private String descripcion;
	private double precio;

}
