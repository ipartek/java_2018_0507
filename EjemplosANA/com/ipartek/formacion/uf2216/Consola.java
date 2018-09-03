package com.ipartek.formacion.uf2216;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.ipartek.formacion.uf2216.revista.Revista;


public class Consola {
	private static final String RUTA_FICHERO = "C:\\AnaWork\\fichero.txt";
	private static final boolean AUTO_FLUSH = true;
	private static final boolean SOBREESCRIBIR = false;

	private static int ISBN;
	private static  int n_paginas;
	private static boolean formato;
	private static String titulo="";
	
	public static void main(String[] args) {
		Revista rev=new Revista();
		
		int idRevista=0;
		menuRevista();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("SC"+sc.nextLine());

		
		while(sc.nextLine()!="0") {
			menuRevista();
				switch(sc.nextLine()) {
					
					case "1":
						System.out.println("Añadir Revista");
						Revista rv=aniadirRevista();
						menuRevista();
						rv.insert(rv);
						
						break;
					case "2":
						System.out.println("Buscar");
						Revista revi=new Revista();
						Scanner sc1 = new Scanner(System.in);
						aniadirRevista();
						Long revID= sc1.nextLong();
						System.out.println("Revista elegida ID:"+revID);
						revi.getRevistas(revID);
						
						mostrarRevista(revi);
						
						
						
						revi.getRevistas(revID);
						
						menuRevista();
				//		revi.getRevistas((long)idRevista);
						break;

					case "0":
						System.out.println("ADIOS");
					
						break;
			
					default:
						System.out.println("ADIOS");
						break;
				}
		}
		sc.close();
	}
	
	private static void menuRevista() {
		System.out.println("-----------------");
		System.out.println("MIS REVISTAS Y YO");
		System.out.println("-----------------");
		System.out.println("\n\n");
	
		System.out.println("1.-Añadir Revista");
		System.out.println("2.-Mostrar Revistas");
		
		System.out.println("-----------------");
		
		System.out.println("0.-Salir");
	
		System.out.println("Elige un menu de arriba");
	}

		private static void mostrarCabecera() {
			System.out.println("ID\tCODIGO\tTITULO");
		}
		
		private static Revista aniadirRevista() {
			
			Scanner sc = new Scanner(System.in);
			
			Revista revista = new Revista(ISBN,n_paginas,formato);
			
			
			System.out.println("Introduce ISBN");
			ISBN=sc.nextInt();
			System.out.println("Introduce Titulo");
			titulo = sc.next();
			System.out.println("Introduce Formato: d para digital o p para papel");
			String formatoReci = sc.next();
			
			
			revista.setISBN(ISBN);
			revista.setTitulo(titulo);
			
		
			if (formatoReci=="d") {
				revista.setFormato(true);;
			}else {
				revista.setFormato(false);
			}
			
			
			revista.insertar(revista);
				
			System.out.println("ISBN Introducido"+ISBN);
		
			System.out.println("ISBN::: "+revista.getISBN()+" añadido");
			sc.close();
			return revista;
		}
		
		private static void mostrarRevista(Revista rev) {

			System.out.println(rev.getISBN() + "\t" + rev.getTitulo() + "\t" + rev.getFormato());
			
		
			FileWriter fw;
			try {
					fw = new FileWriter(RUTA_FICHERO, SOBREESCRIBIR);
				
						
					PrintWriter pw = new PrintWriter(fw,AUTO_FLUSH);
					mostrarCabecera();
					pw.println(rev.getISBN() + "\t" + rev.getTitulo() + "\t" + rev.getFormato());
					
					
					pw.close();
					fw.close();
					
					FileReader fr = new FileReader(RUTA_FICHERO);
					BufferedReader br = new BufferedReader(fr);
					
					String linea;
				
					while( (linea = br.readLine()) != null ) {
						System.out.println(linea);
					}
					
				br.close();
				fr.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	

}
