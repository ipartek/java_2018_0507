package com.ignazio.controlador;

import com.ignazio.modelo.Cliente;
import com.ignazio.vista.ClienteVista;

public class ClienteController {

	private Cliente clienteModelo; 
	private ClienteVista vista;
	public ClienteController(Cliente cliente, ClienteVista vista) {
		super();
		this.clienteModelo = cliente;
		this.vista = vista;
	}
	
	public int getId() {
		return this.clienteModelo.getId();
	}
	public void setId(int id) {
		this.clienteModelo.setId(id);
	}
	public String getNombre() {
		return clienteModelo.getNombre();
		}
	public void setNombre(String nombre) {
		this.clienteModelo.setNombre(nombre);
	}
	public String getApellido() {
		return clienteModelo.getApellido();
	}
	public void setApellido(String apellido) {
		this.clienteModelo.setApellido(apellido);
	}
	public void actualizarDatos() {
		vista.imprimirDatosCliente(clienteModelo.getId(), clienteModelo.getNombre(), clienteModelo.getApellido());
	}
}
