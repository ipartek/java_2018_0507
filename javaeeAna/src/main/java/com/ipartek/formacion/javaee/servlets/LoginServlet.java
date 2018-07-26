package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.modelos.LoginForm;
import com.ipartek.formacion.javaee.utilidades.ComprobarDNI;
import com.ipartek.formacion.javaee.utilidades.Usuario;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		pw.println("Si querias hacer un login, tienes que venir por post");
		
		pw.println("Hola a todos: " + new java.util.Date());
		
		String ruta = request.getContextPath();
		
		pw.println(ruta);
			
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			
			
			String ACCION = request.getParameter("ACCION");
			//System.out.println("accion "+ACCION);
			
			if(ACCION.equals("REGISTRO")) {
				System.out.println("Registrarse");
				String nombre = request.getParameter("nombre");
				String password = request.getParameter("password");
				String apellido =request.getParameter("apellido");
				String poblacion =request.getParameter("poblacion");
				String dni=request.getParameter("dni");
				
				if(ComprobarDNI.comprobar(dni)) {
//					System.out.println("DNI CORRECTO");
//					System.out.println("DATOS RECIBIDOS:");
//					System.out.println("Nombre: "+nombre);
//					System.out.println("password: "+password);
//					System.out.println("apellido: "+apellido);
//					System.out.println("poblacion: "+poblacion);
//					System.out.println("dni: "+dni);
					Usuario usu=new Usuario(dni, nombre, password, apellido, poblacion);
					
					usu.setDni(dni);
					usu.setNombre(nombre);
					usu.setPassword(password);
					usu.setApellido(apellido);
					usu.setPoblacion(poblacion);
					
					System.out.println("Nom,nre"+usu.getNombre());
			
					
					
				}else {
					System.out.println("DNI INVALIDO");
				}
			}
		
		if(ACCION!=null && ACCION.equals("LOGIN"))	{
			String nombre = request.getParameter("nombre");
			String password = request.getParameter("password");
				
			if(nombre == null || password == null) {
				throw new RuntimeException("No se han recibido los datos de nombre y/o password");
			}
			
			LoginForm login = new LoginForm(nombre, password);
			
			if(validar(login)) {
				request.getSession().setAttribute("usuario", login);
				response.sendRedirect("principal.jsp");
			} else {
				login.setMensajeError("El usuario o contrasenia no son correctos");
				request.getRequestDispatcher("registro.jsp").forward(request, response);
			}	
			
		}else {
			request.getRequestDispatcher("registro.jsp").forward(request, response);
		}
	}

	private void comprobarDNI(String dni) {
		// TODO Auto-generated method stub
		
	}

	private boolean validar(LoginForm login) {
		
		if( "javierninio".equals(login.getNombre()) && "contra".equals(login.getPassword())){
			return true;
		}else {
			return false;
		}
	}

}
