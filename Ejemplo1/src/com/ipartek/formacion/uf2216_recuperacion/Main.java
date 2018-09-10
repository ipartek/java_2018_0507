package com.ipartek.formacion.uf2216_recuperacion;

import java.util.Scanner;

import com.ipartek.formacion.uf2216_recuperacion.movil.ManejoFichero;
import com.ipartek.formacion.uf2216_recuperacion.movil.Movil;


public class Main {

	
	/*
	 * Crear una aplicación que nos solicite datos por pantalla para poder crear nuevos registros en nuestro CMS.
Nuestro CMS se encarga de gestionar un stock de MÓVILES, por lo cual la aplicación debe solicitar los siguientes datos:
1.      Android                                         verdadero o falso
2.      Marca                                            de 3 a 15 caracteres
3.      RAM                                              en GB, mínimo 0,5
4.      Pulgadas                                      máximo 7,0
5.      Memoria                                       múltiplo de 4 (en GB)

Cada campo que solicitamos deberá ser comprobado que tiene un formato valido, en caso de no cumplir el formato se solicitará de nuevo el mismo campo.
Si el formato es correcto solicita el siguiente campo.
Cuando termina de solicitar todos los campos debe mostrar un resumen del móvil a ingresar en el CMS, además de pedir una confirmación si se quiere guardar.
 Además deberá tener las siguientes funcionalidades:
Listar móviles insertados
Guardar en un fichero.txt todos los móviles*/

	
	
	
	
	public static void main(String[] args) {
		
		int movil=0;
		menu();
		
		Movil mov = null;		
		
		Scanner sc1 = new Scanner(System.in);
		
		int opcion= sc1.nextInt();
		
		while(opcion !=0) {
			
			
			switch(opcion) {
				case 1:
					System.out.println("Añadir movil");
					movilNuevo();
					break;
				case 2:
					//Pedir DAO
					//mov.getAll();
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
			menu();
			//System.out.println("Introduce opcion: ");
			//opcion=sc.nextInt();
		
		}
		sc1.close();
	}

	
	
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
		
		if(continuar.equals("s")) {
			mov.insert(mov);
			System.out.println("Movil insertado");
		}
		
		sc.close();
	}
	
}


