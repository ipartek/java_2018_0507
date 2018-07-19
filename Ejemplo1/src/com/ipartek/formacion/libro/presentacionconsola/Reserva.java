package com.ipartek.formacion.libro.presentacionconsola;

import java.util.List;
import java.util.Scanner;

import com.ipartek.formacion.libro.accesodatos.ClienteArrayDAO;
import com.ipartek.formacion.libro.accesodatos.CrudAble;
import com.ipartek.formacion.libro.accesodatos.LibroArrayDAO;
import com.ipartek.formacion.libro.pojo.Cliente;
import com.ipartek.formacion.libro.pojo.Libro;

public class Reserva {
	
public static void reserva() {
	
	System.out.println(">>Introduce el id del libro reservado: ");
	Scanner sc1 = new Scanner(System.in);
	long idLibro = sc1.nextLong();

	System.out.println(">>Introduce el id del cliente que lo reserva: ");
	Scanner sc2 = new Scanner(System.in);
	long idCliente = sc2.nextLong();
	
	
	CrudAble<Libro> dao1 = LibroArrayDAO.getInstance();;
	Libro libro = dao1.getById(idLibro);
	
	CrudAble<Cliente> dao2 = ClienteArrayDAO.getInstance();;
	Cliente cliente = dao2.getById(idCliente);
	
	
	libro.setCliente(idCliente);
	
	
	/* TODO meter el libro como reservado en el cliente y viceversa
	libro.setCliente(cliente);
	cliente.setLibrosPrestados(List.<Libro>.);
	*/

	System.out.println("Reserva realizada");
	LibroMenu.listadoLibros();
	ClienteMenu.listadoClientes();
	sc1.close();
	sc2.close();
}

}
