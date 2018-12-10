package com.ipartek.formacion.ejemplos.librocompartido.pojos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Usuario {

	private  String nick;
	private String password;
	
	public Usuario(String nick, String password) {
		super();
		this.nick = nick;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [nick=" + nick + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nick == null) ? 0 : nick.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (nick == null) {
			if (other.nick != null)
				return false;
		} else if (!nick.equals(other.nick))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Usuario() {
	}

	public static boolean checkUsuarioenBD(String nick, String password) {
		//System.out.println("Checkusuario"+nick + " "+password);
		String usuarioparalogin=null;
		String passparalogin=null;
		String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
		//String url = "jdbc:mysql://localhost:3306/ipartek?serverTimezone=UTC&useSSL=false";
		//System.out.println("En checkUsuarioenBD");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String usuariobd = "root";
		String passwordbd = "admin";
		//String usuariobd = "Akasha";
		//String passwordbd = "Akasha1";
	
		try (Connection conn = DriverManager.getConnection(url, usuariobd, passwordbd)) {

			String sql = "SELECT id, email, password FROM usuarios WHERE email = ?";
			//String sql = "SELECT id, email, password FROM usuarios";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {
				//System.out.println("nick:"+nick);
				pst.setString(1,nick);
				//pst.setString(1, email);
				
				try (ResultSet rs = pst.executeQuery()) {
					
					while (rs.next()) {
						usuarioparalogin=rs.getString("email");
						passparalogin=rs.getString("password");
					}
					if(passparalogin.equals(password)) {
						//System.out.println("mismapass");
						return true;
					}else {
						//System.out.println("Password erronea");
						return false;
					}
				} catch (Exception e) {
					System.out.println("ERROR AL CREAR EL RESULTSET");
				} 
			} catch (Exception e) {
				System.out.println("ERROR AL CREAR LA SENTENCIA");
			} 
			
		} catch (SQLException e) {
			System.out.println("ERROR DE CONEXION");
			System.out.println(e.getMessage());
		}
		return false;
	}

}
