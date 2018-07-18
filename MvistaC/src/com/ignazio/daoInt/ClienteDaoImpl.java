package com.ignazio.daoInt;

import java.util.ArrayList;
import java.util.List;

import com.ignazio.modelo.Cliente;

public class ClienteDaoImpl implements InterDao {
	ArrayList <Cliente> clientes=new ArrayList<>();
	public  ClienteDaoImpl() {
		Cliente c1=new Cliente(1,"iñaki","alvira");
		Cliente c2=new Cliente(2,"iñzaki","alviasasra");
		clientes.add(c1);
		clientes.add(c2);
	}
	@Override
	public List<Cliente> obtenerClientes() {
		// TODO Auto-generated method stub
		return clientes;
	}

	@Override
	public Cliente obtenerCliente(int id) {
		// TODO Auto-generated method stub
		for(int i=0;i<clientes.size();i++)
			if(clientes.get(i).getId()==id) {
				System.out.println("somos el mismo");
				return clientes.get(i);
			}
		return null;
//		for(Cliente c:clientes)
//			if(c.)
		
	}

	@Override
	public void actualizarCliente(Cliente cliente) {
		// TODO Auto-generated method stub

		for(int i=0;i<clientes.size();i++)
			if(clientes.get(i).getId()==cliente.getId())			{
				clientes.get(i).setApellido(cliente.getApellido());
				clientes.get(i).setNombre(cliente.getNombre());;
			}
				
				
			
		
	}

	@Override
	public void eliminarCliente(Cliente cliente) {
		// TODO Auto-generated method stub

		for(int i=0;i<clientes.size();i++)		
		{
			if (clientes.get(i).equals(cliente))
			{
				clientes.remove(cliente);
			}
		}
		
	}

}
