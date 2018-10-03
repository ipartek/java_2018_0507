package com.ipartek.formacion.bbddyoutube.logica;

import java.util.ArrayList;

import com.ipartek.formacion.bbddyoutube.accesodatos.UsuarioMySqlDAO;
import com.ipartek.formacion.bbddyoutube.accesodatos.VideoMySqlDAO;
import com.ipartek.formacion.bbddyoutube.pojos.Usuario;
import com.ipartek.formacion.bbddyoutube.pojos.Video;

public class LogicaNegocio {
	private static ArrayList<Usuario> usuarios = (ArrayList<Usuario>) UsuarioMySqlDAO.getInstance().getAll();
	private static ArrayList<Video> videos = (ArrayList<Video>) VideoMySqlDAO.getInstance().getAll();		
	
	public static boolean validarUsuario(Usuario usuario) {
		for(Usuario u: usuarios) {
			if(u.getNombre().equals(usuario.getNombre())) {
				return u.getPassword().equals(usuario.getPassword());
			}
		}
		return false;
	}

	public static boolean validarVideo(Video video) {
		for (Video v: videos) {
			if(v.getIdVideo().equals(video.getIdVideo())) {
				// El video esta en la bbdd
				return true;
			}
		}
		// El video NO esta en la bbdd
		return false;
	}
}
