package com.ipartek.formacion.ejemplos.crud.accesodatos;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.ipartek.formacion.ejemplos.crud.modelos.Usuario;

public class UsuarioTreeMapDAO implements CrudAble<Usuario> {

	//PRINCIPIO SINGLETON
	private static final UsuarioTreeMapDAO dao = new UsuarioTreeMapDAO();
	
	private UsuarioTreeMapDAO() {}
	
	public static UsuarioTreeMapDAO getInstance() { return dao; }
	//FIN SINGLETON
	
	//CONSTRUCTOR ESTÁTICO
	static {
		//CREAR UN CONJUNTO DE USUARIOS DE PRUEBA QUE SERÁN
		//1, email1@email.com, contra1
		//2, email2@email.com, contra2
		//...
		//10, email10@email.com, contra10
		for(long i = 1; i <= 10; i++) {
<<<<<<< HEAD
			dao.insert(new Usuario(0, "email" + i + "@email.com", "contra" + i));
		}
	}
	//FIN
	
	private TreeMap<Long, Usuario> usuarios = new TreeMap<>();
	
	private Long idUltimo = 0L;
	
	@Override
	public List<Usuario> getAll() {
		return new ArrayList<Usuario>(usuarios.values());
	}

	@Override
	public Usuario getById(long id) {
		return usuarios.get(id);
	}

	@Override
	public void insert(Usuario usuario) {
		//ID AUTONUMERICO
		Long id = ++idUltimo;
		usuario.setId(id);
=======
			dao.insert(new Usuario(i, "email" + i + "@email.com", "contra" + i));
		}
	}
	//FIN
	
	private TreeMap<Long, Usuario> usuarios = new TreeMap<>();
	
	@Override
	public List<Usuario> getAll() {
		return new ArrayList<Usuario>(usuarios.values());
	}

	@Override
	public Usuario getById(long id) {
		return usuarios.get(id);
	}

	@Override
	public void insert(Usuario usuario) {
		if(usuarios.containsKey(usuario.getId())) {
			throw new AccesoDatos("Clave duplicada");
		}
>>>>>>> branch 'cristina' of https://github.com/ipartek/java_2018_0507
		usuarios.put(usuario.getId(), usuario);
	}

	@Override
	public void update(Usuario usuario) {
		if(!usuarios.containsKey(usuario.getId())) {
			throw new AccesoDatos("Id no existente");
		}
		usuarios.put(usuario.getId(), usuario);
	}

	@Override
	public void delete(long id) {
		if(!usuarios.containsKey(id)) {
			throw new AccesoDatos("Id no existente");
		}
		usuarios.remove(id);
	}

}
