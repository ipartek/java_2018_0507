package com.ipartek.formacion.uf2216.RevistaPresentacion;


import java.io.File;

import java.io.PrintWriter;

import java.util.Scanner;


import com.ipartek.formacion.uf2216.RevistaAccesoadatos.CrudAble;
import com.ipartek.formacion.uf2216.RevistaAccesoadatos.RevistaArrayDao;
import com.ipartek.formacion.uf2216.RevistaPojo.Revista;




public class PresentacionRevistaMain {
private static CrudAble<Revista> revistas=RevistaArrayDao.getInstance();
private static int opcionMenu=-1,estado=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insertarRev();
		mostrarMenu();
		funcionEjecutora();		
}
private static void funcionEjecutora() {
	opcionMenu=leerTeclado();
	while(opcionMenu!=0) {
			if(estado>0) {
			mostrarMenu();
			opcionMenu=leerTeclado();
			}
		switch(opcionMenu){
			case 1:
				listarRevistas();
				break;
			case 2:
				crearRevista();
				break;
			case 3:
				encontrarPorTitulo();
				break;
			case 4:
				p("id de la revista a listar:");
				listadoRevistasPorId(leerTeclado());
				break;
			case 5:
				p("id de la revista a modificar:");
				modVideoXid(leerTeclado());
				break;
			case 6:
				guardar();
				break;
			case 7:
				p("id de la revista a borrar:");
				borrarRevistaXid(leerTeclado());;
				break;
			case 0:
				break;
		}
		estado=1;
		if(opcionMenu==0)
			break;
	}
}
private static void listadoRevistasPorId(long id) {		
		if(revistas.getById(id)==null)
			p("no exixte");
		else {
			mostrarCabecera();
			mostrarRevistas(revistas.getById(id));
		}
			
			
	}
private static void listarRevistas() {
	mostrarCabecera();
		for(Revista r: revistas.getAll()) {
			mostrarRevistas(r);
		}
	}
