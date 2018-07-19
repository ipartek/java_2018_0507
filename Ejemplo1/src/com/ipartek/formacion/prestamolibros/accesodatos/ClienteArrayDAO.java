package com.ipartek.formacion.prestamolibros.accesodatos;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.prestamolibros.pojo.Cliente;
import com.ipartek.formacion.prestamolibros.pojo.Libro;

public class ClienteArrayDAO implements CrudAble<Cliente>{
	private List<Cliente> clientes=new ArrayList<>();
	private static ClienteArrayDAO INSTANCE;
	private ClienteArrayDAO(){
		
	}
	
	public static synchronized ClienteArrayDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new ClienteArrayDAO();
		}

		return INSTANCE;
	}
	
	
	@Override
	public List<Cliente> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Cliente cliente) {
		boolean resul = false;

		if (cliente != null) {
			resul = clientes.add(cliente);
		}
		return resul;		
		}
	@Override
	public boolean update(Libro libroUpdate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(Libro libro) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	
	
	
	
}
