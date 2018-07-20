package com.ipartek.formacion.prestamoLibro.accesoAdatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ipartek.formacion.prestamoLibro.pojo.Cliente;

public class ClienteArrayDao implements CrudAble<Cliente> {
	List <Cliente> clientes=new ArrayList<>();
	private static ClienteArrayDao INSTANCE;
	private String[] hola=new String[2];
	private ClienteArrayDao() {
		
	}
	public static synchronized ClienteArrayDao getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new ClienteArrayDao();
		}

		return INSTANCE;
	}
	@Override
	public List<Cliente> getAll() {
		// TODO Auto-generated method stub
		
		return clientes;
	}

	@Override
	public Cliente getById(long id) {
		// TODO Auto-generated method stub
		Cliente cli=null;
		for(Cliente c :clientes)
			if(c.getId()==id)
			{
				return c;
			}
		return cli;
	}

	@Override
	public boolean insert(Cliente pojo) {
		// TODO Auto-generated method stub
		if(pojo!=null)
			clientes.add(pojo);
		return false;
	}

	@Override
	public boolean update(Cliente pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long auxiliar) {
		// TODO Auto-generated method stub
		
		for(Cliente c:clientes)
		{
			if(c.getId()==auxiliar) {
				if(c.getLibrosPrestados().size()==0)
					p("no tiene alquileres chacho");
				else {
					String titulo;
					p("dime el titulo a liberar");
					titulo=leerTecladoLetra();
					for(int i=0;i<c.getLibrosPrestados().size();i++)
						if(c.getLibrosPrestados().get(i).getTitulo().equalsIgnoreCase(titulo)) {
							System.out.println("tengo el libro"+ c.getLibrosPrestados().get(i).getTitulo());
							c.getLibrosPrestados().get(i).setCliente(null);
							c.getLibrosPrestados().remove(i);
						}
						
				}
			}
		}
		return false;
	}
	private static String leerTecladoLetra(){
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
	
	private static void p(String s)
	{
		System.out.println(s);
	}
	

}
