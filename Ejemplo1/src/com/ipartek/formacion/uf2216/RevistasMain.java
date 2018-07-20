package com.ipartek.formacion.uf2216;


public class RevistasMain {

	private static final int LISTADO = 1;
	private static final int ADD_REVISTA = 2;
	//private static final int ELIMINAR_REVISTA = 3;
	private static final int SALIR = 0;
	
	private static CrudAble<Revista> dao = RevistaArrayDao.getInstance();
	
	public static void main(String[] args) {
		cargarRevistas();
		
		int opcion;
		
		do {
			mostrarMenu();
			opcion = Utils.leerInt();
			procesarOpcion(opcion);
			
		}while (opcion != SALIR);
	}
	
	private static void procesarOpcion(int opcion) {
		switch (opcion) {
		case LISTADO:
			listadoRevistas();
			break;
		case ADD_REVISTA:
			insertarRevista();
			break;
		case SALIR:
			salir();
			break;
		default:
			noDisponible();
			break;
		}
	}
	
	//MENU del programa
	private static void mostrarMenu() {
		p("------------");
		p("Revistas");
		p("------------");
		p("");
		p("1. Listado de revistas");
		p("2. Añadir revista");
		//p("3. Eliminar revista");
		p("");
		p("0. Salir");
		p("Elige una opcion: ");
	}
	
	// CARGAR REVISTAS: metodo para cargar todas las revistas (inicialmente 6)
	private static void cargarRevistas() {
		CrudAble<Revista> dao = RevistaArrayDao.getInstance();
		
		for (int i = 1; i <= 6; i++) {
			try { 					 //id, titulo, isbn, numPag, formato
				dao.insert(new Revista(i, "titulo" + i,"1234567890", i, true));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	
	// LISTADO: listar todas las revistas
	private static void listadoRevistas() {
		mostrarCabecera();
		
		for (Revista revista: dao.getAll()) {
			mostrarRevista(revista);
		}
	}
	
	// MOSTRAR REVISTA por ID
	private static void mostrarRevista(Revista revista) {
		p(revista.getId() + "\t" + revista.getIsbn() + "\t" +  revista.getTitulo() + 
				"\t" + revista.getNumPag() + "\t" + revista.isFormato());
	}
	
	// AÑADIR REVISTA Insertar una revista 
	private static void insertarRevista() {
		//llamo a la funcion ¬ que contiene los datos introducidos por teclado
		Revista revista = crearRevistaConDatosDeConsola();
		
		boolean resultadoOperacion = dao.insert(revista);
		
		if (resultadoOperacion) {
			p("Revista insertada correctamente");
		}else {
			p("ERROR al insertar video");
		}
	}
	
	// Datos introducidos por consola
	private static Revista crearRevistaConDatosDeConsola() {
		p("ID: ");
		long id = Utils.leerLong();
		p("ISBN: ");
		String isbn = Utils.leerLinea();
		p("Titulo: ");
		String titulo = Utils.leerLinea();
		p("Numero de paginas: ");
		int numPag = Utils.leerInt();
		p("Formato (digital o papel): ");
		String formato = Utils.leerLinea();

		boolean formatoFinal = tipoFormato(formato);
		
		Revista revista = new Revista();
		try {
			revista = new Revista(id, titulo, isbn, numPag, formatoFinal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return revista;
	}
	
	// Si el formato introducido es true -> papel, si es false -> digital
	private static boolean tipoFormato(String formato) {
		boolean res = false;
		if (formato.trim().equalsIgnoreCase("papel")){
			res = true;
		}else if (formato.trim().equalsIgnoreCase("digital")) {
			res = false;
		}
		return res;
	}
	
	private static void mostrarCabecera() {
		p("ID\tISBN\tTITULO\tPAGINAS\tFORMATO");
	}
	
	private static void noDisponible() {
		p("Esa funcion no existe.");
	}

	private static void salir() {
		p("Has salido del programa.");
	}	
	
	private static void p (String s) {
		System.out.println(s);
	}
	
	
}
