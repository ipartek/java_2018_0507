package com.ipartek.formacion.examen.crud.accesodatos;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.ipartek.formacion.examen.crud.modelos.Perros;

public class PerrosTreeMapDAO implements CrudAble<Perros> {

	//Creación de patrón "Singleton"
	private static final PerrosTreeMapDAO dao = new PerrosTreeMapDAO();
	private PerrosTreeMapDAO() {}
	public static PerrosTreeMapDAO getInstance() {
		return dao;
	}
	//Datos para select método static
	static {
		for (long i = 1; i <= 2; i++) {
			dao.insert(new Perros(i, "Puppy" + i, (int) (i), "Mestizo", 1 + (int) (i), true, "45876214" + (int) (i),
					784485588, 14578125));
		}
	}
	//Creación del TreeMap y métodos CrudAble
	private TreeMap<Long, Perros> perrosmap = new TreeMap<>();
	private Long idUltimo = 0L;

	@Override
	public List<Perros> getAll() {
		return new ArrayList<Perros>(perrosmap.values());
	}

	@Override
	public Perros getById(long id) {
		return perrosmap.get(id);
	}

	@Override
	public void insert(Perros perrosmap) {
		Long id = ++idUltimo;
		perrosmap.setId(id);
		this.perrosmap.put(perrosmap.getId(), perrosmap);
	}

}
