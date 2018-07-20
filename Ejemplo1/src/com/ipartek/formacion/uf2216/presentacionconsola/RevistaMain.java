package com.ipartek.formacion.uf2216.presentacionconsola;

import java.io.FileWriter;
import java.io.PrintWriter;

import com.ipartek.formacion.uf2216.accesoDatos.CrudAble;
import com.ipartek.formacion.uf2216.accesoDatos.RevistaArrayDAO;
import com.ipartek.formacion.uf2216.pojo.Revista;

public class RevistaMain {

	private static CrudAble<Revista> dao = RevistaArrayDAO.getInstance();
	
	/* Opciones del menu */
	private static final int SALIR = 0;
	private static final int LISTADO = 1;
	private static final int INSERTAR_REVISTA = 2;
	private static final int MODIFICAR_REVISTA = 3;
	private static final int ELIMINAR_REVISTA = 4;
	private static final int GUARDAR_FICHERO = 5;
	
	/* Restricciones de insertar y modificar */
	private static final int MIN_PAGINAS = 1;
	private static final int MIN_LETRAS_TITULO = 3;
	private static final int MAX_LETRAS_TITULO = 150;
	private static final int TAMANO_ISBN = 10;
	
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
		case MODIFICAR_REVISTA:
			modificarRevista();
			break;
		case ELIMINAR_REVISTA:
			eliminarRevista();
			break;
		case GUARDAR_FICHERO:
			guardarEnFichero();
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
		for (int i = 1; i <= 5; i++) {
			try {
				dao.insert(new Revista(i, "titulo"+i,"123456789"+i,i,false));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		for (int i = 1; i <= 5; i++) {
			try {
				dao.insert(new Revista(i, "titulo"+i,"123456789"+i,i,true));
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
				revista.getTitulo() + "\t\t" +
				revista.getPaginas() + "\t" +
				revista.isFormato());
	}
	
	/* Insertar una revista --> llama a la funcion crearRevistaConDatosConsola() */
	private static void insertarRevista() {
		Revista revista = crearRevistaConDatosConsola();
		
		p("Los datos a insertar son los siguientes: ");
		mostrarCabecera();
		mostrarRevista(revista);
		p("Quiere insertarlos? (s/n)");
		String respuesta = Utils.leerLinea();
		
		if (respuesta.trim().equalsIgnoreCase("s")) {
			boolean resultadoOperacion = dao.insert(revista);
			
			if (resultadoOperacion) {
				p("Revista insertada correctamente");
			}else {
				p("ERROR al insertar video");
			}
		}
	}
	
	/* Modificar una revista --> llama a la funcion modificarRevistaConDatosConsola()*/
	private static void modificarRevista() {
		
		Revista revista = modificarRevistaConDatosConsola();
		
		boolean resultadoOperacion = dao.update(revista);
		 
		if (resultadoOperacion) {
			p("Revista modificada con exito");
		}else {
			p("ERROR al modificar revista");
		}
	}
	
	/* Eliminar una revista */
	private static void eliminarRevista() {
		p("ID de la revista a eliminar: ");
		long id = Utils.leerLong();
		
		boolean resultadoOperacion = dao.delete(id);
		
		if (resultadoOperacion) {
			p("Revista borrada correctamente");
		}else {
			p("ERROR al borrar revista");
		}
	}
	
	/* Funcion para mostrar acciones en pantalla y aceptarlas para crear una revista*/
	private static Revista crearRevistaConDatosConsola() {
		Revista revista = new Revista();
		
		p("ID: ");
		long id = Utils.leerLong();
		String isbn;
		do {
			p("ISBN (10 caracteres): ");
			isbn = Utils.leerIsbn();
		}while (isbn.length()!= TAMANO_ISBN);
		
		String titulo;
		
		do {
			p("Titulo revista (3-150 caracteres): ");
			titulo = Utils.leerLinea();
		}while (titulo.length() < MIN_LETRAS_TITULO || titulo.length() > MAX_LETRAS_TITULO);
		
		int paginas;
		
		do {
			p("Paginas (1 minimo): ");
			paginas = Utils.leerInt();
		}while (paginas < MIN_PAGINAS);
		
		int formatoCorrecto;
		do {
			p("Formato (digital o papel): ");
			formatoCorrecto = Utils.leerFormato();
		}while (formatoCorrecto == 0);
		
		boolean formato = false;
		switch (formatoCorrecto) {
		case 1:
			formato = true;
			break;
		case 2:
			formato = false;
			break;
		}
		
		try {
			revista = new Revista(id, titulo, isbn, paginas, formato);
		} catch (Exception e) {
			System.out.println("Error al crear una nueva revista.");
		}
		return revista;
	}
	
	/* Funcion para mostrar acciones en pantalla y aceptarlas para modificar una revista*/
	private static Revista modificarRevistaConDatosConsola() {
		Revista revista = new Revista();
		p("ID: ");
		long id_a_comprobar = Utils.leerLong();
		
		if (id_a_comprobar != dao.getById(id_a_comprobar).getId()) {
			p("ERROR al modificar revista");
			revista = null;
		}else {
			String isbn;
			do {
				p("ISBN (10 caracteres): ");
				isbn = Utils.leerIsbn();
			}while (isbn.length()!= TAMANO_ISBN);
			
			String titulo;
			do {
				p("Titulo revista (3-150 caracteres): ");
				titulo = Utils.leerLinea();
			}while (titulo.length() < MIN_LETRAS_TITULO || titulo.length() > MAX_LETRAS_TITULO);
			
			int paginas;
			do {
				p("Paginas (1 minimo): ");
				paginas = Utils.leerInt();
			}while (paginas < MIN_PAGINAS);
			
			int formatoCorrecto = 0;
			do {
				p("Formato (digital o papel): ");
				formatoCorrecto = Utils.leerFormato();
			}while (formatoCorrecto == 0);
			
			boolean formato = false;
			switch (formatoCorrecto) {
			case 1:
				formato = true;
				break;
			case 2:
				formato = false;
				break;
			}
		
			try {
				revista = new Revista(id_a_comprobar, titulo, isbn, paginas, formato);
			} catch (Exception e) {
				System.out.println("Error al crear una nueva revista.");
			}
		}
		
		return revista;
		
	}
	
	/* Funcion para guardar las revistas en un fichero */
	private static void guardarEnFichero() {
        String nombreFichero = "C:/Users/curso/Documents/Revistas.csv";
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(nombreFichero);
            pw = new PrintWriter(fichero);
            pw.println("ID,ISBN,Titulo,Paginas,Formato");
            
            for (Revista revista: dao.getAll()) {
            	pw.println(revista.getId() + "," +
            			revista.getIsbn() + "," +
            			revista.getTitulo() + "," +
            			revista.getPaginas() + "," +
            			revista.isFormato()
            			);
            }
            p("Fichero creado correctamente!!");
        } catch (Exception e) {
            p("Error al intentar guardar los datos en un fichero");
        } finally {
           try {
           // Nuevamente aprovechamos el finally para asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              p("Error al intentar cerrar el fichero");
           }
        }
	}
	
	
	
	/* Cabecera de los datos de Revistas */
	private static void mostrarCabecera() {
		p("ID\tISBN\t\tTITULO\t\tPAGINAS\tFORMATO");
	}
	
	/* Menu escrito del programa*/
 	private static void mostrarMenu() {
		p("------------");
		p("  Revistas");
		p("------------");
		p("1. Listado de revistas");
		p("2. Insertar revista");
		p("3. Modificar revista");
		p("4. Eliminar revista");
		p("5. Guardar revistas en fichero");
		p("");
		p("0. Salir de la aplicacion");
		p("Elige una opcion: ");
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
