package com.ipartek.formacion.javaee.libros.controladores;
import com.ipartek.formacion.javaee.libros.modelos.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.libros.modelos.Cabecera;
import com.ipartek.formacion.javaee.libros.modelos.Libro;
import com.ipartek.formacion.javaee.libros.modelos.LoginForm;
import com.ipartek.formacion.javaee.libros.modelos.LoginFormException;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String USUARIO_POR_DEFECTO = "borja";
	private static final String PASSWORD_POR_DEFECTO = "contra";
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
Libro l=new Libro(1,"uheuhe","hulio", 13);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recogida de datos
		
		request.setAttribute("cabecera", new Cabecera("Login"));
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
		request.getRequestDispatcher("contenedor.jsp").forward(request, response);
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		//Empaquetado en Modelo
				LoginForm login = new LoginForm();
				
				try {
					login.setNombre(nombre);
				} catch (LoginFormException e) {
					login.setErrorNombre("*");
				}
					
				try {
					login.setPassword(password);
				} catch (LoginFormException e) {
					login.setErrorPassword("*");
				}

				//Llamada a lï¿½gica de negocio
				if(!login.isErroneo() && validar(login)) {
					//Redirecciï¿½n a vista
					request.getSession().setAttribute("usuario", login);
					response.sendRedirect("login.jsp");
				} else {
					//Redirecciï¿½n a vista
					login.setMensajeError(login.getMensajeError() + " El usuario o contraseï¿½a no son correctos");
					request.setAttribute("login", login);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}

			private boolean validar(LoginForm login) {
				return USUARIO_POR_DEFECTO.equals(login.getNombre()) && PASSWORD_POR_DEFECTO.equals(login.getPassword());
			}

		// TODO Auto-generated method stub
		
		
	}





