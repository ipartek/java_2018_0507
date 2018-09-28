package especifico;


public class Principal extends Ave {
	static int num_aves=0;
	public static void main(String[] args) {

		//Ave.mostrarNAves();
		Piolin pio=new Piolin('M', 15, 3, 3);
		Loro l1=new Loro('F',3, 'N',"verde");		
		Canario c1=new Canario('V',12,50,35);
		
		pio.quienSoy();
		l1.quienSoy();
		
		pio.altura(pio);
		l1.deDondeEres();
		Ave.cantar("Lorororo");
		
		pio.tamanio=50;
		pio.altura(pio);
		
		pio.altura(100);
		Ave.cantar("cantar");
		Ave.cantar("Lorocantando");
		
		l1.region='S';
		l1.deDondeEres();
		c1.altura(23);
		l1.setRegion('O');
		l1.deDondeEres();
		
		Ave.cantar("grrr");
			
		DatosPersonales.setNombreAve("PepitoAve");
		System.out.println(DatosPersonales.getNombreAve());
		DatosPersonales.setNombreDueno("DuenoPePe");
		System.out.println(DatosPersonales.getNombreDueno());
		
		System.out.println("N�Aves  "+Ave.num_aves);
	}
}
