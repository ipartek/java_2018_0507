package com.ipartek.formacion.prestamolibros.pojo;

import java.util.ArrayList;
import java.util.List;

public class ClienteArrayDao implements CrudAble<Cliente>{

	private List<Cliente> cliente = new ArrayList<>();

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
		return cliente;
	}

	@Override
	public Cliente getById(long id) {
		Cliente resul = null;
		//foreach
		for(Cliente clienteIteracion : cliente) {
			if (id == clienteIteracion.getId()) {
				resul = clienteIteracion;
				break;
			}
		}
	}

	@Override
	public boolean insert(Cliente pojo) {
		// TODO Auto-generated method stub
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
