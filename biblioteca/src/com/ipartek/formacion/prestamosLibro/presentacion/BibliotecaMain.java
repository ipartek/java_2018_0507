package com.ipartek.formacion.prestamosLibro.presentacion;

import java.util.Scanner;

import com.ipartek.formacion.prestamoLibro.accesoAdatos.ClienteArrayDao;
import com.ipartek.formacion.prestamoLibro.accesoAdatos.CrudAble;
import com.ipartek.formacion.prestamoLibro.accesoAdatos.LibroArrayDao;
import com.ipartek.formacion.prestamoLibro.pojo.Cliente;
import com.ipartek.formacion.prestamoLibro.pojo.Libro;


public class BibliotecaMain {
	private static CrudAble<Libro> libros = LibroArrayDao.getInstance();
	private static CrudAble<Cliente> clientes = ClienteArrayDao.getInstance();
	private static int opcionMenu=-1,estado=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			insertarClientesYLibros();
			mostrarMenu();
			opcionMenu=leerTeclado();
			while(opcionMenu!=0) {
					if(estado>0) {
					mostrarMenu();
					opcionMenu=leerTeclado();
					}
				switch(opcionMenu){
					case 1:
						librosDisponibles();
						break;
					case 2:
						librosAlquilados();
						break;
					case 3:
						listadoClientes();
						break;
					case 4:
						encontrarPorTitulo();
						break;
					case 5:
						alquilarLibro();
						break;
					case 6:
						borrarAlquiler();
						break;
					case 7:
						p("id del libro a listar:");
						listarLibroPorId(leerTeclado());;
						break;
					case 8:
						p("id del cliente a listar:");
						listadoClientePorId(leerTeclado());
						break;
					case 9:
						crearLibro();
						break;
					case 10:
						crearCliente();						
						break;
					case 0:
						break;
				}
				estado=1;
				if(opcionMenu==0)
					break;
			}
		
	}
	private static void crearLibro() {
		p("vamos a crear un nuevo libro muchacho: ");
		p("dime un id:");
		Long id=(long) leerTeclado();
		p("ahora el titulo ");
		String titulo=leerTecladoFrase();
		p("ahora el autor");
		String autor=leerTecladoFrase();
		p("ahora isbn");
		String isbn=leerTecladoFrase();
		p("por ultimo editorial");
		String editorial =leerTecladoFrase();
		libros.insert(new Libro(id, titulo, autor, editorial, isbn));
	}
	private static void borrarAlquiler() {
		int auxiliar=-1;
		p("dime que alquiler De cliente quieres borrar quieres borrar");
		auxiliar=leerTeclado();
		clientes.delete(auxiliar);		
	}
	private static void crearCliente() {
		p("vamos a crear un nuevo cliente muchacho: ");
		p("dime un id:");
		Long id=(long) leerTeclado();
		p("ahora el dni");
		String dni=leerTecladoFrase();
		p("ahora tu nombre");
		String nombre=leerTecladoFrase();
		p("por ultimo apellidos");
		String apellidos =leerTecladoFrase();
		clientes.insert(new Cliente(id, dni, nombre, apellidos));
	}
	
	private static void mostrarMenu() {
		
		p("--------------------");
		p("BIBLIOTECA IGNAZIANA");
		p("--------------------");
		p("");
		p("1. LIBROS DISPONIBLES");
		p("2. LIBROS ALQUILADOS");
		p("3. CLIENTES ");
		p("4. BUSCAR LIBRO POR NOMBRE");
		p("5. ALQUILAR LIBRO");
		p("6. DEVOLVER LIBRO");
		p("7. BUSCAR LIBRO POR ID");
		p("8. LISTAR CLIENTE POR ID");
		p("9. CREAR UN LIBRO NUEVO");
		p("10. CREAR UN CLIENTE NUEVO");
		p("0. Salir");
		p("Elige una opción");
		}
	private static void encontrarPorTitulo() {
		String titul;
		int exixte=0;
		p("que libro quieres buscar??");
		titul=leerTecladoFrase();
		for(Libro l:libros.getAll()) {
			if (l.getTitulo().equalsIgnoreCase(titul)) {
				System.out.println("el libro con titulo " + titul+"exixte");
				exixte=1;
			}
		}
		if (exixte==0)
			System.out.println("no exixte");
	}
	private static void librosDisponibles() {
		
		for(Libro l:libros.getAll())
		{
			if (l.isLibre()==false)
				p(l + "esta libre");
		}
	}
		private static void librosAlquilados() {
		
		for(Libro l:libros.getAll())
		{
			if (l.isLibre()!=false)
				p(l.getTitulo() + " esta ocupado por "+l.getCliente().getNombre());
		}
	}
	private static void alquilarLibro()
	{
		int idLibro,idCliente;
		p("QUE LIBRO QUIERES ALQUILAR DIME ID");
		idLibro=leerTeclado();
		p("que cliente lo alquila? dime id");
		idCliente=leerTeclado();
		
		//System.out.println(idCliente+""+idLibro+"holaaa");
		if(libros.getById(idLibro).isLibre()==false)
		{
			libros.getById(idLibro).setCliente(clientes.getById(idCliente));
			//System.out.println(idCliente+""+idLibro+"holaaa");
			if(libros.getById(idLibro)!=null)
				clientes.getById(idCliente).addLibro(libros.getById(idLibro));
		}
		else
			System.out.println("LIBRO YA ALQULADO PERSONAJE");
				
		//listadolibros();
	}
	private static void listadoClientePorId(long id) {
//		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();			
		System.out.println(clientes.getById(id));
	}
	private static void listadoClientes() {
//		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();			
		for(Cliente video: clientes.getAll()) {
			mostrarClientes(video);
		}
	}
	private static void listadolibros() {
//		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();			
		for(Libro libro: libros.getAll()) {
			mostrarLibros(libro);
		}
	}
	private static void listarLibroPorId(long id) {
		System.out.println(libros.getById(id));
	}
	private static void insertarClientesYLibros() {
		for(int i=1;i<6;i++)
		{
			clientes.insert(new Cliente(i, i+"1234567", "iñaki"+i, "alvira"+i));
			libros.insert(new Libro(i, i+"libro", i+"libro", i+"libro", i+12233+""));
		}
	}
	private static void p(String s) {
		System.out.println(s);
	}
	private static void mostrarLibros(Libro libro) {
		p(libro.getId() + "\t" + libro.getTitulo() + "\t" +libro.getEditorial()+"\t"+libro.getAutor()+"\t"+libro.getCliente());
	}
	private static void mostrarClientes(Cliente cli) {
		p(cli.getId() + "\t" + cli.getNombre() + "\t" + cli.getApellidos());
	}
	private static String leerTecladoFrase(){
		String i="";
		Scanner teclado = new Scanner(System.in);
		try {
			i=teclado.nextLine();	
		}
		catch (NumberFormatException e) {
			System.out.println("mete un numero melon");
		}
	
		return i;
		}
	private static int leerTeclado(){
		int i=-1;
		boolean repetir;
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
}
