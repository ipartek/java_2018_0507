package accesoDatos;

import java.util.ArrayList;
import java.util.List;
import modelo.Perro;
import java.util.TreeMap;

public class PerroTreeMapDAO implements CrudAble<Perro>{
	
	private static final PerroTreeMapDAO dao = new PerroTreeMapDAO();
	
	private PerroTreeMapDAO() {
		
	}
	
	public static PerroTreeMapDAO getInstance() {return dao;}
	
	static {
		/*
		for(long i = 1; i <=10; i++) {
			dao.insert(new Perro(0,));
		}*/
		
		dao.insert(new Perro(0,"Blacky",3,"Labrador",20.2,true,"11-111-2015","40°28′25″N","03°34′40″W"));
		dao.insert(new Perro(1,"Roy",15,"Chihuahua",3.2,true,"22-222-2003","40°28′25″N","03°34′40″W"));
		dao.insert(new Perro(2,"Chop",11,"Milrazas",5.6,true,"11-111-2007","40°28′25″N","03°34′40″W"));
		dao.insert(new Perro(3,"Rex",6,"Milrazas",2.0,true,"11-111-2012","40°28′25″N","03°34′40″W"));
		dao.insert(new Perro(4,"Ares",8,"Milrazas",3.6,true,"11-111-2010","40°28′25″N","03°34′40″W"));
		dao.insert(new Perro(5,"Jacob",8,"Pitbull",35.2,true,"11-111-2010","40°28′25″N","03°34′40″W"));
		
	}
	
	private TreeMap<Long, Perro> perros = new TreeMap<>();
	private Long idUltimo = 0L;

	@Override
	public List<Perro> getAll() {
		return new ArrayList<Perro>(perros.values());
	}

	@Override
	public Perro getById(long id) {
		return perros.get(id);
	}
	
	public Perro getByNombre(String nombre) {
		return perros.get(nombre);
	}

	@Override
	public void insert(Perro perro) {
		Long id = ++idUltimo;
		perro.setId(id);
		perros.put(perro.getId(), perro);
		
	}

	@Override
	public void update(Perro perro) {
		if(!perros.containsKey(perro.getId())) {
			throw new AccesoDatos("Id no existente");
		}
		perros.put(perro.getId(), perro);
		
	}

	@Override
	public void delete(long id) {
		if(!perros.containsKey(id)) {
			throw new AccesoDatos("Id no existente");
		}
		perros.remove(id);
	}

}
