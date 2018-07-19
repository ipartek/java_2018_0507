package com.ipartek.formacion.libro.accesodatos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.libro.pojo.Cliente;
import com.ipartek.formacion.libro.pojo.Libro;
import com.ipartek.formacion.video.pojo.VideoYoutube;

public class ClienteArrayDAO implements CrudAble<Cliente> {

	private List<Cliente> clientes = new ArrayList<>();

	private static ClienteArrayDAO INSTANCE;

	private ClienteArrayDAO() {
	}

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
		//foreach
		for (Cliente clienteIteracion : clientes) {
			if ( id == clienteIteracion.getId() ) {
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
		Cliente clienteIteracion = null;
		int i = 0;
		if ( clienteUpdate != null ) {
			//Iterator		
			Iterator<Cliente> it = clientes.iterator();
			while( it.hasNext() ) {
				clienteIteracion = it.next();
				if ( clienteIteracion.getId() == clienteUpdate.getId() ) {
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
		
		//buscar cliente a eliminar
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