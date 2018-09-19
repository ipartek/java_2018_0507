package controladores;
import modelos.*;
import pojo.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class ServletUsuario
 */
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Usuario user;
	ArrayList<Usuario> usuarios=new ArrayList<>();
    
    public ServletUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String nombre,contrasena,apellido,telefono;
		 nombre=request.getParameter("nombre");
		 contrasena=request.getParameter("contrasena");
		 apellido=request.getParameter("apellido");
		 telefono=request.getParameter("telefono");
		// System.out.println(nombre+apellido+telefono+contrasena);
		 UsuarioArrayDao.getInstance().insert(new Usuario(nombre,contrasena,apellido,telefono));
		System.out.println(usuarios.get(0).getApellido());
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String nombre,contrasena,apellido,telefono;
		 nombre=request.getParameter("nombre");
		 contrasena=request.getParameter("contrasena");
		 apellido=request.getParameter("apellido");
		 telefono=request.getParameter("telefono");
		 //System.out.println(nombre+apellido+telefono+contrasena);
		 UsuarioArrayDao.getInstance().insert(new Usuario(nombre,contrasena,apellido,telefono));
		
			for(int i=0;i<usuarios.size();i++) {
				System.out.println(usuarios.get(i).getApellido());
			}
	}

}
