package com.ipartek.formacion.multimodulo_modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity //Para habilitar JPA
@Table(name="tablausuarios")
public class Usuario {
	@Id //Para JPA: clave primaria
    @GeneratedValue(strategy=GenerationType.AUTO) //autogenerada
	private Long id;
	private String email;
	private String password;
}
