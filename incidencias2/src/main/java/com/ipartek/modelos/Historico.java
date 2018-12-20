package com.ipartek.modelos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class Historico {
	private Long id;
	private String incidencia;
	private String usuario;
	private Date fecha;
	private String comentario;
	private String estado;

}
