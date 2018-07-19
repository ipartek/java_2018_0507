package com.ipartek.formacion.GestionLibros;

import java.util.ArrayList;
import java.util.Iterator;
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
	public boolean update(Cliente cliente) {
		
		boolean resultado = false;
		Cliente cliIte = null;
		int i =0;
		
		if (cliente != null){
		Iterator<Cliente> c = clientes.iterator();
		
		while(c.hasNext()) {
			cliIte = c.next();
			if ( cliIte.getId() == cliente.getId() ) {
				clientes.set(i, cliente);
				resultado = true;
				break;					
			}	
			i++;
			}
		}		
			return resultado;
		
	}

	@Override
	public boolean delete(long id) {
		
		boolean resultado = false;
		Cliente c = null;
		
		for (int i = 0; i < clientes.size(); i++) {
			c= clientes.get(i);
		}
			if (id == c.getId()) {
				resultado = clientes.remove(c);
			}
		return resultado;	
		
	}


	
	
}
