package especifico;

public class DatosPersonales {
	public static String nombreAve;
	public static String nombreDueno;
	
	
	public DatosPersonales() {
		nombreAve="paquito";
		nombreDueno="PEPE";
	}
	
	public static String getNombreAve() {
		return nombreAve;
	}
	public static void setNombreAve(String nombreAver) {
		nombreAve=nombreAver;
	}	
	
	
	public static void setNombreDueno(String nombreDueno) {
		DatosPersonales.nombreDueno=nombreDueno;
	}	
	public static String getNombreDueno() {
		return nombreDueno;
	}	
	
}
