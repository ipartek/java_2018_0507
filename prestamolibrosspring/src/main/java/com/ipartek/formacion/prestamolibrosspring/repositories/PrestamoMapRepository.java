package com.ipartek.formacion.prestamolibrosspring.repositories;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.prestamolibrosspring.model.Prestamo;

@Repository
public class PrestamoMapRepository implements CrudAble<Prestamo>{
	private TreeMap<Long, Prestamo> prestamos = new TreeMap<>(); 
	
	public PrestamoMapRepository() {
		prestamos.put(2L, new Prestamo(1,"Titulo1", "usuariotest1",
				new Date(2017-1900,
						11,
						22)
				,new Date(LocalDateTime.now().getYear()-1900,
						LocalDateTime.now().getMonthValue()-1,
						LocalDateTime.now().getDayOfMonth())
				));
		prestamos.put(2L, new Prestamo(2,"Titulo2", "usuariotest2",
				new Date(2017-1900,
						12,
						01)
				,new Date(LocalDateTime.now().getYear()-1900,
						LocalDateTime.now().getMonthValue()-1,
						LocalDateTime.now().getDayOfMonth())
				));
			
	}
	
	
	@Override
	public List<Prestamo> getAll() {
		return new ArrayList<Prestamo>(prestamos.values());
	}

	@Override
	public Prestamo getById(Long id) {
		return prestamos.get(id);
	}

	@Override
	public Long insert(Prestamo p) {
	
		Long idAnterior;
		
		if(prestamos.size() == 0)
			idAnterior = 0L;
		else
			idAnterior = prestamos.lastKey(); 
		
		p.setId((int) (idAnterior + 1));
		
		prestamos.put((long) p.getId(), p);
		
		return (long) p.getId();
	}

	@Override
	public void update(Prestamo p) {
		prestamos.put((long) p.getId(), p); //Si ya existe el id sustituye el objeto en lugar de crear uno nuevo
	}

	@Override
	public void delete(Long id) {
		prestamos.remove(id);
	}

}
