package com.ipartek.supermercado.controladores;

import java.awt.SecondaryLoop;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.supermercado.accesoadatos.ArticuloArrayDao;
import com.ipartek.supermercado.accesoadatos.UsuarioArrayDao;
import com.ipartek.supermercado.pojo.Carrito;
import com.ipartek.supermercado.pojo.Errores;
import com.ipartek.supermercado.pojo.Usuario;

/**
 * Servlet implementation class UsuarioServlet
 */
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Usuario user;
	ArrayList<Usuario> usuarios=new ArrayList<>();
	Errores error=new Errores("");
	Carrito carro;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String usuario,password,formulario,nombreBueno;
		 usuario=request.getParameter("mail");
		 nombreBueno=request.getParameter("nombre");
		 password=request.getParameter("password");
		 formulario=request.getParameter("login");
		 formulario="algo";
		 System.out.println(usuario+password+formulario);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		usuarios=(ArrayList<Usuario>) UsuarioArrayDao.getInstance().getAll();
		System.out.println(usuarios.size()+"tamaño");
		PrintWriter out=response.getWriter();
		String usuario,password,formulario,nombreBueno;
		 formulario=request.getParameter("login");
		 usuario=request.getParameter("mail");
		 password=request.getParameter("password");
		 nombreBueno=request.getParameter("nombre");
		 if(formulario.equalsIgnoreCase("registro")) {			 
			 System.out.println(usuario+password);
			 UsuarioArrayDao.getInstance().insert(new Usuario(usuario,nombreBueno, password));
			 request.getRequestDispatcher("regUsuarios.jsp").forward(request, response);
			 
		 }
		 if(formulario.equalsIgnoreCase("fin")) {
			 request.getSession().invalidate();
			// carro=null;
			 response.sendRedirect("login.jsp");
		 }
			if(formulario.equalsIgnoreCase("login"))
			{
				if(usuarios.isEmpty()) {
					error.setError("no Existe usuario");					
					request.setAttribute("error", error);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				else {
					for(int i=0;i<usuarios.size();i++) {
						if(usuarios.get(i).getNombre().equalsIgnoreCase(usuario) 
						&& usuarios.get(i).getPassword().equalsIgnoreCase(password)) {							
							HttpSession session = request.getSession(true);
							carro=new Carrito();
							usuarios.get(i).setError("");
							usuarios.get(i).setLogeado(true);
							session.setAttribute("carro", carro);
							request.setAttribute("error", error);
							session.setAttribute("usuario", usuarios.get(i));
							request.getRequestDispatcher("index.jsp").forward(request, response);
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
