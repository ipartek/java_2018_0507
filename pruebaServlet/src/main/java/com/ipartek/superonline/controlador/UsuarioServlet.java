package com.ipartek.superonline.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		HttpSession session = request.getSession();  //recoge la session
		
		String salir;
		
		salir=request.getParameter("salir");//name
		
		if(salir.equalsIgnoreCase("salir")) {
		session.invalidate();
		}
		
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();  //recoge la session
		
		Usuario user = (Usuario) session.getAttribute("usuario"); //consigues un obj usuario que este en la sesion
		
		if (user != null) {  //si existe el usuario nos olvidamos del coigo a continuacion xq significa que ya ha hecho login
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
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
			 
			 
			 if(formulario.equalsIgnoreCase("login")) { //si el value es login
					if(usuarios.isEmpty()) {
					
						error.setError("No existen usuarios");					
						request.setAttribute("error", error);
						request.getRequestDispatcher("registro.jsp").forward(request, response);//para ir a una pagina pasandole los atributos en la request
					}
					else {
						boolean encontrado = false;
						
						for(int i=0;i<usuarios.size();i++) {
							if(usuarios.get(i).getNombre().equalsIgnoreCase(usuario) 
							&& usuarios.get(i).getContrasena().equalsIgnoreCase(password)) {
							
								encontrado=true;
								
								session.setAttribute("usuario", usuarios.get(i)); //se mete al usuario en la sesion
								
								request.getRequestDispatcher("index.jsp").forward(request, response);
								
							}
									
						}
						
						if(!encontrado) {
							
							error.setError("No existen usuarios");					
							request.setAttribute("error", error);
							request.getRequestDispatcher("Login.jsp").forward(request, response);//para ir a una pagina pasandole los atributos en la request
						}
						
						
					}
			
			
			
			}
				System.out.println(usuarios.size()+"tamaño");
		}
		}
		


}
