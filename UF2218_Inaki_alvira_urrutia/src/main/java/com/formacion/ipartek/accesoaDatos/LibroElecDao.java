package com.formacion.ipartek.accesoaDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.formacion.ipartek.pojo.HojaLibro;



public class LibroElecDao implements CrudAble<HojaLibro> {
	TreeMap <Long,HojaLibro> hojas=new TreeMap<Long,HojaLibro>();
	private static LibroElecDao INSTANCE;
	private LibroElecDao() {
		
	}
	public static synchronized LibroElecDao getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new LibroElecDao();
		}

		return INSTANCE;
	}
	public List<HojaLibro> getAll() {
		// TODO Auto-generated method stub
		return new ArrayList<HojaLibro>(hojas.values());
	}

	public HojaLibro getById(long id) {
		// TODO Auto-generated method stub
		return hojas.get(id);
		}

	public boolean insert(HojaLibro pojo) {
		if(hojas.containsKey(pojo.getId()))
			return false;
		hojas.put(pojo.getId(),pojo);
		return true;
	}

	public boolean update(long id,HojaLibro pojo) {	
		hojas.put(pojo.getId(),pojo);
		return true;
	}

	public boolean delete(long id) {	
		if(!hojas.containsKey(id))
			return false;
			hojas.remove(id);
			return true;
			}
	public boolean update(HojaLibro pojo) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
