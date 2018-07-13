package aves;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Piolin[] arrayPiolin=new Piolin[3];
		Loro lo=new Loro('h',25,'n',"negro");
		int aux=10;
		for(int i=0;i<3;i++)
		{
			arrayPiolin[i]=new Piolin('h', aux, 25, 10);
			aux+=10;
			arrayPiolin[i].cantar();
		}
		lo.cantar();
		arrayPiolin[0].nombres.setNombreDueño("carol");
		arrayPiolin[0].nombres.setNombrePajaro("polluelo");
		System.out.println(arrayPiolin[0].nombres.getNombreDueño());
		System.out.println(arrayPiolin[0].nombres.getNombrePajaro());
		/*Piolin piol=new Piolin('h', 25, 30, 35);
		Loro loro=new Loro('h', 20, 'n', "negro");
		Loro loro2=new Loro('h', 20, 'n', "negro");
		Ave.mostrarNumAvesCreadas();
		Ave.mostrarNumAvesCreadas();
		Canario cana=new Canario(14,'h',14);
		piol.quienSoy();
		loro.quienSoy();
		piol.altura();
		loro.deDondeEres();
		piol.tamano=50;
		piol.altura();
		loro.setRegion('e');
		loro.deDondeEres();
		//Ave ave=new Ave(20,'h');
		//ave.quienSoy();		
		loro.deDondeEres();
		cana.altura();
		Ave.mostrarNumAvesCreadas();
		piol.cantar();
		loro.cantar();*/
		
		
	}

}
