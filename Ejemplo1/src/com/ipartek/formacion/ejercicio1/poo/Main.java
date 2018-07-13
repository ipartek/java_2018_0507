package com.ipartek.formacion.ejercicio1.poo;


/* En esta clase se encuentra el programa principal en el cual se crea una
instancia de la clase Piolin y otro de la clase loro.
• Llamar al método quienSoy de las dos instancias
• Llamar al método altura con la instancia del Piolín
• Invocar al método deDondeEres con la instancia del Loro
• Modificar el tamaño del Piolín y volver a invocar al método altura
• Modificar la región del Loro
• Mostrar el número de Aves creadas.*/

public class Main {

	public static void main(String[] args) {
	
		Piolin piolin = new Piolin('M', 24, 100, 2);
		Loro loro = new Loro('H', 10, 'E', "Azul");
		
		System.out.println("Piolin quienSoy: ");
		piolin.quienSoy();
		System.out.println("Loro quienSoy: ");
		loro.quienSoy();
		
		System.out.println("Piolin Altura: ");
		piolin.altura();
		
		System.out.println("Loro deDondeEres: ");
		loro.deDondeEres();
		
		piolin.setTamaño(20);
		System.out.println("Piolin nueva Altura: ");
		piolin.altura();
		
		loro.setRegion('O');
		System.out.println("Loro nueva region: ");
		loro.deDondeEres();
		
		System.out.println("Aves creadas: ");
		Ave.getAvesCreadas();
	
	}
}
