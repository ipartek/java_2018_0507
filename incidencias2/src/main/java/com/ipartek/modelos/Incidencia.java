package com.ipartek.modelos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class Incidencia {
	private Long id;
	private Date fecha;
	private String usuarioCreador;
	private String titulo;
	private String descripcion;
	private String equipo;
	private String usuarioAsignado;
}
