package com.ipartek.formacion.uf2216rec;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MovilesMain {

	static private MovilesArrayDAO dao;
	static private int opcionSeleccionada = 0;
	static Scanner sc = null;
	
	private static final int SALIR = 0;
	private static final int ADD_MOVIL = 1;
	private static final int LISTADO = 2;
	private static final int GUARDAR = 3;
	
	public static final char NO = 'n';
	private static final char SI = 's';
	
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		dao = MovilesArrayDAO.getInstace();
		
		cargarMoviles();
		
		pintarMenu();
		
		do {
			switch(opcionSeleccionada) {
			case ADD_MOVIL:
				anadirMovil();
				break;
				
			case LISTADO:
				listar();
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
		} while (SALIR == false);
		
	}//FIN DEL MAIN
	
	
	private static void guardarTxt() throws IOException {
		String nameTxt;
		char seguro;
		
		do {
			sc.next();
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
		
		
		
	}
	
	
	
	
	
	
	
}//END TAG
