package com.ipartek.prestamolibros.accesoDatos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.prestamolibros.Cliente;

public class ClientesArrayDAO implements CrudAble<Cliente> {
	private List<Cliente> clientes = new ArrayList<>();
	private static ClientesArrayDAO INSTANCE;
	
	private ClientesArrayDAO() {
	}
	public static synchronized CrudAble<Cliente> getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ClientesArrayDAO();
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
		//foreach
		for (Cliente libroIteracion : clientes) {
			if ( id == libroIteracion.getId() ) {
				resul = libroIteracion;
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
	public boolean update(Cliente clienteUpdate) {
		boolean resul = false;
		Cliente libroIteracion = null;
		int i = 0;
		if ( clienteUpdate != null ) {
			//Iterator		
			Iterator<Cliente> it = clientes.iterator();
			while( it.hasNext() ) {
				libroIteracion = it.next();
				if ( libroIteracion.getId() == clienteUpdate.getId() ) {
					clientes.set(i, clienteUpdate);
					resul = true;
					break;					
				}	
				i++;
			}		
		}	
		return resul;
	}

	@Override
	public boolean delete(long id) {
		boolean resul = false;
		
		Cliente vIteracion = null;
		
		//buscar libro a eliminar
		for (int i = 0; i < clientes.size(); i++) {
			
			vIteracion = clientes.get(i);   //cliente sobre el que iteramos
			
			if ( id == vIteracion.getId() ) {    // cliente encontrado
				resul = clientes.remove(vIteracion);
				break;
			}
		}
		
		return resul;
	}
	
	

}
