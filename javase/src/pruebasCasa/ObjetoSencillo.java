package pruebasCasa;

import com.ipartek.formacion.video.pojo.VideoYoutube;

public class ObjetoSencillo {

	public static void main(String[] args) {
		String nombre = "Aitor";
		nombre = "Pepe";
		
		// System.out.println(nombre);
		
		// Hola Aitor
		
		System.out.println(saludar() + nombre);
		
		// perro1.ladrar(1); // [kjbrkjg, ksrn, lishfninv]; ksrn 
		
		Perro perro1 = new Perro();		
		
		System.out.println(perro1);	
		
		Perro perro2 = new Perro("Tobias", 7);		
		
		System.out.println(perro2);	
		
		// Sacar por pantalla el nombre del perro2
		
			
		System.out.println(perro2.getNombre());
		
		System.out.println(perro2.getNombreMay());
		
		
		// El sonido en la posicion 2
		
		// System.out.println(perro2.sonidos.get(2));
		
		// Perro riene u nmetodo que te devuleve el sonido en la posicion indicada
		// perro2.ladrido(2)-> Zaunk
		
		System.out.println(perro2.ladrido(0));
		
		VideoYoutube peli = new VideoYoutube(68176, "codigo", "Otto el gato");
		System.out.println(peli);
		
		String a = "1";
		String b = "2";
		
		System.out.println( Integer.parseInt(a) + Integer.parseInt(b));
		
		
		
	}
	
	
	public static String saludar() {		
		return "Hola ";
	}
	
	
	

}
