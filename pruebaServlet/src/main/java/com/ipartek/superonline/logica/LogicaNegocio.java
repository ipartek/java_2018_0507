package com.ipartek.superonline.logica;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.superonline.pojo.Producto;
import com.ipartek.superonline.pojo.Usuario;
import com.ipartek.superonline.modelo.ProductoDAO;
import com.ipartek.superonline.modelo.UsuarioDAO;

public class LogicaNegocio {

	public static boolean validarUsuario(Usuario usuario) {

		// Llamar DAO
		// Consultar por email
		// Comparar Password
		
		//Se comprueba que el campo correo no este vacio 
		if (usuario.getNombre() != null || usuario.getNombre().trim().length() != 0) {
				//Se comprueba que sea un email correctamente formado es decir llll@lll.lll
			if (usuario.getNombre().matches("^\\w+@\\w+\\.\\w+$")) {
				//Se mira que la contraseña no este vacia
				if (usuario.getContrasena() != null) {
					return true;
				}else {
					//Metemos el error en el objeto usuario 
					usuario.setError("No puede estar vacia la contraseña");
					//Se sale del metodo diciendo que el usuario no es valido
					return false;
				}

			}else {
				//Metemos el error en el objeto usuario 
				usuario.setError("Inserte un correo valido");
				//Se sale del metodo diciendo que el usuario no es valido
				return false;
			}
		}else {
			//Metemos el error en el objeto usuario 
			usuario.setError("El campo no puede estar vacio");
			//Se sale del metodo diciendo que el usuario no es valido
			return false;
		}
		
	
	}

	public static Boolean buscarUsuario(Usuario usuario) {
		//Obtenemos la instancia del dao de usuarios 
		UsuarioDAO userdao = UsuarioDAO.getInstance();
		//Despues una vez que tenemos la instacia podemos acceder a sus metodos , llamamos al metodo que nos devuelve la lista de usuarios
		List<Usuario> usuarios = userdao.getAll();
		//Busca al usuario dentro de la lista de usuarios que habiamos cargado
		for (int i = 0; i < usuarios.size(); i++) {
//Si el email del usuario coincide con el email del usuario alamacenado en el dao y lo mismo con la contraseña se considera que hemos encotnrado al usuario 
			//Es decir que email sea igual y el pass tambien
			if (usuario.getNombre().equals(usuarios.get(i).getNombre())
					&& usuario.getContrasena().equals(usuarios.get(i).getContrasena())) {
			//Se sale del metodo devolviendo true es decir que es valido el usuario
				return true;
			}

		}
		return false;
	}
	
	public static List<Producto> obtenerProductos() {

		ProductoDAO proddao = ProductoDAO.getInstance();
		List<Producto> productos = proddao.getAll();
		return productos;
	}

	public static Producto obtenerProductoPorId(long id) {

		ProductoDAO proddaoid = ProductoDAO.getInstance();
		Producto producto = proddaoid.getById(id);
		return producto;

	}

	public static void agregarProducto(Producto producto) {

		ProductoDAO proddao = ProductoDAO.getInstance();
		proddao.insert(producto);

	}

	public static void modificarProducto(Producto producto) {
		ProductoDAO proddao = ProductoDAO.getInstance();
		proddao.update(producto);

	}

	public static void borrarProducto(long id) {
		ProductoDAO proddao = ProductoDAO.getInstance();
		proddao.delete(id);
	}

}
