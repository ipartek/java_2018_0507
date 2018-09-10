package com.ipartek.formacion.uf2216rec.presentacion;

import com.ipartek.formacion.uf2216rec.accesoDatos.CrudAble;
import com.ipartek.formacion.uf2216rec.accesoDatos.StockMovilesArrayDAO;
import com.ipartek.formacion.uf2216rec.pojo.StockMoviles;
import com.ipartek.formacion.uf2216rec.presentacion.Utils;

public class StockMovilesMain {
	
	private static final int SAVE_MOVIL = 3;
	private static final int ADD_MOVIL = 2;
	private static final int LISTADO = 1;
	private static final int SALIR = 0;
	
	private static CrudAble<StockMoviles> dao = StockMovilesArrayDAO.getInstance();

	public static void main(String[] args) {

		cargarMoviles();
		int opcion;
		
		do {
			mostrarMenu();
			
			opcion = Utils.leerInt();
			procesarOpcion(opcion);
			
		}while(opcion != SALIR);
		
	}
	
	private static void procesarOpcion(int opcion) {
		switch(opcion) {
		case LISTADO:
			listadoMoviles();
			break;
		case ADD_MOVIL: 
			addMovil();
			break;
		case SAVE_MOVIL:
			saveMovil();
			break;
		case SALIR:
			salir();
			break;
		default:
			noDisponible();
		}
	}
	
	private static void noDisponible() {
		p("Esa función no existe");		
	}

	private static void salir() {
		p("Gracias por tu visita");		
	}

	private static void addMovil() {
		StockMoviles movil = crearMovilConDatosDeConsola();
		
		if(dao.insert(movil)) {
			p(movil.toString());
			p("Movil añadido correctamente");
		} else {
			p("No se ha podido añadir el movil");
		}		
	}
	
	private static void saveMovil() {
			// TODO Auto-generated method stub
		
	}

	private static StockMoviles crearMovilConDatosDeConsola() {
		p("ID:");
		long id = Utils.leerLong();
		p("Android:");
		boolean android = Utils.leerBoolean();
		p("Marca:");
		String marca = Utils.leerLinea();
		p("Ram:");
		double ram = Utils.leerRam();
		p("Pulgadas:");
		double pulgadas = Utils.leerPulgadas();
		p("Memoria:");
		int memoria = Utils.leerMemoria();
		
		StockMoviles movil = new StockMoviles(id, android, marca, ram, pulgadas, memoria);
		return movil;
	}

	private static void listadoMoviles() {
		mostrarCabecera();
		for(StockMoviles movil: dao.getAll()) {
			mostrarMovil(movil);
		}
	}
	
	private static void mostrarMovil(StockMoviles movil) {
		p(movil.getId() + "\t" + movil.isAndroid() + "\t" + movil.getMarca() + "\t" + movil.getRam() + "\t" + movil.getPulgadas() + "\t\t" + movil.getMemoria());		
	}

	private static void mostrarCabecera() {
		p("ID\tANDROID\tMARCA\tRAM\tPULGADAS\tMEMORIA");
	}

	private static void mostrarMenu() {
		p("------------");
		p("StockMoviles");
		p("------------");
		p("");
		p("1. Listado de moviles");
		p("2. Añadir movil");
		p("3. Gruardar movil");
		p("");
		p("0. Salir");
		p("");
		p("Elige una opción");
	}
	
	public static void p(String s) {
		System.out.println(s);
	}

	private static void cargarMoviles() {

		for(int i = 1; i <= 5; i++) {
			dao.insert(new StockMoviles());
		}		
	}

}
