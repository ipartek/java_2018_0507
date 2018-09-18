package com.ipartek.supermercado.controladores;

import java.awt.SecondaryLoop;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.supermercado.accesoadatos.ArticuloArrayDao;
import com.ipartek.supermercado.accesoadatos.UsuarioArrayDao;
import com.ipartek.supermercado.pojo.Usuario;

/**
 * Servlet implementation class UsuarioServlet
 */
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Usuario user;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String usuario,password,formulario;
		 usuario=request.getParameter("mail");
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
		user=new Usuario();
		PrintWriter out=response.getWriter();
		String usuario,password,formulario;
		 formulario=request.getParameter("login");
		 usuario=request.getParameter("mail");
		 password=request.getParameter("password");
		 if(formulario.equalsIgnoreCase("registro")) {			 
			 System.out.println(usuario+password);
			 UsuarioArrayDao.getInstance().insert(new Usuario(usuario, password));
			 for(int i=0;i<UsuarioArrayDao.getInstance().getAll().size();i++)
				 System.out.println(UsuarioArrayDao.getInstance().getAll().get(i).getNombre());
			 
		 }
		if(formulario.equalsIgnoreCase("login"))
			if(UsuarioArrayDao.getInstance().getAll()==null) {
				System.out.println("array nulo");
			}
			else {
				for(int i=0;i<UsuarioArrayDao.getInstance().getAll().size();i++) {
					if(UsuarioArrayDao.getInstance().getAll().get(i).getNombre().equalsIgnoreCase(usuario) 
					&& UsuarioArrayDao.getInstance().getAll().get(i).getPassword().equalsIgnoreCase(password)) {
						System.out.println("exixto");
						response.sendRedirect("listado.html");
						user.setError("");
						break;
					}
					else {
						System.out.println("no exixte");
						user.setError("no exixte tu usuario moñas");
					
					}			
				}
			}
		// System.out.println(usuario+password+formulario);
	
	}

}
