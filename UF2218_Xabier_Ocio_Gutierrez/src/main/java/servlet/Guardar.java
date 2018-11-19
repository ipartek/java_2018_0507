package servlet;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clases.Libro;
import clases.Pagina;

public class Guardar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Guardar() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String producto=request.getParameter("texto");
		HttpSession sesion = request.getSession();
		StringTokenizer st = new StringTokenizer(producto);
		if(st.countTokens()>25) {
		Pagina pj=new Pagina();
		String nom=(String)sesion.getAttribute("usuario");
		pj.setAutor(nom);
		if(Libro.getLibro().size()==0) {
		pj.setTexto("erase una vez"+producto);
		}else {
		pj.setTexto(producto);};
		Libro.getLibro().add(pj);}
		response.sendRedirect("indexLogueado.jsp");
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
