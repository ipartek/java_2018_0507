package com.ipartek.formacion.javaee.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.javaee.modelos.LoginForm;

public class LoginFilter implements Filter {

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//LoginForm usuario = (LoginForm)((HttpServletRequest)request).getSession().getAttribute("usuario");
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session = httpRequest.getSession();
		LoginForm usuario = (LoginForm)session.getAttribute("usuario");
		
		if(usuario == null) {
			HttpServletResponse httpResponse = (HttpServletResponse)response;
			httpResponse.sendRedirect("/javaee/index.jsp");
			return;
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}
