package com.ipartek.superonline.filtros;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.ipartek.superonline.pojo.Usuario;



/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}
					, urlPatterns = { "/admin/*" })
public class AdminFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//Se coge la request para poder acceder a la sesion
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		//Se coge el usuario de la sesion
		Usuario usuario = (Usuario) httpRequest.getSession().getAttribute("usuario");
		
		//Si el usuario es nulo o no es "admin@email.com" se redirige a login
		if (usuario == null || !"admin@email.com".equals(usuario.getNombre())) {
			httpRequest.getRequestDispatcher("/login").forward(request, response);
		} else {
			//Si se cumplen los requisitios se continua 
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
