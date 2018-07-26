package com.ipartek.formacion.ejercicos.poo;


public class Main {

	public static void main(String[] args) {
		
//		Piolin p = new Piolin ("Hembra",4,25,6);
//		p.QuienSoy();
//		p.Altura(p.tamano);
//		
//		Aves a = new Aves("Macho",3);
//		a.QuienSoy();
//		
//		Canario c = new Canario("Macho",23,34);
//		c.Altura(c.tamano);
//		
//		Loro l = new Loro("Hembra",21,'E',"verde");
//		l.DondeEres(l.getRegion());
//		
//		l.setRegion('S');
//		l.DondeEres(l.getRegion());
			
		
		Piolin[] piolines = new Piolin[3];
		
		Piolin p = new Piolin("Macho",12,23,12);
		Piolin p1 = new Piolin("Hembra",12,15,67);
		Piolin p2 = new Piolin("Macho",12,23,76);//,(new DatosPersonales().setNombreAve("Aguila")); No tengo esto en el constructor
//		p.getNombres().setNombreAve("Aquila");
//		p.getNombres().setNombreDueno("Jon");
//		p1.getNombres().setNombreAve("Halcon");
//		p1.getNombres().setNombreDueno("Julen");
//		p2.getNombres().setNombreAve("zeus");
//		p2.getNombres().setNombreDueno("pedro");
		DatosPersonales da = new DatosPersonales("Aguila","Julen");
		p.setNombres(da);
		DatosPersonales da1 = new DatosPersonales("Halcon","Jon");
		p1.setNombres(da1);
		DatosPersonales da2 = new DatosPersonales("Lechuza","Javi");
		p2.setNombres(da2);
		
		piolines[0]=p;
		piolines[1]=p1;
		piolines[2]=p2;
		
		
		for (int i = 0; i < piolines.length; i++) {
			
			System.out.println("Sexo: " + piolines[i].getSexo()+ " Edad: " + piolines[i].getEdad() + " Tamano: " 
					
				+ piolines[i].getTamano() + " NumPelis: " + piolines[i].getNumPeliculas());
			
			piolines[i].Cantar();
		}
		
		
		Loro l = new Loro();
		
		l.setSexo("Hembra");
		l.setEdad(23);
		l.setRegion('O');
		l.setColor("Verde");
		
		l.Cantar();
		
		
		System.out.println(piolines[0].getNombres().getNombreAve()+" "+ piolines[0].getNombres().getNombreDueno());
		
		
		
	}

}
