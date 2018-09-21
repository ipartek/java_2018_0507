package com.ipartek.superonline.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.superonline.pojo.Error;
import com.ipartek.superonline.modelo.UsuarioDAO;
import com.ipartek.superonline.pojo.Usuario;

/**
 * Servlet implementation class UsuarioServlet
 */
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	Usuario user;
	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	Error error=new Error("");
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		String usuario, password, formulario;
		
		usuario = request.getParameter("mail");
		password = request.getParameter("password");
		formulario = request.getParameter("login");
		formulario = "algo";
		
		//System.out.println(usuario + password + formulario);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		usuarios=(ArrayList<Usuario>) UsuarioDAO.getInstance().getAll();
		
		//System.out.println(usuarios.size()+"tamaño");
		
		PrintWriter out=response.getWriter();
		
		String usuario,password,formulario;
		
		 formulario=request.getParameter("login");//name
		 usuario=request.getParameter("mail");
		 password=request.getParameter("password");
		 
		 if(formulario.equalsIgnoreCase("registro")) {			 
			// System.out.println(usuario+password);
			 UsuarioDAO.getInstance().insert(new Usuario(usuario, password));
			 response.sendRedirect("Login.jsp");
			 
		 }
			if(formulario.equalsIgnoreCase("login")) //si el value es login
			{
				if(usuarios.isEmpty()) {
				
					error.setError("No existen usuarios");					
					request.setAttribute("error", error);
					request.getRequestDispatcher("Login.jsp").forward(request, response);//para ir a una pagina pasandole los atributos en la request
				}
				else {
					for(int i=0;i<usuarios.size();i++) {
						if(usuarios.get(i).getNombre().equalsIgnoreCase(usuario) 
						&& usuarios.get(i).getContrasena().equalsIgnoreCase(password)) {
							
							//usuarios.get(i).setError("");
							request.setAttribute("error", error);
							request.getRequestDispatcher("listado.html").forward(request, response);
							break;
						}
						else {
							//user=new Usuario();
							error.setError("usuario o contraseña incorrectos");
							if(i+1==usuarios.size()) {
								request.setAttribute("error", error);
							request.getRequestDispatcher("login.jsp").forward(request, response);
							}
						}			
					}
				}
			// System.out.println(usuario+password+formulario);
		
		}
			System.out.println(usuarios.size()+"tamaño");
	}

}
