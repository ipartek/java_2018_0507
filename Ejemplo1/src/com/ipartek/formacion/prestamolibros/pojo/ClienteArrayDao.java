package com.ipartek.formacion.prestamolibros.pojo;

import java.util.ArrayList;
import java.util.List;

public class ClienteArrayDao implements CrudAble<Cliente>{

	private List<Cliente> clientes = new ArrayList<>();

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
		return clientes;
	}

	@Override
	public Cliente getById(long id) {
		Cliente resul = null;
<<<<<<< HEAD
		for(Cliente clienteIteracion : cliente) {
=======
		//foreach
		for(Cliente clienteIteracion : clientes) {
>>>>>>> branch 'Piero' of https://github.com/ipartek/java_2018_0507.git
			if (id == clienteIteracion.getId()) {
				resul = clienteIteracion;
				break;
			}
		}
		return resul;
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
