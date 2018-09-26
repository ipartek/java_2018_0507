package com.ipartek.ebook.controlador;

import com.ipartek.ebook.logica.LogicaNegocio;
import com.ipartek.ebook.pojo.Pagina;
import com.ipartek.ebook.pojo.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class PrincipalServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
        
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String pass = request.getParameter("pass");

        Usuario usuario = new Usuario(nombre, pass);

        Boolean valido = LogicaNegocio.validarUsuario(usuario);
        if (valido) {
            request.getSession().setAttribute("usuario", usuario);
            request.getRequestDispatcher("principal").forward(request, response);
        } else {
            request.setAttribute("error","No existe ese usuario o no son correctos los datos");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }


    }

}
