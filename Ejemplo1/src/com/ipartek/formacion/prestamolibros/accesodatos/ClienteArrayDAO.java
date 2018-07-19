package com.ipartek.formacion.prestamolibros.accesodatos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.prestamolibros.pojo.Cliente;


public class ClienteArrayDAO implements CrudAble<Cliente>{

	private List<Cliente> clientes = new ArrayList<>();
	
	private static ClienteArrayDAO INSTANCE;
	
	private ClienteArrayDAO() {
	}

	/**
	 * metodo para crear una sola instancia de esta clase fuera de ella.
	 * si no hay una instancia creada se crea una y la devuelve
	 * @return INSTANCE
	 */
	public static synchronized ClienteArrayDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new ClienteArrayDAO();
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
		// foreach
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
	public boolean update(Cliente clienteUpdate) {
		boolean resul = false;
		Cliente clienteIterator = null;
		int i = 0;
		if (clienteUpdate != null) {
			// Iterator
			Iterator<Cliente> it = clientes.iterator();
			while (it.hasNext()) {
				clienteIterator = it.next();
				if (clienteIterator.getId() == clienteUpdate.getId()) {
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

		Cliente lIteracion = null;

		// buscar video a eliminar
		for (int i = 0; i < clientes.size(); i++) {

			lIteracion = clientes.get(i); // cliente sobre el que iteramos

			if (id == lIteracion.getId()) { // cliente encontrado
				resul = clientes.remove(lIteracion);
				break;
			}
		}

		return resul;
	}

}
