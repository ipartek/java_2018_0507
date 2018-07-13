package com.ipartek.formacion.ejercicio1.poo;


/* En esta clase se encuentra el programa principal en el cual se crea una
instancia de la clase Piolin y otro de la clase loro.
	� Llamar al m�todo quienSoy de las dos instancias
	� Llamar al m�todo altura con la instancia del Piol�n
	� Invocar al m�todo deDondeEres con la instancia del Loro
	� Modificar el tama�o del Piol�n y volver a invocar al m�todo altura
	� Modificar la regi�n del Loro
	� Mostrar el n�mero de Aves creadas.
*/

/*
 * El programa principal var�a por completo.
	� Se crear� un array de 3 Piolines y se inicializar�n todos sus datos
	� Se asignar� un nuevo nombre de animal y nuevo nombre de due�o al
	primero de los tres Piolines creados (recordad que no se puede acceder
	directamente a ninguno de los atributos ya que todos son privados)
	� Crear una instancia de la clase Loro
	� Hacer cantar al loro y a los tres Piolines
	� Sacar por pantalla el nombre del animal y del due�o del primer Piol�n
	creado 
 * */

public class Main {

	public static void main(String[] args) {
		
		Piolin[] piolines= new Piolin[3];
		piolines[0] = new Piolin('H', 24, 2, 100, "Piolin1", "Antxon");
		piolines[1] = new Piolin('M', 20, 3, 20, "Piolin2", "Antxon2");
		piolines[2] = new Piolin('H', 10, 4, 10, "Piolin3", "Antxon3");
		
		Loro loro = new Loro('M', 30, 'O', "Rojo");
		
		Ave.cantar(loro);
		Ave.cantar(piolines[1]);
				
		
		
		
		
	
//		Piolin piolin = new Piolin('H', 24, 100, 2);
//		Loro loro = new Loro('M', 10, 'E', "Azul");
//		
//		System.out.println("Piolin quienSoy: ");
//		piolin.quienSoy();
//		System.out.println("Loro quienSoy: ");
//		loro.quienSoy();
//		
//		System.out.println("Piolin Altura: ");
//		piolin.altura();
//		
//		System.out.println("Loro deDondeEres: ");
//		loro.deDondeEres();
//		
//		piolin.setTama�o(20);
//		System.out.println("Piolin nueva Altura: ");
//		piolin.altura();
//		
//		loro.setRegion('O');
//		System.out.println("Loro nueva region: ");
//		loro.deDondeEres();
//		
//		System.out.print("Aves creadas: ");
//		Ave.getAvesCreadas();
	
	}
}
