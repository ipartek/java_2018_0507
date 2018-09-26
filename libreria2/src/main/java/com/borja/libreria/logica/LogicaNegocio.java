package com.borja.libreria.logica;

import java.util.ArrayList;
import java.util.List;

import com.borja.libreria.pojo.Pagina;
import com.borja.libreria.pojo.Usuario;
import com.borja.libreria.accesodatos.MapDAO;
import com.borja.libreria.logica.LogicaNegocioException;

public class LogicaNegocio {
	private static MapDAO<Usuario> usuarios = new MapDAO<Usuario>();
	private static MapDAO<Pagina> paginas = new MapDAO<Pagina>();

	static {
		usuarios.insert(new Usuario(1, "cervantes@biblioteca.com", "saavedra"));
		usuarios.insert(new Usuario(2, "william@biblioteca.com", "shakespeare"));
		usuarios.insert(new Usuario(3, "pablo@biblioteca.com", "neruda"));
		usuarios.insert(new Usuario(4, "paulo@biblioteca.com", "cohelo"));

		paginas.insert(new Pagina(1, "<br><h1>Erase Una vez....</h1><br>", "borja"));
		paginas.insert(new Pagina(2,
				"Nota: Si aparece el mensaje 500 Internal Server Error durante el proceso de compra de un visitante en línea, ten en cuenta que los intentos duplicados de pago pueden terminar creando múltiples pedidos y ¡múlría tienen protecciones aener en cuenta.ra la memoria caché de tu navegador. Si hay un problema con la versión en caché de la página que estás viendo, podría estar causando problemas HTTP 500.Nota: Los errores internos del servidor no suelen ser causados ​​por problemas de almacenamiento en caché, pero, en ocasiones, se ha visto desaparecer el error después de borrar el caché. Es algo fácil de intentar, así que no te lo saltes.",
				"Ursula"));

		paginas.insert(new Pagina(3,
				"El Error 500 - Internal server error, es un código de estado HTTP muy general que significa que algo ha ido mal en el servidor del sitio web, pero el servidor no puede ser más específico sobre cuál es el problema exacto.\r\n"
						+ "\r\n"
						+ "El mensaje error 500 Internal Server Error se puede ver de varias maneras porque cada sitio web tiene permiso para personalizar el mensaje.\r\n"
						+ "\r\n" + "Aquí hay varias formas comunes de ver el error HTTP 500:\r\n" + "\r\n"
						+ "500 Internal Server Error\r\n" + "\r\n" + "HTTP 500 - Internal Server Error\r\n" + "\r\n"
						+ "Temporary Error (500)\r\n" + "\r\n" + "Internal Server Error\r\n" + "\r\n"
						+ "HTTP 500 Internal Error",
				"juana"));
		paginas.insert(new Pagina(4,
				"1. Un error de permisos. En la mayoría de los casos, un error interno del servidor 500 se debe a un permiso incorrecto en uno o más archivos o carpetas. En la mayoría de esos casos, se debe culpar a un permiso incorrecto en un script PHP y CGI .\r\n"
						+ "2. Un tiempo de espera de PHP. Si sffesffafsu secuencia de comandos se cfonecta a recursos externos y el tiempo de espera de estos recursos, puede producirse un error HTTP 500. Las reglas de tiempo de espera, o un mejor manejo de errores en su secuencia de comandos, deberían ayudar si esta es la causa del error 500.\r\n"
						+ "3. Un error de codificación en .htaccess. Aunque no es tan común, asegúrate de verificar que el archivo .htaccess de tu sitio esté estructurado correctamente.",
				"pedu"));
		paginas.insert(new Pagina(5,
				"1. Un error de permisos. En la mayoría de los casos, un error interno del servidor 500 se debe a un permiso incorrecto en uno o más archivos o carpetas. En la mayoría de esos casos, se debe culpar a un permiso incorrecto en un script PHP y CGI .\r\n"
						+ "2. Un tiempo de espera de PHP. Si faesfaacacsu secuencia de comandos se asefaseconecta a recursos externos y el tiempo de espera de estos recursos, puede producirse un error HTTP 500. Las reglas de tiempo de espera, o un mejor manejo de errores en su secuencia de comandos, deberían ayudar si esta es la causa del error 500.\r\n"
						+ "3. Un error de codificación en .htaccess. Aunque no es tan común, asegúrate de verificar que el archivo .htaccess de tu sitio esté estructurado correctamente.",
				"hulio"));
		paginas.insert(new Pagina(6,
				"1. Un error de permisos. En la mayoría de los casossefasef, un error interno del servidor 500 se debe a un permiso incorrecto en uno o más archivos o carpetas. En la mayoría de esos casos, se debe culpar a un permiso incorrecto en un script PHP y CGI .\r\n"
						+ "2. Un tiempo de asefaefafasfasefasespera de PHP. Si su secuencia de comandos se conecta a recursos externos y el tiempo de espera de estos recursos, puede producirse un error HTTP 500. Las reglas de tiempo de espera, o un mejor manejo de errores en su secuencia de comandos, deberían ayudar si esta es la causa del error 500.\r\n"
						+ "3. Un error de codificación en .htaccess. Aunque no es tan común, asegúrate de verificar que el archivo .htaccess de tu sitio esté estructurado correctamente.",
				"knuckles"));
		paginas.insert(new Pagina(7,
				"1. Un error de permisos. En la mayoría de los casos, un error interno del servidor 500 se debe a un permiso incorrecto en uno o más archivos o carpetas. En la mayoría de esos casos, se debe culpar a un permiso incorrecto en un script PHP y CGI .\r\n"
						+ "2. Un tiempo de espera de PHP. Si su secuencia de comandos se conesefasefacta a recursos externos y el tiempo de espera de estos recursos, puede producirse un error HTTP 500. Las reglas de tiempo de espera, o un mejor manejo de errores en su secuencia de comandos, deberían ayudar si esta es la causa del error 500.\r\n"
						+ "3. Un error de codificación en .htaccess. Aunque no esasefaefasefasefa tan común, asegúrate de verificar que el archivo .htaccess de tu sitio esté estructurado correctamente.",
				"sanic"));
	}

	public static boolean validarUsuario(Usuario usuario) {
		for (Usuario u : usuarios.getAll()) {
			if (u.getEmail().equals(usuario.getEmail())) {
				return u.getPassword().equals(usuario.getPassword());
			}
		}

		return false;
		// return ("javier@email.com".equalsIgnoreCase(usuario.getEmail()) &&
		// "contra".equals(usuario.getPassword())) ||
		// ("admin@email.com".equalsIgnoreCase(usuario.getEmail()) &&
		// "contra".equals(usuario.getPassword()));
	}

	public static List<Pagina> obtenerPagina() {
		return paginas.getAll();
	}

	public static Pagina obtenerPaginaPorId(long id) {
		return paginas.getById(id);
	}

	public static void agregarPagina(Pagina pagina) {

		if (!paginas.insert(pagina)) {
			throw new LogicaNegocioException("No se ha podido insertar el registro");
		}
	}

	public static void modificarPagina(Pagina pagina) {
		if (!paginas.update(pagina)) {
			throw new LogicaNegocioException("No se ha podido modificar el registro");
		}
	}

	public static void borrarPagina(long id) {
		if (!paginas.delete(id)) {
			throw new LogicaNegocioException("No se ha podido borrar el registro");
		}
	}
}
