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

import com.ipartek.supermercado.accesoadatos.UsuarioArrayDao;
import com.ipartek.supermercado.pojo.Usuario;





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
		/*String nombre,contrasena,apellido,telefono;
		 nombre=request.getParameter("nombre");
		 contrasena=request.getParameter("contrasena");
		 apellido=request.getParameter("apellido");
		 telefono=request.getParameter("telefono");*/
		// System.out.println(nombre+apellido+telefono+contrasena);

		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		usuarios=(ArrayList<Usuario>) UsuarioArrayDao.getInstance().getAll();
		 UsuarioArrayDao.getInstance().insert(new Usuario("borja", "miranda","3412432","contrasena"));
	
		String nombre,contrasena,apellido,telefono,formulario;
		 nombre=request.getParameter("nombre");
		 contrasena=request.getParameter("contrasena");
		 apellido=request.getParameter("apellido");
		 telefono=request.getParameter("telefono");
		 formulario=request.getParameter("login");
		 //System.out.println(nombre+apellido+telefono+contrasena);

		 
		 if(formulario.equalsIgnoreCase("login")) {
	System.out.println(usuarios.get(0).getNombre());
	System.out.println("entras desde el login");
	
		 if((nombre.equalsIgnoreCase("borja"))&&(contrasena.equalsIgnoreCase("contrasena"))) {
			 response.sendRedirect("index.jsp");
			 
			 System.out.println("asdasdas");
			 
		 }	else {
			 	response.sendRedirect("registrou.jsp");
			}
	
	}
	

		 
if(formulario.equalsIgnoreCase("registro")) {
	
	System.out.println("entras desde el registro");
}
 
		/* UsuarioArrayDao.getInstance().insert(new Usuario(nombre,apellido,telefono,contrasena));
		System.out.println(usuarios.get(0).getNombre());
		System.out.println(usuarios.get(0).getContrasena());
		
		
		
		
		
			for(int i=0;i<usuarios.size();i++) {
		 if((usuarios.get(i).getNombre().equalsIgnoreCase("borja"))&&(usuarios.get(i).getContrasena().equalsIgnoreCase("contrasena"))) {
			 response.sendRedirect("registrou.jsp");
			 
			 System.out.println("asdasdas");
			 
		 }	else {
			request.getRequestDispatcher("login.jsp").forward(request, response);

			}
			}
		 */

	}
	}
