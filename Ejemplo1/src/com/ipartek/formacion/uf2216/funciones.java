package com.ipartek.formacion.uf2216;

import java.util.Scanner;

import com.ipartek.formacion.uf2216.Revista;

public class funciones {/*
	public static int unoodos() {
		Scanner pedirnum = new Scanner (System.in);
		String letra;
		int rspdos=0;
		boolean comprobante=false;
		do {
			letra=pedirnum.nextLine();
			try {
				rspdos=Integer.parseInt(letra);
				comprobante=false;
			}catch(Exception e) {
				comprobante=true;
			}
			if(rspdos==1||rspdos==2) {
				comprobante=false;
			}else {
				comprobante=true;
				System.out.println("el numero introducido tiene que ser 1 o 2");
			}
			
			}while(comprobante);
		
		return rspdos;
	}*/
	public static Revista pedirDatos() {
		
		Scanner pedirDatos = new Scanner (System.in);
		Revista obj=new Revista();
		boolean rsp=false;
		boolean digi=false;
		int numero=0;
		String respuesta;
		//introducir id
		do {
		System.out.println("introduce la id:");
		respuesta=pedirDatos.nextLine();
		try {
			numero=Integer.parseInt(respuesta);
			rsp=false;
		}catch(Exception e) {
			rsp=true;
		}
		
		}while(rsp);
		obj.setId(numero);
		//introducir titulo
		do {
			System.out.println("introdce el titulo");
			respuesta=pedirDatos.nextLine();
			
			if(respuesta.length()<3||respuesta.length()>150) {
				rsp=true;
				System.out.println("el titulo tiene que tener 3 letras como minimo y 150 como maximo");
			}else {
				rsp=false;
			}
			}while(rsp);
		obj.setTitulo(respuesta);
		//introducir isbn
		do {
		System.out.println("introduce el isbn:");
		respuesta=pedirDatos.nextLine();
		if(respuesta.length()==10) {
			rsp=false;
		}else {
			rsp=true;
		}
		
		}while(rsp);
		obj.setIsbn(respuesta);
		//introducir numero paginas
		do {
		System.out.println("introduce numero de paginas:");
		respuesta=pedirDatos.nextLine();
		try {
			numero=Integer.parseInt(respuesta);
			rsp=false;
		}catch(Exception e) {
			rsp=true;
		}if(numero<1) {
			rsp=true;
			System.out.println("la revista deve tener al menos una pagina");
		}
		
		}while(rsp);
		obj.setNumPaginas(numero);
		//introducir formato
		do {
		System.out.println("introduce 1-si es formato digital 2- si es formato fisico");
		respuesta=pedirDatos.nextLine();
		try {
			numero=Integer.parseInt(respuesta);
			rsp=false;
		}catch(Exception e) {
			rsp=true;
		}
		if(numero==1||numero==2) {
			rsp=false;
		}else {
			rsp=true;
		}
		}while(rsp);
		if(numero==1) {
			digi=true;
		}else {
			digi=false;
		}
		
		obj.setFormat(digi);
		return obj;
		
	}

}
