package com.ipartek.pabloDAO.paginaExamen.accesodatos;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.ipartek.pabloDAO.paginaExamen.modelos.Perro;

public class PerroMapDAO implements CrudAble<Perro>{

	//crea una instancia llamada dao con final de usuarioMapDAO
	private static final PerroMapDAO dao = new PerroMapDAO();
	
	private PerroMapDAO() {}
	//Crea el getInstance y le retorna los datos del objeho dao
	public static PerroMapDAO getInstance() { return dao; }
	
	//Se crean los usuarios y se insertan en el dao
	static {
		
		for (long i=1;i<=1;i++) {
			dao.insert(new Perro(i, "Scooby-Doo", 8, "Pastor", 30 , false,"Latitud:" + i + "/" +"Longitud:" + i));
			//dao.insert(new Usuario(0, "email" + i + "@email.com", "contra" + i));
		}
	}
	//se crea el treemap perros
	private TreeMap<Long, Perro> perros = new TreeMap<Long, Perro>();
	

	
	public List<Perro> getAll() {
		return new ArrayList<Perro>(perros.values());
	}

	public Perro getById(long id) {
		return perros.get(id);
	}

	
	private Long idUltimo = 0L;
	public void insert(Perro perro) {
		Long id = ++idUltimo;
		perro.setId(id);
		perros.put(perro.getId(),perro);
			
	}

	public void update(Perro perro) {
		if(!perros.containsKey(perro.getId())) {
			throw new AccesoDatos("La Id no existe");
		}
		perros.put(perro.getId(),perro);
				
	}

	public void delete(long id) {
		if(!perros.containsKey(id)) {
			throw new AccesoDatos("Id no existente");
		}
		perros.remove(id);
		
	}
	
	

}