private static  void mostrarMenu() {
		
		p("--------------------");
		p("QUIOSCO PERLITAROSA");
		p("--------------------");
		p("");
		p("1. REVISTAS DISPONIBLES");
		p("2. CREAR REVISTA");
		p("3. BUSCAR REVISTA POR NOMBRE");
		p("4. BUSCAR REVISTA POR ID");
		p("5. MODIFICAR REVISTA POR ID");
		p("6. GUARDAR ruta por defecto(c:\\prueba\\prueba.txt)");
		p("7. BORRAR POR ID");
		p("0. Salir");
		p("Elige una opción");
		}

	private static  void crearRevista() {//creacion de revistas con comprobacion de id exixtente ,de isbn etc..
		Long id;
		p("vamos a crear una nueva Revista: ");
		
		do {
		p("dime un id:");
		 id=(long) leerTeclado();
		 if(revistas.getById(id)!=null)
				System.out.println("ya exixte");
		}while(revistas.getById(id)!=null);
		
		p("ahora el titulo ");
		String titulo=leerTecladoFrase();
		String isbn="";
		do {
			if(isbn.length()<10)
				p("min 10 caracteres");
		p("ahora isbn");
		isbn=leerTecladoFrase();
		}while(isbn.length()<10);
		int numPag=0;
			do {
				if(numPag<1)
					p("mete un numero de hojas mayor que 0");
				p("ahora numPaginas");
				 numPag=leerTeclado();
			}while (numPag<1);		
		String sino;
		do {
			p("por ultimo esta en formato Digital? si o no");
			sino =leerTecladoFrase();
			if(sino.equalsIgnoreCase("si"))
				revistas.insert(new Revista(id, titulo, isbn, numPag, true));
			else
				revistas.insert(new Revista(id, titulo, isbn, numPag, false));
		}while(!sino.equalsIgnoreCase("si") && !sino.equalsIgnoreCase("no"));
		
		
	}
	private static void modVideoXid(int id)	{//modificacion de videos con comprobacion de errores 
		//y sabiendo si exixte o no el id
		//mostrarCabecera();
		if(revistas.getById(id)==null)
		System.out.println("no exixte");
		else
		{
			p("ahora  titulo ");
			String titulo=leerTecladoFrase();
			String isbn="";
			do {
				if(isbn.length()<10)
					p("min 10 caracteres");
			p("ahora isbn");
			isbn=leerTecladoFrase();
			}while(isbn.length()<10);
			int numPag=0;
				do {
					if(numPag<1)
						p("mete un numero de hojas mayor que 0");
					p("ahora numPaginas");
					 numPag=leerTeclado();
				}while (numPag<1);		
			String sino;
			do {
				p("por ultimo esta en formato Digital? si o no");
				sino =leerTecladoFrase();
				if(sino.equalsIgnoreCase("si"))
					revistas.update(new Revista(id, titulo, isbn, numPag, true));
				else
					revistas.update(new Revista(id, titulo, isbn, numPag, false));
			}while(!sino.equalsIgnoreCase("si") && !sino.equalsIgnoreCase("no"));
		}
		
	}
	private static void p(String s) {
		System.out.println(s);
	}
	private static String leerTecladoFrase(){//para leer frases
		String i="";
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		try {
			i=teclado.nextLine();	
		}
		catch (NumberFormatException e) {
			System.out.println("mete un numero melon");
		}
	
		return i;
		}
	private static void mostrarRevistas(Revista r) {//muestra todas las revistas
		
		if(r.isDigital()==false)//false si no tiene formate digital
		p(r.getId() + "\t" + r.getTitulo() + "\t" + r.getNumPaginas()+ "\t"+ "papel") ;
		else
		p(r.getId() + "\t" + r.getTitulo() + "\t" + r.getNumPaginas()+ "\t"+ "digital") ;
	}
	private static void encontrarPorTitulo() {
		String titul;
		int exixte=0;
		p("que revista quieres buscar??");
		titul=leerTecladoFrase();
		for(Revista r:revistas.getAll()) {
			if (r.getTitulo().equalsIgnoreCase(titul)) {
				//mostrarCabecera();
				mostrarRevistas(r);
				exixte=1;
			}
		}
		if (exixte==0)
			System.out.println("no exixte");
	}
	private static int leerTeclado(){
		int i=-1;
		boolean repetir;
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		do {
			try {
				repetir=false;
				i=Integer.parseInt(teclado.nextLine());	
			}
			catch (NumberFormatException e) {
				System.out.println("mete un numero melon");
				repetir=true;
			}
			
		}while(repetir);
		return i;
	}
	private static void mostrarCabecera() {
		p("ID\tTITULO\tNº-PAG\tFORMATO");
		}
	private static String getCabecera()
	{
		return "ID\tTITULO\tNº-PAG\tFORMATO";
	}
	private static void insertarRev() {
		for(int i=1;i<6;i++)
		{
			if(i%2==0)
			revistas.insert(new Revista(i, i+"titu", "iñaki"+i,i,true));
			else
			revistas.insert(new Revista(i, i+"titul", "iñaki"+i,i,false));
		}
	}
	private static void borrarRevistaXid(int id)	{
		mostrarCabecera();
		p(revistas.getById(id)+"");
		revistas.delete(id);
	}
	private static void guardar() {//funcion para poder guardar un archivo
		// Validamos si existe el fichero, le ponemos el directorio que queremos 
		String sFichero = "c:\\prueba\\prueba.csv"; 

		File fichero = new File(sFichero);
		if (fichero.exists()) 
		System.out.println("El fichero " + sFichero + " ya existe"); 
		else {
			try {
				PrintWriter salida=new PrintWriter(fichero);
				salida.println("id"+";"+"titulo"+";"+ "numPaginas");
				for(Revista r :revistas.getAll())
				{
					salida.println(r.getId() + ";" + r.getTitulo() + ";" + r.getNumPaginas()+ ";"+ "papel");
					salida.flush();
					
				}
				salida.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
}