package com.ipartek.formacion.javaee.prueba;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class recuerdaColorPrueba extends HttpServlet {

	private static final long serialVersionUID = -2476111390293127382L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String color = request.getParameter("color");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println(color);
		if (color.equals("rojo")) {
			color = "#ff0000";
		} else if (color.equals("azul")) {
			color = "#0000ff";
		} else if (color.equals("verde")) {
			color = "#008000";
		} else if (color.equals("negro")) {
			color = "#000000";
		} else {
			out.println("GATETES");
		}
		out.println("<body style='background-color:");
		out.println(color);
		out.println(";'>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);	}

}