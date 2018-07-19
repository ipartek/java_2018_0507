package com.ipartek.formacion.GestionLibros;

import java.util.ArrayList;
import java.util.List;

public class GestionClientesDao implements CrudAble<Cliente> {

	private List<Cliente> clientes = new ArrayList<>();

	@Override
	public List<Cliente> getAll() {
		
		return clientes;
	}

	@Override
	public Cliente getByID(long id) {
		
		Cliente resultado = null;
		
		for (Cliente c: clientes) {
			if (id == c.getId()) {
				resultado = c;
			}
		}
		return resultado;
		
		
	}

	@Override
	public boolean insert(Cliente client) {
		
		boolean resultado = false;
		
		if (client != null) {
			resultado = clientes.add(client);
		}
		return resultado;
	}

	@Override
	public boolean update(Cliente pojo) {
		
		return false;
	}

//	@Override
//	public boolean delete(long id) {
//		
//		boolean resultado = false;
//		Cliente c = null;
//		
//		for (int i = 0; i < clientes.size(); i++) {
//			if (id == c.getId()) {
//				
//			}
//			
//		}
//	}

	@Override
	public boolean delete(Cliente pojo) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
