package com.ipartek.txarkur.LogicaNegocio;

import java.util.ArrayList;

import com.ipartek.txakur.accesoAdatos.PerroArrayDao;
import com.ipartek.txakur.accesoAdatos.UsuarioArrayDao;
import com.ipartek.txakur.pojo.Perro;
import com.ipartek.txakur.pojo.Usuario;

public class LogicaNegocio {

	public static Usuario comprobarUsuario(String nombre, String pass) {
		Usuario usu = null;
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) UsuarioArrayDao.getInstance().getAll();
		for (Usuario u : usuarios) {
			if (u.getNombre().equalsIgnoreCase(nombre) && u.getPassword().equalsIgnoreCase(pass))
				return u;
			break;
		}
		return usu;
	}

	public static ArrayList<Perro> perrosPorId(String id){
		ArrayList<Perro> perros=null;
		for(Perro p:PerroArrayDao.getInstance().getAll()) {
			if(String.valueOf(p.getId())==id)
				perros.add(p);
			if(p.getNombre()==id)
				perros.add(p);
		}
		return perros;
	}
	public static ArrayList<Perro> perrosPorNombre(String nombre){
		ArrayList<Perro> perros=null;
		for(Perro p:PerroArrayDao.getInstance().getAll()) {
			if(p.getNombre()==nombre)
				perros.add(p);
		}
		return perros;
	}
}
