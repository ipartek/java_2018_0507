package accesodatos;

import java.util.List;

public interface CrudAble<P> {
	//Retrieve
	
	List<P> getAll();
	
	P getById(long id);
	
	//Create
	boolean insert(P pojo);
	//Update
	boolean update(P pojo);
	//Delete
	boolean delete(long id);
}
