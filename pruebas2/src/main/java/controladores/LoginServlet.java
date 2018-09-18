package controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String 	nombre=request.getParameter("contrasena");
		response.getWriter().append("tu nombre es " + nombre);
		String 	DATO=request.getParameter("color");

		
		
		Cookie miCookie = new Cookie(nombre,DATO);


	    // hacemos que nuestra cookie tenga sentido durante un día
	    miCookie.setMaxAge(60*60*24);


	    response.addCookie(miCookie);
		
		
	    Cookie [] cookies = request.getCookies();


	    for(int i=0; i<cookies.length; i++)
	    {
	        Cookie cookieActual = cookies[i];


	        String identificador = cookieActual.getName();
	        String valor = cookieActual.getValue();


	        if(valor.equals("rojo"));
	        {
	        // tratamiento específico para ese usuario, como por ejemplo mostrar una web
	        // personalizada con los últimos artículos que estuvo consultando.
	        	
	  	      String  color=request.getParameter ("color");


		        response.setContentType ("text/html");
		        PrintWriter out = response.getWriter ();

		        out.println ("<html>");
		        out.println ("<body bgcolor="+color+">");
		        out.println ("<h1>");
		        out.println ("Ha seleccionado color");
		        out.println ("</h1>");
		        out.println ("</body>");
		        out.println ("</html>");
		        
	        }
	        

	        if(valor.equals("verde"));
	        {
	        // tratamiento específico para ese usuario, como por ejemplo mostrar una web
	        // personalizada con los últimos artículos que estuvo consultando.
	        	
	  	      String  color=request.getParameter ("color");


		        response.setContentType ("text/html");
		        PrintWriter out = response.getWriter ();

		        out.println ("<html>");
		        out.println ("<body bgcolor="+color+">");
		        out.println ("<h1>");
		        out.println ("Ha seleccionado color");
		        out.println ("</h1>");
		        out.println ("</body>");
		        out.println ("</html>");
		        
	        }
	        
	    }
	    
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
