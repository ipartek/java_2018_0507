package com.ipartek.formacion.ong.accesoadatos;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.ipartek.formacion.ong.modelos.Perro;

public class PerroTreeMapDAO implements CrudAble<Perro> {

	// PRINCIPIO SINGLETON
	private static final PerroTreeMapDAO dao = new PerroTreeMapDAO();

	private PerroTreeMapDAO() {
	}

	public static PerroTreeMapDAO getInstance() {
		return dao;
	}
	// FIN SINGLETON

	// CONSTRUCTOR ESTÁTICO
	static {
		dao.insert(new Perro(0L, "Blas", "Husky", 4, 30F, "apadrinado", "25-4177-2016", "3.587", "9.478"));
		dao.insert(new Perro(0L, "Blas", "Husky", 4, 30F, "apadrinado", "25-4177-2016", "3.587", "9.478"));
		dao.insert(new Perro(0L, "Blas", "Husky", 4, 30F, "apadrinado", "25-4177-2016", "3.587", "9.478"));
		dao.insert(new Perro(0L, "Blas", "Husky", 4, 30F, "apadrinado", "25-4177-2016", "3.587", "9.478"));
		dao.insert(new Perro(0L, "Blas", "Husky", 4, 30F, "apadrinado", "25-4177-2016", "3.587", "9.478"));
		dao.insert(new Perro(0L, "Blas", "Husky", 4, 30F, "apadrinado", "25-4177-2016", "3.587", "9.478"));
		dao.insert(new Perro(0L, "Blas", "Husky", 4, 30F, "apadrinado", "25-4177-2016", "3.587", "9.478"));
		dao.insert(new Perro(0L, "Blas", "Husky", 4, 30F, "apadrinado", "25-4177-2016", "3.587", "9.478"));
	}
	// FIN

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

	@Override
	public void insert(Perro perro) {
		// ID AUTONUMERICO
		Long id = ++idUltimo;
		perro.setId(id);

		perros.put(perro.getId(), perro);
	}

	@Override
	public void update(Perro perro) {
		if (!perros.containsKey(perro.getId())) {
			throw new AccesoDatos("Id no existente");
		}
		perros.put(perro.getId(), perro);

	}

	@Override
	public void delete(long id) {
		if (!perros.containsKey(id)) {
			throw new AccesoDatos("Id no existente");
		}
		perros.remove(id);

	}

}
