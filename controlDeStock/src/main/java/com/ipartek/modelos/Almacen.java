package com.ipartek.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class Almacen {

	private int id;
	private String nombre;
	private Long ubicacion;
}
