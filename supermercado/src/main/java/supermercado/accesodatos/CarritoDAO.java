package supermercado.accesodatos;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class CarritoDAO implements CrudAble<Carrito> {

	private List<Carrito> carrito = new ArrayList<>();

	private static CarritoDAO INSTANCE;

	public CarritoDAO() {
	}

	public static synchronized CarritoDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new CarritoDAO();
		}

		return INSTANCE;
	}

	@Override
	public List<Carrito> getAll() {
		return carrito;
	}

	public boolean insert(Carrito carrito) {
		
		System.out.println("En carrito dao"+carrito.getId());
		//System.out.println("En carrito dao"+carrito.getNombre());
		//System.out.println("En carrito dao"+carrito.getPrecio());
		boolean resul = false;

		if (carrito != null) {
			resul = ((List<Carrito>) carrito).add(carrito);
			System.out.println("Producto anadidoal carrito");
		}
		return resul;
	}

	@SuppressWarnings("static-access")
	@Override
	public boolean update(Carrito carritos) {
		boolean resul = false;
		Carrito videoIteracion = null;
		int i = 0;
		if ( carrito != null ) {
			//Iterator		
			Iterator<Carrito> it = ((List<Carrito>) carritos).iterator();
			while( it.hasNext() ) {
				videoIteracion = it.next();
				if ( videoIteracion.getId() == Carrito.getId() ) {
					carritos.set(i, carrito);
					resul = true;
					break;					
				}	
				i++;
			}		
		}	
		return resul;
	}

	

	@Override
	public Carrito getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}

