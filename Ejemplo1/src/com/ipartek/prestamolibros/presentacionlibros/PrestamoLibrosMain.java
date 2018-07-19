package com.ipartek.prestamolibros.presentacionlibros;

import java.util.Scanner;

import com.ipartek.formacion.video.accesoDatos.CrudAble;
import com.ipartek.formacion.video.accesoDatos.VideoYoutubeArrayDAO;
import com.ipartek.formacion.video.pojo.VideoYoutube;
import com.ipartek.prestamolibros.Libro;
import com.ipartek.prestamolibros.accesoDatos.PrestamoLibrosDAO;



public class PrestamoLibrosMain {

	Scanner sc = new Scanner(System.in);
	Scanner sc2 = new Scanner(System.in);
	Scanner sc3 = new Scanner(System.in);
	LeerTeclado lt = new LeerTeclado(sc);
	LeerTeclado lt2 = new LeerTeclado(sc2);
	LeerTeclado lt3 = new LeerTeclado(sc3);
	
	public static void main(String[] args) {
		
		cargarlibros();
		mostrarMenu();
		
	}

	private static void mostrarMenu() {
		// TODO Auto-generated method stub
		
	}

	private static void cargarlibros() {
	
		
	}
	
}

