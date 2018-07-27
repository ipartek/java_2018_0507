package com.ipartek.formacion.ejemplo1.estrellastv;

import com.ipartek.formacion.ejemplo1.DatosPersonales;
import com.ipartek.formacion.ejemplo1.aves.pajaros.Canario;

/**
 * @class abstracta hereda de Canario Tiene como atributos el sexo (M/H), la
 *        edad (entero) y el número de películas (entero). • Su constructor
 *        inicializa todos los atributos con valores que le llegan como
 *        parámetros. • En esta clase se encuentra el programa principal en el
 *        cual se crea una instancia de la clase Piolin y otro de la clase loro.
 *        • Llamar al método quienSoy de las dos instancias • Llamar al método
 *        altura con la instancia del Piolín • Invocar al método deDondeEres con
 *        la instancia del Loro • Modificar el tamaño del Piolín y volver a
 *        invocar al método altura • Modificar la región del Loro • Mostrar el
 *        número de Aves creadas.
 * @author AnaMAMM
 *
 */
public class Piolin extends Canario {

	/**
	 * atributos de instancia
	 */
	private int numeroPeliculas;

	/**
	 * Constructor con argumentos
	 * 
	 * @param sexo
	 * @param edad
	 * @param tamano
	 * @param numeroPeliculas
	 */
	public Piolin(char sexo, int edad, Integer tamano, int numeroPeliculas,DatosPersonales dp) {

		super(sexo, edad, tamano,dp);
		this.numeroPeliculas = numeroPeliculas;
	

	}

	/**
	 * La clase Ave tendrá un método abstracto que será cantar. Para un Piolín
	 * cantar será sacar el mensaje “Pio-pio soy un Piolín”
	 */
	@Override
	public void cantar() {
		System.out.println("Pio-pio soy un Piolín");

	}

}
