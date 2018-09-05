package creacionClasesObjetos;

public class PersonaPrueba {

	public static void main(String[] args) {

		Persona p1 = new Persona();
		Persona p2 = new Persona();
		
		System.out.println("Valores por defecto de la clase Persona:");
		p1.desplegarNombre();
		
		p1.nombre = "Aitor";
		p1.apellidoPaterno = "Casado";
		p1.apellidoMaterno = "Arzuaga";
		
		p2.nombre = "Marina";
		p2.apellidoPaterno = "De la Fuente";
		p2.apellidoMaterno = "Balaguer";
		
		System.out.println("Nuevos Valores del objeto Persona:");
		p1.desplegarNombre();
		System.out.println("Valores Persona 2: ");
		p2.desplegarNombre();
	}

}
