package com.ipartek.formacion.uf2216rec;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;



public class MovilesMain {

	static private MovilesArrayDAO dao;
	static Scanner sc = null;
	
	private static final int SALIR = 0;
	private static final int ADD_MOVIL = 2;
	private static final int LISTADO = 1;
	private static final int GUARDAR = 3;
	
	public static final char NO = 'n';
	private static final char SI = 's';
	
	
	public static void main(String[] args) throws IOException {
		
		sc = new Scanner(System.in);
		dao = MovilesArrayDAO.getInstace();
		
		cargarMoviles();
		
		int opcion;
		
		do {
			mostrarMenu();
			
			opcion = Utils.leerInt();
			
			procesarOpcion(opcion);
		}while(opcion != SALIR);
		
	}//FIN DEL MAIN		
		
		private static void procesarOpcion(int opcion) throws IOException {
			switch(opcion) {
			
			case ADD_MOVIL:
				addMovil();
				break;
				
			case LISTADO:
				listadoMoviles();
				break;
				
			case GUARDAR:
				guardarTxt();
				break;
				
			case SALIR:
				salir();
				break;
				
			default:
				noOption();
				break;
			}
		
		}
		
	
	
	
	private static void guardarTxt() throws IOException {
		String nameTxt;
		char seguro;
		
		do {
			System.out.println("¿Como desea llamar al fitxero?");
			nameTxt = sc.nextLine().replaceAll("\\s", "");
			System.out.println("¿Estas seguro de que deseas llamarlo" + nameTxt + "?(s/n)");
			seguro = (char) System.in.read();
		}while (seguro != SI);
		
		File f = new File("Moviles\\" + nameTxt + ".txt");
		
		if(f.exists()) {
			System.out.println("Ya existe un fichero con ese nombre");
			guardarTxt();
		}else {
			try {
				f.createNewFile();
				System.out.println("El fichero ha sido guardado con exito.");
				
				FileWriter fw = new FileWriter(f);
				PrintWriter pw = new PrintWriter(fw);
				
				try {
					
					for (Moviles movil : dao.getAll()) {
						pw.println(movil);
					}
				}finally {
					pw.close();
					fw.close();
				}
				
				
			} catch (IOException e) {
				System.out.println("Error al crear fichero");
				e.printStackTrace();
			}
		}
		
		mostrarMenu();
		
		
		
	}
	
	
	private static void addMovil() {
		Moviles movil = crearMovilConDatosDeConsola();
		
		if(dao.insert(movil)) {
			p("Movil añadido correctamente");
		} else {
			p("No se ha podido añadir el video");
		}
	}
	
	private static Moviles crearMovilConDatosDeConsola() {
		p("ANDROID: ");
		Boolean android = Utils.leerBoolean();
		p("Marca: ");
		String marca = Utils.leerLinea();
		p("Ram: ");
		double ram = Utils.leerDouble();
		p("Pulgadas: ");
		double pulgadas = Utils.leerDouble();
		p("Memoria: ");
		int memoria = Utils.leerInt();
		
		Moviles movil = new Moviles(android, marca, ram, pulgadas, memoria);
		return movil;		
	}
	
	private static void noOption() {
		p("Esa función no existe");		
	}
	
	private static void salir() {
		p("Gracias por tu visita");
	}
	
	private static void mostrarMenu() {
		p("------------");
		p("Moviles");
		p("------------");
		p("");
		p("1. Listado de moviles");
		p("2. Añadir movil");
		p("3. Guardar moviles");
		p("");
		p("0. Salir");
		p("");
		p("Elige una opción");
	}
	
	
	private static void listadoMoviles() {
		mostrarCabecera();
		
		for(Moviles movil: dao.getAll()) {
			mostrarMovil(movil);
		}
	}
	
	private static void mostrarCabecera() {
		p("ANDROID \tMARCA\tRAM\tPULGADAS\tMEMORIA");
	}
	
	private static void mostrarMovil(Moviles movil) {
		p(movil.isAndroid() + " \t " + movil.getMarca() +"\t" + movil.getRam() +" \t " + movil.getPulgadas() +" \t " + movil.getMemoria());
	}
	
	private static void cargarMoviles() {
		CrudAble<Moviles> dao = MovilesArrayDAO.getInstace();
		
		for(int i = 1; i<= 5; i++) {
			dao.insert(new Moviles(true, "samsumg", 0, 0, 0));
		}
	}
	
	public static void p(String s) {
		System.out.println(s);
	}
	
	
}//END TAG
