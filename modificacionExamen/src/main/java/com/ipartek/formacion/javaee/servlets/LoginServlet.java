package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.javaee.modelo.LoginForm;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 98629951452290912L;

	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * }
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		// Declaracion printwriter para escribir en pantalla
		PrintWriter out = response.getWriter();
		// declaracion de usuario y contraseña
		// request recoge el parametro usuario y contraseña
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		String remember = "";
		remember = request.getParameter("remember");
        
		// declaro objeto login segun los atributos de la clase LoginForm
		// nombre y clave
		LoginForm login = new LoginForm(user, pass);

		if (remember != null && validar(login)) {
			// Creamos la cookie, los parametros dentro
			// de la cookie son su nombre y valor

		}
/*
		// leemos las cookies usando getCookies que nos devuelve un array de cookies
		Cookie[] cookies_recibidas = request.getCookies();
		if (cookies_recibidas != null) {
			boolean nomUser = false;
			for (int i = 0; i < cookies_recibidas.length; i++) {
				Cookie d = cookies_recibidas[i];
	            String name = d.getName();
	            String value = d.getValue();
	            System.out.println(value);
	            if(value.equals("batman")) {
	            	nomUser=true;
	            	login.setMensajeError("La cookie ya existe");
	            }
			}
			if (nomUser==false) {
    			Cookie c = new Cookie("recordarUsuario", user);
    			c.setMaxAge(60 * 60 * 24 * 365 * 100);
    			response.addCookie(c);
            }
		}
*/
		// compruebo que los datos recibidos no sean null
		if (user == null || pass == null) {
			throw new RuntimeException("No se han recibido los datos" + " de nombre y/o password");
		}
		// Comprobar si se ha introducido si el campo esta vacio o si
		// el nombre es el correcto
		if (user.equals("")) {
			login.setMensajeErrorUsuario("No se ha introducido el nombre");
		} else if (!validarNombre(login)) {
			login.setMensajeErrorUsuario("El nombre no es el correcto");
		} else if (validarNombre(login)) {
			login.setMensajeErrorUsuario("");
		}
		// Comprobar si el campo esta vacio o si es incorrecto
		if (pass.equals("")) {
			login.setMensajeErrorClave("No se ha introducido la clave");
		} else if (!validarClave(login)) {
			login.setMensajeErrorClave("La clave es incorrecta");
		} else if (validarClave(login)) {
			login.setMensajeErrorClave("");
		}

		// valido que el nombre y usuario sean correctos, si lo son van a la pagina
		// principal
		// si no se recarga la pagina
		if (validar(login)) {
			HttpSession session = request.getSession(true);
			//
			 // set session info if needed
	        String dataName = request.getParameter("dataName");
	        if (dataName != null && dataName.length() > 0) {
	            String dataValue = request.getParameter("dataValue");
	            session.setAttribute(dataName, dataValue);
	        }
			//
			request.getSession().setAttribute("usuario", login);
			response.sendRedirect("paginaPrincipal.jsp");
		} else {
			// login.setMensajeError("El usuario o contraseña no son correctos");
			// login.setMensajeError("");
			// request.setAttribute mantiene el nombre en caso de haberte
			// equivocado al escribir la contraseña o el usuario
			request.setAttribute("login", login);
			// procesa el request
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

	
	private boolean validar(LoginForm login) {
		return "batman".equals(login.getNombre()) && "batman".equals(login.getClave());
	}

	private boolean validarNombre(LoginForm logName) {
		return "batman".equals(logName.getNombre());
	}

	private boolean validarClave(LoginForm logPassword) {
		return "batman".equals(logPassword.getClave());
	}

}
