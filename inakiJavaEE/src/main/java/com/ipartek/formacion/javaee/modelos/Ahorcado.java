package com.ipartek.formacion.javaee.modelos;


public class Ahorcado {
private int numVidas=1,aux=0;
String rutaImagen="ahorcad//ahorcado1.png";
String [] palabras={"autobus","rascacielos","verano","playa","porteria","baloncesto"};
String palabraElegida=palabras[(int) (Math.random()*6)],palabraCodificada="";
StringBuilder palabraCodi=new StringBuilder("");
String definitiva="";
private int victoria=0;

	public int getVictoria() {
	return victoria;
}
public void setVictoria(int victoria) {
	this.victoria = victoria;
}
	public Ahorcado() {
		
	}
	public void setLetra(char c) {
		if(numVidas<=6)
		calcularGuiones(c);
	}
	public void setPalabra(String palabra) {
//		System.out.println("lo que mando: "+ palabra + " mi defini: " +definitiva);
		if(numVidas<=6 && palabra!=definitiva ){
			numVidas++;			
			rutaImagen="ahorcad//ahorcado"+numVidas+".png";
		}	
		if(definitiva.equalsIgnoreCase(palabra)) {
			rutaImagen="ahorcad//win.jpg";
			victoria=1;
		}
	}
	public String getPalabraCod() {
		return palabraCodificada;
		
	}
	public String getRuta(){
		System.out.println(definitiva);
		return rutaImagen;
	}
	public void calcularGuiones(char c)
	{
		int hayAcierto=0;
		for(int i=0;i<definitiva.length();i++) {
			if(definitiva.charAt(i)==c) {
				palabraCodi.setCharAt(i, c);
				rutaImagen="ahorcad//ahorcado"+numVidas+".png";
				System.out.println("exixtelaletra");
				hayAcierto=+1;
			}
			else {
				rutaImagen="ahorcad//ahorcado"+numVidas+".png";
				System.out.println("no exixte");
				
			}
		}
		
		if(hayAcierto==0)
			numVidas++;
		
		System.out.println(palabraCodificada);
		palabraCodificada=palabraCodi.toString();
		if(palabraCodificada.equalsIgnoreCase(definitiva))
		{
			rutaImagen="ahorcad//win.jpg";
			victoria=1;
		}
		
	}
	public void setPalFin(String s)
	{
		definitiva=s;
		if(aux==0)
		for(int i=0;i<s.length();i++) {
			palabraCodi.append("-");
			System.out.println(palabraCodi+"holaaaaa");
		}
		aux=1;
	}
	public String getPalabraElegida() {
		// TODO Auto-generated method stub
		return palabraElegida;
	}
	public void setReiniciar() {
	 numVidas=1;aux=0;
	 rutaImagen="ahorcad//ahorcado1.png";
	 palabraElegida=palabras[(int) (Math.random()*6)];
	palabraCodificada="";
	palabraCodi=new StringBuilder("");
	definitiva="";
	victoria=0;
		
	}
	
	
}
