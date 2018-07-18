package com.ignazio.daoInt;

import java.util.List;

import com.ignazio.modelo.Cliente;


public interface InterDao {
	public List<Cliente> obtenerClientes();
	public Cliente obtenerCliente(int id);
	public void actualizarCliente(Cliente cliente);
	public void eliminarCliente(Cliente cliente);

}
