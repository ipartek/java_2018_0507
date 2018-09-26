package com.ipartek.formacion.javaee.uf2218.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.uf2218.logica.LogicaNegocio;
import com.ipartek.formacion.javaee.uf2218.pojo.Pagina;
import com.ipartek.formacion.javaee.uf2218.pojo.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 5614085014067193677L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				request.setCharacterEncoding("UTF-8");
				String id = request.getParameter("id");
				String nombre = request.getParameter("nombre");
				String password = request.getParameter("password");
				String texto = request.getParameter("texto") ;
				
				if (nombre == null || password == null) {
					throw new RuntimeException("Requeridos nombre y contraseña.");
				}
				Usuario usuario = new Usuario(nombre, password);
		
				boolean usuarioValido = LogicaNegocio.validarUsuario(usuario);

				if (usuario.isCorrecto() && usuarioValido) {
					
					//cargarPagina(request, id);
					request.getSession().setAttribute("user", usuario);
					Pagina pagina = LogicaNegocio.obtenerPaginasPorId(Long.parseLong("1"));
					request.setAttribute("pagina",pagina);
					request.getRequestDispatcher("/main.jsp").forward(request, response);
					//request.getRequestDispatcher("principal").forward(request, response);
				} else {
					
					if (!usuarioValido) {
						request.setAttribute("errores", "El usuario no es válido");
					}
					request.setAttribute("user", usuario);
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
	}
	/*private void cargarPagina(HttpServletRequest request, String id) {
		Pagina pagina;
		pagina = LogicaNegocio.obtenerPaginasPorId(Long.parseLong(id));
		request.setAttribute("pag", pagina);
	}*/

}
