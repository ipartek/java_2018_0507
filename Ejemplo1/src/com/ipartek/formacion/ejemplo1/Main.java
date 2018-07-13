package com.ipartek.formacion.ejemplo1;

public class Main extends Ave{
	
	
	
	public static void main(String[] args) {
		

		Piolin p = new Piolin('H',10,5,2);
		Loro l = new Loro('M',11,'E',"azul");
		Loro l2 = new Loro('M',11,'E',"rojo");
		
		p.quienSoy();
		l.quienSoy();
		
		p.altura();
		
		
		l.deDondeEres('N');
		l.setRegion('S');
		
		
		p.setTamano(4);
		p.altura();
		
		
		//probando instacia de clase (static)
		//System.out.println(l.numAvesCreadas);
		//l.numAvesCreadas++;
		//System.out.println(l2.numAvesCreadas);
		////da un aviso xq es estatico se llama asi: (con Ave)
		System.out.println(Ave.numAvesCreadas);
		
		
		Ave.mostrarAvesCreadas();
		
		
		
		
	}

}
