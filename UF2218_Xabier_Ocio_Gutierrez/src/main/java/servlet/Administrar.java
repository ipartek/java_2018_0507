package servlet;
import java.io.IOException;import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Administrar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Administrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//java losgin por sesion
		HttpSession sesion = request.getSession();
		String correo=request.getParameter("correo");
		String pas=request.getParameter("pass");
		if(correo.equals("William") && pas.equals("Shakespeare")||correo.equals("cervantes") && pas.equals("saavedra")||correo.equals("pablo") && pas.equals("neruda")||correo.equals("paulo") && pas.equals("cohelo")){
            //si coincide usuario y password y además no hay sesión iniciada
            sesion.setAttribute("usuario", correo);
            response.sendRedirect("indexLogueado.jsp");		
	}else {
		response.sendRedirect("index.jsp");	
	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
