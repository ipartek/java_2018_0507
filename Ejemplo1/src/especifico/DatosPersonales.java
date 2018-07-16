package especifico;

public class DatosPersonales {
	public static String nombreAve;
	public static String nombreDueño;
	
	
	public DatosPersonales() {
		nombreAve="paquito";
		nombreDueño="PEPE";
	}
	
	public static String getNombreAve() {
		return nombreAve;
	}
	public static void setNombreAve(String nombreAver) {
		nombreAve=nombreAver;
	}	
	
	
	public static void setNombreDueño(String nombreDueño) {
		DatosPersonales.nombreDueño=nombreDueño;
	}	
	public static String getNombreDueño() {
		return nombreDueño;
	}	
	
}
