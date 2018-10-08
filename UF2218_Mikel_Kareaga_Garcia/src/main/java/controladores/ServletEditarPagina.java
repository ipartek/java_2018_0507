package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.LogicaNegocio;
import pojo.Hoja;
import pojo.Usuario;

/**
 * Servlet implementation class ServletEditarPagina
 */
@WebServlet("/editar")
public class ServletEditarPagina extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEditarPagina() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("editar.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String texto = request.getParameter("escrito");
		
		//Añadimos un nuevo numero de Hoja
		int id = LogicaNegocio.obtenerNumeroHojas()+1;
		String autor = ((Usuario) request.getSession().getAttribute("usuario")).getNombre();
	
		Hoja hoja = new Hoja(id,autor,texto);
		
		boolean correcto = LogicaNegocio.insertarNuevaHoja(hoja);
		
		if(correcto) {
			response.sendRedirect("index?hoja=" + id);
		}else {
			request.setAttribute("texto", texto);
			request.setAttribute("error", "Solo se admiten un maximo de 25 palabras");
			request.getRequestDispatcher("editar.jsp");
		}
	}

}
