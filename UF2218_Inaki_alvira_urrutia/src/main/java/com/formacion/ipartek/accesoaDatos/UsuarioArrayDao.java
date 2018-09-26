package com.formacion.ipartek.accesoaDatos;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.formacion.ipartek.pojo.Usuario;

public class UsuarioArrayDao implements CrudAble<Usuario> {
	TreeMap<Long, Usuario> usuarios=new TreeMap<Long,Usuario>();
	private static UsuarioArrayDao INSTANCE;
	private UsuarioArrayDao() {
		
	}
	public static synchronized UsuarioArrayDao getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new UsuarioArrayDao();
		}

		return INSTANCE;
	}
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return new ArrayList<Usuario>(usuarios.values());
	}

	public Usuario getById(long id) {
		// TODO Auto-generated method stub
		return usuarios.get(id);
		}

	public boolean insert(Usuario pojo) {
		if(usuarios.containsKey(pojo.getId()))
			return false;
		usuarios.put(pojo.getId(),pojo);
		return true;
	}

	public boolean update(long id,Usuario pojo) {	
		usuarios.put(pojo.getId(),pojo);
		return true;
	}

	public boolean delete(long id) {	
		if(!usuarios.containsKey(id))
			return false;
			usuarios.remove(id);
			return true;
			}
	public boolean update(Usuario pojo) {
		// TODO Auto-generated method stub
		return false;
	}
	

}