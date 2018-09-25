package com.ipartek.superonline.modelo;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.superonline.modelo.ProductoDAO;
import com.ipartek.superonline.modelo.CrudAble;
import com.ipartek.superonline.pojo.Producto;

public class ProductoDAO implements CrudAble<Producto>{
	List <Producto> productos=new ArrayList<Producto>();
	private static ProductoDAO INSTANCE;
	private ProductoDAO() {
		
	}
	public static synchronized ProductoDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new ProductoDAO();
		}

		return INSTANCE;
	}
	public List<Producto> getAll() {
		// TODO Auto-generated method stub
		return productos;
	}

	public Producto getById(long id) {
		// TODO Auto-generated method stub
		Producto prod=null;
		for(Producto p:productos)
			if(p.getId()==id)
			{
				return p;
				
			}
		return prod;
		}

	public boolean insert(Producto pojo) {
		// TODO Auto-generated method stub
		if(pojo!=null)
			productos.add(pojo);
		return false;
	}

	public boolean update(Producto pojo) {
		// TODO Auto-generated method stub
		/**if(pojo!=null)
			for(int i=0;i<productos.size();i++) {
				if(productos.get(i).equals(pojo.getId()))
					productos.set(i, pojo);
			}**/
		
		if(pojo!=null) {
			for(int i =0; i<productos.size();i++) {
				if(productos.get(i).getId()==pojo.getId()){
					productos.get(i).setNombre(pojo.getNombre());
					productos.get(i).setPrecio(pojo.getPrecio());
					return true;
				}
			}
		}
		
		
		
		return false;
	}

	public boolean delete(long id) {
		// TODO Auto-generated method stub
		
			for(int i=0;i<productos.size();i++) {
				if(productos.get(i).getId()==id)
					productos.remove(i);
					}
				return false;
			}
	
	
	
	
	
}
