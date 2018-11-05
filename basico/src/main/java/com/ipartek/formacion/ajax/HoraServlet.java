package com.ipartek.formacion.ajax;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		
		response.getWriter()
				.append("{ \"hora\": \"" + new Date().getHours() + ":" + new Date().getMinutes() + ":" + new Date().getSeconds() + " - " + new Date().getTimezoneOffset() + "\" }");
	}

}
