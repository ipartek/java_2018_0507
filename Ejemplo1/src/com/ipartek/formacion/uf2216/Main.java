package com.ipartek.formacion.uf2216;


import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.*;





public class Main {

	private static final int INSERTAR = 1;
	private static final int LISTAR = 2;
	private static final int GUARDAR = 3;
	private static final int SALIR = 0;

	public static void main(String[] args) {
		Menu();
		

	}
	
	private static void Menu() {
		
		int opcion;
		
		do {
			e("--------------------");
			e("------REVISTAS------");
			e("--------------------");
			e("Que operacion desea realizar:");
			e("1. Insertar nueva revista");
			e("2. Listar revistas insertadas");
			e("3. Guardar todas las Revistas en un Fichero");
			e("0. Salir");
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			opcion = sc.nextInt();
			
			switch (opcion) {
			
			case INSERTAR:
				InsertarRevista();
				break;
			case LISTAR:	
				ListarRevistas();
				break;
			case GUARDAR:	
				GuardarRevistas();
				break;
			case SALIR:
				e("Hasta luego");				
				break;
			default:
				e("No ha seleccionado ninguna de las opciones posibles");
			}
		}while (opcion != 0);
		
	}
	
	public static void e(String s) {
		System.out.println(s);
	}
	
	private static void InsertarRevista()  {
		
		CrudAble<Revistas> dao = RevistasArrayDAO.getInstance();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Inserta el ID");
		String id = sc.nextLine();
		long id2=Integer.parseInt(id);
		Pattern p3 = Pattern.compile("^[0-9]$");
	    Matcher m3 = p3.matcher(id);
	    if (m3.find()==false)
	    	e("Has metido un caracter, tienes que meter un numero");
		
		e("Inserta el titulo");
		String titulo = sc.nextLine();
		Pattern p = Pattern.compile("^[a-zA-Z0-9]{3,150}$");
	    Matcher m = p.matcher(titulo);
	    if (m.find()==false)
	    	e("Has metido mal los datos, te faltan caracteres");
	         
	    	
	   
	    e("Inserta el ISBN");
	    String isbn = sc.nextLine();
	    Pattern p1 = Pattern.compile("^[A-Z0-9]{10}$");
	    Matcher m1 = p1.matcher(isbn);
	    if (m1.find()==false)
	         e("Tienes que insertar 10 caracteres exactos");
	    
	    e("Inserta el numero de paginas de la Revista");
	    String numP = sc.nextLine();
	    int numero = Integer.parseInt(numP);
	    Pattern p2 = Pattern.compile("^[0-9]{1,}$");
	    Matcher m2 = p2.matcher(numP);
	    if (m2.find()== false)
	         e("No puedes insertar Letras y minimo un 1");
	    
	  
	    e("Inserta el formato que desea (True=digital y False=papel");
	    boolean formato = sc.nextBoolean();
	    
	    if (formato == true) {
	    Revistas re = new Revistas(id2,titulo,isbn,numero,true);
	    if (dao.insert(re)) 
	  		e("La revista se ha añadido correctamente");
	  		else
	  		e("La revista no se ha añadido");
	    
	    	
	    }
	    else if(formato == false) {
	    Revistas re = new Revistas(id2,titulo,isbn,numero,false);
	    if(dao.insert(re)) 
	  		e("La revista se ha añadido");
	  		else
	  		e("La revista no se ha añadido");
	    
	    }
	    
	    ListarRevistas();
	    
	}
	
	private static void ListarRevistas() {
		
		CrudAble<Revistas> dao = RevistasArrayDAO.getInstance();
		
		for(Revistas re: dao.getAll()) {
			e("ID: " + re.getId() + " Titulo: " + re.getTitulo() + " ISBN: "+ re.getISBN()+" Numero paginas: " + re.getPaginas()
			+ " Formato: " + re.isFormato());
		}
	}
	
	private static void GuardarRevistas() {
		
		CrudAble<Revistas> dao = RevistasArrayDAO.getInstance();
		
	
		 	FileWriter fichero = null;
	        PrintWriter pw = null;
	        try
	        {
	            fichero = new FileWriter("C:\\Users\\curso\\git\\revistas.txt", false);
	            pw = new PrintWriter(fichero);

	            for (Revistas r: dao.getAll())
	                pw.println("ID:" + r.getId() + "\t" + "Titulo: "  + r.getTitulo()+  "\t" + "ISBN: " + r.getISBN()+ "\t" + "Numero Paginas: " + r.getPaginas() + "\t"
	                + "Formato: " + r.isFormato());

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           try {
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }

	}
		
}

