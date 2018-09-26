package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.Pagina;

/**
 * Servlet implementation class AniadirPag
 */
@WebServlet("/aniadirPag")
public class AniadirPag extends HttpServlet {
	int contpags=0;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AniadirPag() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String escritonuevo= request.getParameter("escritonuevo");
		String autor= request.getParameter("autor");
		HttpSession session = request.getSession();
		
		Pagina pagi=new Pagina();
		pagi.setAutor("Inicio");
		pagi.setContenido("Erase una vez...");
		pagi.setIdPag(0);
		
		
		pagi.setAutor(autor);
		pagi.setContenido(escritonuevo);
		pagi.setIdPag(++contpags);
		
		//List<Pagina> paginas = (List<Pagina>)session.getAttribute("paginas");
		
		
		 // System.out.println("paginas.toString:  "+pagi.toString());
		
		
		
		//System.out.println("pagi.getContenido()"+pagi.getContenido());
		System.out.println("Autor:" + autor + "\n Texto a insertar: " + escritonuevo +" \n Numero de pagina: " + contpags);
		
		//response.getWriter().append("Pagina añadida al libro <a href='index.jsp'>volver</a>").append(request.getContextPath());
		request.getSession().setAttribute("pagina",pagi );
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
