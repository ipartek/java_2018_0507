package com.ipartek.formacion.prestamolibro.presentacionconsola;

import java.util.Scanner;

import com.ipartek.formacion.prestamolibros.accesodatos.CrudAble;
import com.ipartek.formacion.prestamolibros.accesodatos.CrudAbleLibro;
import com.ipartek.formacion.prestamolibros.accesodatos.LibroArrayDAO;
import com.ipartek.formacion.prestamolibros.pojo.Cliente;
import com.ipartek.formacion.prestamolibros.pojo.Libro;

public class BibliotecaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		cargarLibros();
		
		mostrarMenu();
		
//		Libro libro=new Libro(12,"isbn","titulo","autor","editorial",new Cliente());
//		
//		p(libro.getId() + "\t" + libro.getAutor()+"\t"+libro.getEditorial()+"\t"+libro.getIsbn()+"\t"+libro.getTitulo()+libro.getCliente());

	}
//pedir prestado devolver listado disponibles listado prespado y a quien se lo as prestado
	
	private static void mostrarMenu() {
		
p("selecciona una opcion");
		
		p("0.salir");
		p("1.Subir un libro");
		p("2.Subir un cliente");
		p("3.actualizar libro");
		p("4.actualizar cliente");
		p("5.eliminar libro");
		p("6.eliminar cliente");
		p("7.mostrar lista libros");
		p("8.mostrar lista clientes");
		p("9.mostrar lista libros disponibles");
		p("10.pedir prestado");
		p("11.lista prestados y a quien");

empezar();
}
	
	private static void empezar() {
		// TODO Auto-generated method stub
		Scanner o=new Scanner(System.in);
		
		int opcion = o.nextInt();
			
			switch(opcion) {
			case 0:
			
				break;
				
			case 1:
				insertarLibros();
				break;
			case 2:
				insertarClientes();
				break;
			case 3:
				actualizarLibros();
				break;
			case 4:
				actualizarClientes();
				break;
				
			case 5:
				eliminarLibros();
				break;
				
			case 6:
				eliminarClientes();
				break;
				
			case 7:
				mostrarListaLibros();
				break;
				
			case 8:
				mostrarListaClientes();
				break;
				
			case 9:
				librosDisponibles();
				break;
				
			case 10:
				pedirPrestado();
				break;
				
			case 11:
				listaPrestados();
				break;
				
		
						}
	}
	
	
	private static void listaPrestados() {
		// TODO Auto-generated method stub
		
	}

	private static void pedirPrestado() {
		// TODO Auto-generated method stub
		
	}

	private static void librosDisponibles() {
		// TODO Auto-generated method stub
		
	}

	private static void mostrarListaClientes() {
		// TODO Auto-generated method stub
		
	}

	private static void mostrarListaLibros() {
		// TODO Auto-generated method stub
		LibroArrayDAO dao= LibroArrayDAO.getInstance();
		for(Libro libro:dao.getAll()) {
mostrarLibro(libro);
		}
	}

	private static void eliminarClientes() {
		// TODO Auto-generated method stub
		
	}

	private static void eliminarLibros() {
		// TODO Auto-generated method stub
		
	}

	private static void actualizarClientes() {
		// TODO Auto-generated method stub
		
	}

	private static void actualizarLibros() {
		// TODO Auto-generated method stub
		
	}

	private static void insertarClientes() {
	// TODO Auto-generated method stub
	
}
//	private static void listadoLibros() {
//		
//	}
	public static void mostrarLibro(Libro libro) {
		p(libro.getId()+"\t" + libro.getAutor()+"\t"+libro.getEditorial()+"\t"+libro.getIsbn()+"\t"+libro.getTitulo()+"\t"+libro.getCliente());
		
	}
	
public static void mostrarCliente() {
		
		
	}
	private static void listadoClientes() {
		// TODO Auto-generated method stub
		
	}


	private static void insertarLibros() {
		// TODO Auto-generated method stub
		CrudAble<Libro> dao= LibroArrayDAO.getInstance();
		

	}



	private static void cargarLibros() {
		// TODO Auto-generated method stub
		LibroArrayDAO dao= LibroArrayDAO.getInstance();
		
		
			dao.insert(new Libro(7,"isbn","titulo","autor","editorial",new Cliente()));
			dao.insert(new Libro(1,"isbn","titulo","autor","editorial",new Cliente()));
			dao.insert(new Libro(3,"isbn","titulo","autor","editorial",new Cliente()));

		

	}

	private static void p(String p) {
		System.out.println(p);
	}
	
	private static void mostrarLista(){

	}
}
