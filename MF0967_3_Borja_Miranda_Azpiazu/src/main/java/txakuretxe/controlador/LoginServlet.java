package txakuretxe.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import txakuretxe.modelo.*;
import txakuretxe.controlador.*;
import txakuretxe.pojo.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuarioMySqlDAO dao;

 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
System.out.println("entra en el login");
		
String nombre=request.getParameter("nombre");
String password=request.getParameter("password");
String email=request.getParameter("email");

	HttpSession sesion=request.getSession();
	if(validarUsuario(nombre, password)) {
		System.out.println("suuu");
		Usuario u=new Usuario(nombre,password,email);
		sesion.setAttribute("user", u);
		response.sendRedirect("Principal");
	}
	else {
		
		response.sendRedirect("login.jsp");
	}
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	public boolean validarUsuario(String nombre,String password) {
		boolean validado=false;
		
		try {
			dao=UsuarioMySqlDAO.getInstance();
			ArrayList<Usuario> usuarios = (ArrayList<Usuario>) dao.getAll();
			
			for (int i = 0; i < usuarios.size(); i++) {
				System.out.println(usuarios.get(i).getNombre());
				if(usuarios.get(i).getNombre().equalsIgnoreCase(nombre)&&
						usuarios.get(i).getPassword().equalsIgnoreCase(password)) {
					validado=true;
				}
			}
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return validado;
		}
		
	return validado;	
	}
	
	
}
