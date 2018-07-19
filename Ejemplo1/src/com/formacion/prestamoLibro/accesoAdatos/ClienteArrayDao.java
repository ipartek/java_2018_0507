package com.formacion.prestamoLibro.accesoAdatos;

import java.util.ArrayList;
import java.util.List;

import com.formacion.prestamoLibro.pojo.Cliente;

public class ClienteArrayDao implements CrudAble<Cliente> {
	List <Cliente> clientes=new ArrayList<>();
	private static ClienteArrayDao INSTANCE;
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
			else
				System.out.println("no");
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
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
