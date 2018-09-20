package supermercado.accesodatos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import supermercado.pojo.Articulo;


public class ArticuloArrayDAO implements CrudAble<Articulo> {

	public List<Articulo> articulos = new ArrayList<Articulo>();

	public static ArticuloArrayDAO INSTANCE;

	public ArticuloArrayDAO() {
	}

	public static synchronized ArticuloArrayDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new ArticuloArrayDAO();
		}

		return INSTANCE;
	}


	public List<Articulo> getAll() {
		return articulos;
	}

	public Articulo getById(String id) {
		Articulo resul = null;
		//foreach
		for (Articulo articuloIteracion : articulos) {
			if ( id == articuloIteracion.getId() ) {
				resul = articuloIteracion;
				break;
			}
		}
		return resul;
	}

	public boolean insert(Articulo articulo) {
		
		//System.out.println(articulo.getNombre());
		boolean resul = false;

		if (articulo != null) {
			resul = articulos.add(articulo);
			//System.out.println("articuloAnadido");
		}
		return resul;
	}

	public boolean update(Articulo articuloUpdate) {
		boolean resul = false;
		Articulo articulosIteracion = null;
		int i = 0;
		if ( articulos != null ) {
			//Iterator		
			Iterator<Articulo> it = articulos.iterator();
			while( it.hasNext() ) {
				articulosIteracion = it.next();
				if ( articulosIteracion.getId() == articuloUpdate.getId() ) {
					articulos.set(i, articuloUpdate);
					resul = true;
					break;					
				}	
				i++;
			}		
		}	
		return resul;
	}

	public boolean delete(String id) {
		boolean resul = false;
		
		Articulo aIteracion = null;
		
		//buscar articulo a eliminar
		for (int i = 0; i < articulos.size(); i++) {
			
			aIteracion = articulos.get(i);   //articulo sobre el que iteramos
			Articulo art=new Articulo();
			if ( id == art.getId() ) {    // articulo encontrado
				resul = articulos.remove(aIteracion);
				break;
			}
		}
		
		return resul;
	}

	@Override
	public Articulo getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}
}
