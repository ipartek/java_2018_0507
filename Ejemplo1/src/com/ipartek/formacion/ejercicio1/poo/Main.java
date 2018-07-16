package com.ipartek.formacion.ejercicio1.poo;


/* En esta clase se encuentra el programa principal en el cual se crea una
instancia de la clase Piolin y otro de la clase loro.
	• Llamar al método quienSoy de las dos instancias
	• Llamar al método altura con la instancia del Piolín
	• Invocar al método deDondeEres con la instancia del Loro
	• Modificar el tamaño del Piolín y volver a invocar al método altura
	• Modificar la región del Loro
	• Mostrar el número de Aves creadas.
*/

/*
 * El programa principal varía por completo.
	• Se creará un array de 3 Piolines y se inicializarán todos sus datos
	• Se asignará un nuevo nombre de animal y nuevo nombre de dueño al
	primero de los tres Piolines creados (recordad que no se puede acceder
	directamente a ninguno de los atributos ya que todos son privados)
	• Crear una instancia de la clase Loro
	• Hacer cantar al loro y a los tres Piolines
	• Sacar por pantalla el nombre del animal y del dueño del primer Piolín
	creado 
 * */

public class Main {

	public static void main(String[] args) {
		
		Piolin[] piolines= new Piolin[3];
		piolines[0] = new Piolin('H', 24, 2, 100, "Antxon", "Piolin Especial");
		piolines[1] = new Piolin('M', 20, 3, 20, "Antxon2", "Piolin2");
		piolines[2] = new Piolin('H', 10, 4, 10, "Antxon3", "Piolin3");
		
		Loro loro = new Loro('M', 30, 'O', "Rojo", "Joxepo", "Loro");
		
		System.out.print("Canto loro: ");
		Ave.cantar(loro);
		for (int x = 0; x < piolines.length; x++) {
			System.out.print("Canto piolin " + (x+1)+": ");
			Ave.cantar(piolines[x]);
		}		
		
		System.out.println("\nNombre primer piolin: " + piolines[0].getNombres().getNombreAve() 
				+ "\nDueno primer piolin: " + piolines[0].getNombres().getNombreDuenyo());
		
		
	
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
//		piolin.setTamaño(20);
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
