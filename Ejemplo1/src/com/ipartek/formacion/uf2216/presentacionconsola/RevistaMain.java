package com.ipartek.formacion.uf2216.presentacionconsola;

import com.ipartek.formacion.uf2216.accesoDatos.CrudAble;
import com.ipartek.formacion.uf2216.accesoDatos.RevistaArrayDAO;
import com.ipartek.formacion.uf2216.pojo.Revista;

public class RevistaMain {

	private static CrudAble<Revista> dao = RevistaArrayDAO.getInstance();
	
	private static final int SALIR = 0;
	private static final int LISTADO = 1;
	private static final int INSERTAR_REVISTA = 2;
	
	public static void main(String[] args) {
		// Hay que empezar cargando las revistas
		cargarRevistas();
		
		int opcion;
		do {
			mostrarMenu();
			opcion = Utils.leerInt();
			procesarOpcion(opcion);
		}while (opcion != SALIR);

	}
	
	private static void procesarOpcion(int opcionMenu) {
		switch (opcionMenu) {
		case LISTADO:
			listadoRevistas();
			break;
		case INSERTAR_REVISTA:
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
	
	/* Cargar todas las revistas */
	private static void cargarRevistas() {
		for (int i = 1; i <= 10; i++) {
			try {
				dao.insert(new Revista(i, "titulo"+i,"1234567890",i,false));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	
	/* Listar las revistas*/
	private static void listadoRevistas() {
		mostrarCabecera();
		
		for (Revista revista: dao.getAll()) {
			mostrarRevista(revista);
		}
	}
	
	/* Mostrar una revista*/
	private static void mostrarRevista(Revista revista) {
		p(revista.getId() + "\t" + 
				revista.getIsbn() + "\t" + 
				revista.getTitulo() + "\t" +
				revista.getPaginas() + "\t" +
				revista.isFormato());
	}
	
	/* Insertar una revista --> llama a la funcion crearRevistaConDatosConsola() */
	private static void insertarRevista() {
		Revista revista = crearRevistaConDatosConsola();
		
		boolean resultadoOperacion = dao.insert(revista);
		
		if (resultadoOperacion) {
			p("Revista insertada correctamente");
		}else {
			p("ERROR al insertar video");
		}
	}
	
	/* Funcion para mostrar acciones en pantalla y aceptarlas para crear una revista*/
	private static Revista crearRevistaConDatosConsola() {
		p("ID: ");
		long id = Utils.leerLong();
		p("ISBN: ");
		String isbn = Utils.leerLinea();
		p("Titulo revista: ");
		String titulo = Utils.leerLinea();
		p("Paginas: ");
		int paginas = Utils.leerInt();
		p("Formato (digital o papel): ");
		String formato = Utils.leerLinea();

		boolean formatoBueno = comprobarFormato(formato);
		
		Revista revista = new Revista();
		try {
			revista = new Revista(id, titulo, isbn, paginas, formatoBueno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return revista;
	}
	
	/* Funcion para transformar Formato (digital o papel) true == digital, false == papel*/
	private static boolean comprobarFormato(String formato) {
		boolean resul = false;
		if (formato.trim().equalsIgnoreCase("digital")){
			resul = true;
		}else if (formato.trim().equalsIgnoreCase("papel")) {
			resul = false;
		}
		
		return resul;
	}
	
	/* Menu escrito del programa*/
	private static void mostrarMenu() {
		p("------------");
		p("Revistas");
		p("------------");
		p("");
		p("1. Listado de revistas");
		p("2. Insertar revista");
		p("");
		p("0. Salir de la aplicacion");
		p("Elige una opcion: ");
	}
	
	/* Cabecera de los datos de Revistas */
	private static void mostrarCabecera() {
		p("ID\tISBN\tTITULO\tPAGINAS\tFORMATO");
	}
	
	/* Cosas a hacer cuando se va a salir */
	private static void salir() {
		p("ADIOS!!!");
	}
	
	/* Cosas que se hacen cuando el usuario introduce una opcion incorrecta */
	private static void noDisponible() {
		p("Esa funcion no existe");
	}

	/* Funcion que sirve para no escribir System.out.println todo el rato*/
	private static void p (String s) {
		System.out.println(s);
	}
}
