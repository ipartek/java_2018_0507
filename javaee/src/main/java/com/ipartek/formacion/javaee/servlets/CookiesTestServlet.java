package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookiesTestServlet extends HttpServlet {

	  //http://localhost:8080/javaee/cooktest
	private static final long serialVersionUID = 3226244710233930775L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
		response.setContentType("text/html");
		
		PrintWriter out= response.getWriter();
		Cookie[] cookies = request.getCookies();
		 
		
        String color = request.getParameter("colorelegido");
      //  System.out.println(color);
        out.println("<body bgcolor='"+color+"'>");
        out.println("Color elegido "+color + "<br>");
        out.println("</body>");
        
      

        // set a cookie

       
        if (color != null && color.length() > 0) {
            String value = request.getParameter("color");
            Cookie c = new Cookie(color, value);
            response.addCookie(c);
        }
        
        
        
        // print out cookies
        Cookie c;
       /**Todas las cuquis 
        * for (int i = 0; i < cookies.length; i++) {
             c = cookies[i];
            String name = c.getName();
            String value = c.getValue();
            out.println(name + " = " + value);
        }**/
        
        c = cookies[cookies.length-1];
        out.println("Ultimo"+c.getName()+ "<br>");
        out.println("Ultimo"+c.getValue()+ "<br>");
        
    }
}



