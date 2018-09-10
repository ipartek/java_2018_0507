package com.ipartek.formacion.uf2216_recuperacion;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.ipartek.formacion.uf2216_recuperacion.movil.CrudAble;
import com.ipartek.formacion.uf2216_recuperacion.movil.ManejoFichero;
import com.ipartek.formacion.uf2216_recuperacion.movil.Movil;
import com.ipartek.formacion.uf2216_recuperacion.movil.MovilArrayDAO;


public class Main {

	
	public static List<Movil> lista;

	/*
	 * 
	 * Solicita datos, guarda en el objeto y guarda en el archivo.
	 * 
	 * */
	
	
	
	public static void main(String[] args) {
		
		int movil=0;
		menu();
		
		Movil mov = null;		
		
		Scanner sc1 = new Scanner(System.in);
		
		int opcion=-1;
		
		while(opcion !=0) {
			menu();
			opcion= sc1.nextInt();
			switch(opcion) {
				case 1:
					System.out.println("Añadir movil");
					movilNuevo();
					break;
				case 2:
					
				
					listadoMoviles();
					
					break;
				case 3:
					ManejoFichero.leerFich();
					opcion=0;
					break;
				case 0:
					System.out.println("ADIOS");
					break;
				default:
					System.out.println("ADIOS");
					break;
			}
		}
		sc1.close();
		
	}

	/////////////////////////

	
	private static void listadoMoviles() {
		CrudAble<Movil> dao = MovilArrayDAO.getInstance();
		
		for(Movil mov: dao.getAll()) {
			mostrarMovil(mov);
		}
	}
	
	private static void mostrarMovil(Movil movil) {
		System.out.println(movil.getMarca() + "\t" + movil.getMemoria() 
					+ "\t" + movil.getPulgadas()+"\t"+movil.getRam());
	}
	
	
	//////////////////////
	
	private static void menu() {
		System.out.println("");
		System.out.println("");
		System.out.println("Introduce opcion elegida");
		System.out.println("1.-Movil Nuevo");
		System.out.println("2.-Mostrar Moviles");
		System.out.println("3.-LeerFichero");
		System.out.println("-----------");
		System.out.println("0.-Salir");
	}

	private static void movilNuevo() {
		Scanner sc = new Scanner(System.in);
		Movil mov;		
		
		
		System.out.println("Es android? S/N");
		String android=sc.next();
		System.out.println("Introd. marca: ");
		String marca=sc.next();
		System.out.println("Introduce ram");
		int ram = sc.nextInt();
		System.out.println("Introduce pulgadas");
		int pulgadas = sc.nextInt();
		System.out.println("Introduce memoria");
		int memoria = sc.nextInt();

		boolean bandroid;
		
		if (android.contains("s")|| android.contains("S")) {
			bandroid=true;
		}else {
			bandroid=false;
		}
	
		
		mov = new Movil(bandroid,marca,ram,pulgadas,memoria);
		
		
		System.out.println("Resumen de movil a insertar:\n" 
							+" Tiene android? "+bandroid
							+"  Marca: "+mov.getMarca()
							+"  RAM: "+mov.getRam()
							+"  Pulgadas: "+mov.getPulgadas()
							+"  Memoria: "+mov.getMemoria());
		
		System.out.println("Continuar con la insercion??:(s/n)");
		String continuar=sc.next();
		
		MovilArrayDAO dao=new MovilArrayDAO();
		
		if(continuar.equals("s")) {
			dao.insert(mov);
			System.out.println("Movil insertado");
		}else {
			System.out.println("No insertado");
		}
	
	}
	
}


