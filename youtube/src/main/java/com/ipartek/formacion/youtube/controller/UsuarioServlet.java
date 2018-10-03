/*package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.ipartek.formacion.youtube.model.UsuarioArrayListDAO;
import com.ipartek.formacion.youtube.Usuario;

public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Usuario user;
	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	
	public UsuarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(); // recoge la session

		String salir;

		salir = request.getParameter("salir");// name

		if (salir != null && salir.equalsIgnoreCase("salir")) {
			session.invalidate();
		}

		response.sendRedirect("index.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(); // recoge la session

		Usuario user = (Usuario) session.getAttribute("usuario"); // consigues un obj usuario que este en la sesion

		if (user != null) { // si existe el usuario nos olvidamos del coigo a continuacion xq significa que
							// ya ha hecho login
			request.getRequestDispatcher("principal").forward(request, response);
		} else {
			usuarios = (ArrayList<Usuario>) UsuarioArrayListDAO.getInstance().getAll();

			// System.out.println(usuarios.size()+"tama�o");

			PrintWriter out = response.getWriter();

			String usuario, password, formulario;

			formulario = request.getParameter("login");// name
			usuario = request.getParameter("mail");
			password = request.getParameter("password");

			Usuario usuarioObj = new Usuario(usuario, password);

			// Llama a la logica de negocio esta hace las validaciones y nos devolvera un
			// true en caso de que la validacion haya sido correcta y haya encontrado al
			// usuario
			boolean usuarioValido = LogicaNegocio.validarUsuario(usuarioObj);
			// Si el usuariuo es valido , comprobamos si es un registro o un login (Solo en
			// el caso en el que haya los dos)
			if (usuarioValido) {
				if (formulario.equalsIgnoreCase("registro")) {
					// System.out.println(usuario+password);
					// Esto iria en el DAO , se llamaria al dao asi
					// LogicaNegocio.insertUsuario(usuarioObj)

					// Esto insertaria al usuario
					UsuarioDAO.getInstance().insert(new Usuario(usuario, password));
					// Se redirige a la pagina de login , para que vuelva a intentar el login
					response.sendRedirect("Login.jsp");

				}
				if (formulario.equalsIgnoreCase("login")) { // si el value es login
					// Buscamos al usuario en la lista
					if (LogicaNegocio.buscarUsuario(usuarioObj)) {
						session.setAttribute("usuario", usuarioObj); // se mete al usuario en la sesion
						request.getRequestDispatcher("principal").forward(request, response);

					}else {
						request.setAttribute("error", "No existe ese usuario");
						request.getRequestDispatcher("Login.jsp").forward(request, response);// para ir a una pagina
						// pasandole los
						// atributos en la
						// request
					}
				}
			} else {
//Creamos en la request el parametro error (que se recoge en la jsp ) y este pintara el error del usuario 
				request.setAttribute("error", usuarioObj.getError());
				
				//En funcion de si ha fallado en registro o login redirigimos a su respectivo
				
				if (formulario.equalsIgnoreCase("registro")) {
					request.getRequestDispatcher("registro.jsp").forward(request, response);// para ir a una pagina
					// pasandole los
					// atributos en la
					// request
				} else if (formulario.equalsIgnoreCase("login")) {
					request.getRequestDispatcher("Login.jsp").forward(request, response);// para ir a una pagina
					// pasandole los
					// atributos en la
					// request
				}

			}

		}

	}

}*/
