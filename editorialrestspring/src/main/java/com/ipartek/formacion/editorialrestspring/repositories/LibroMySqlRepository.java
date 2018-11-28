package com.ipartek.formacion.editorialrestspring.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.editorialrestspring.biblioteca.Utils;
import com.ipartek.formacion.editorialrestspring.modelos.Editorial;
import com.ipartek.formacion.editorialrestspring.modelos.Libro;
import com.ipartek.formacion.editorialrestspring.repositories.AccesoDatosException;
import com.mysql.cj.jdbc.CallableStatement;

//@Repository
public class LibroMySqlRepository implements CrudAble<Libro> {

	private String urlBD;
	private String usuarioBD;
	private String passwordBD;
	
	public LibroMySqlRepository() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException(e.getMessage(), e);
		}
		Properties prop = Utils.leerPropiedades("libreria.properties");

		urlBD = prop.getProperty("url");
		usuarioBD = prop.getProperty("usuario");
		passwordBD = prop.getProperty("password");
	}
	
	@Override
	public Long insert(Libro pojo) {
		long numFilas =  0;
		try (Connection con = DriverManager.getConnection(urlBD, usuarioBD, passwordBD)) {
			String sql = "{call libros_insert(?, ?, ?)}";
			try (CallableStatement cst = (CallableStatement) con.prepareCall(sql)) {
				cst.setString(1, pojo.getTitulo());
				cst.setString(2, pojo.getIsbn());
				cst.setLong(3, pojo.getEditorial().getId());

				 numFilas = (long) cst.executeUpdate();
			} catch (SQLException e) {
				throw new AccesoDatosException(e.getMessage(), e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException(e.getMessage(), e);
		}
		return numFilas;
	}

	@Override
	public List<Libro> getAll() {
		Editorial editorial = null;
		ArrayList<Libro> libros = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(urlBD, usuarioBD, passwordBD)) {
			String sql = "{call libros_getAll()}";
			try (CallableStatement cst = (CallableStatement) con.prepareCall(sql)) {

				try (ResultSet rs = cst.executeQuery()) {
					while (rs.next()) {
						editorial = new Editorial(rs.getLong("e.id"),
												rs.getString("e.editorial"));
						Libro libro = new Libro(rs.getLong("l.id"), 
								rs.getString("l.titulo"),
								rs.getString("l.ISBN"),
								editorial);
								
						libros.add(libro);
					}
				} catch (Exception e) {
					throw new AccesoDatosException(e.getMessage(), e);
				}
			} catch (SQLException e) {
				throw new AccesoDatosException(e.getMessage(), e);
			}

		} catch (SQLException e) {
			throw new AccesoDatosException(e.getMessage(), e);
		}

		return libros;
	}

	@Override
	public Libro getById(Long id) {
		Editorial editorial = null;
		Libro libro = null;

		try (Connection con = DriverManager.getConnection(urlBD, usuarioBD, passwordBD)) {
			String sql = "{call libros_getById(?)}";
			try (CallableStatement cst = (CallableStatement) con.prepareCall(sql)) {
				cst.setLong(1, id);
				try (ResultSet rs = cst.executeQuery()) {
					if (rs.next()) {
						editorial = new Editorial(rs.getLong("e.id"), rs.getString("e.editorial"));
						libro = new Libro(rs.getLong("l.id"), 
										rs.getString("l.titulo"),
										rs.getString("l.ISBN"),
										editorial);
					}else {
						return null;
					}
				} catch (SQLException e) {
					throw new AccesoDatosException(e.getMessage(), e);
				}
			} catch (Exception e) {
				throw new AccesoDatosException(e.getMessage(), e);
			}

		} catch (SQLException e) {
			throw new AccesoDatosException(e.getMessage(), e);
		}

		return libro;
	}

	@Override
	public void update(Libro pojo) {
		try (Connection con = DriverManager.getConnection(urlBD, usuarioBD, passwordBD)) {
			String sql = "{call libros_update(?, ?, ?, ?)}";

			try (CallableStatement cst = (CallableStatement) con.prepareCall(sql)) {
				cst.setLong(1, pojo.getId());
				cst.setString(2, pojo.getTitulo());
				cst.setString(3, pojo.getIsbn());
				cst.setLong(4, pojo.getEditorial().getId());

				cst.executeUpdate();

			} catch (SQLException e) {
				throw new AccesoDatosException(e.getMessage(), e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException(e.getMessage(), e);
		}
	}

	@Override
	public boolean delete(Long id) {
		try (Connection con = DriverManager.getConnection(urlBD, usuarioBD, passwordBD)) {
			
			String sql = "{call libros_DeleteById(?)}";
			try (CallableStatement cst = (CallableStatement) con.prepareCall(sql)) {
				cst.setLong(1, id);

				int numFilas = cst.executeUpdate();

				if (numFilas != 1) {
					return false;
				}

			} catch (SQLException e) {
				throw new AccesoDatosException(e.getMessage(), e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException(e.getMessage(), e);
		}

		return true;
	}
}
