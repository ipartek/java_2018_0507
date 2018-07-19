package com.ipartek.formacion.accesoDatos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.prestamoLibrosPojo.Cliente;

public class ClienteDAO implements CrudAble<Cliente>{
	
	private List<Cliente> clientes = new ArrayList<>(); 

	// SINGLENTON
	private static ClienteDAO INSTANCE;
	private ClienteDAO() {}
	
	public static synchronized ClienteDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ClienteDAO();
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
		for (Cliente clienteIteracion : clientes) {
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
	public boolean update(Cliente cliente) {
		boolean resul = false;
		Cliente videoIteracion = null;
		int i = 0;
		
		if (cliente != null){
			Iterator<Cliente> it = clientes.iterator();	// Iterator	
			while(it.hasNext()) {
				videoIteracion = it.next();
				if (videoIteracion.getId() == cliente.getId()) {
					clientes.set(i, cliente);
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
		Cliente cIteracion = null;
		
		// Buscar video a eliminar
		for (int i = 0; i < clientes.size(); i++) {
			cIteracion = clientes.get(i);   			// Cliente sobre el que iteramos
			
			if (id == cIteracion.getId()) {    			// Cliente encontrado
				resul = clientes.remove(cIteracion);
				break;
			}
		}
			
		return resul;
	}
	
	public Cliente getByDni(String dni) {
		Cliente resul = null;
		
		//foreach
		for (Cliente clienteIteracion : clientes) {
			if (dni == clienteIteracion.getDni()) {
				resul = clienteIteracion;
				break;
			}
		}
		return resul;
	}
}
