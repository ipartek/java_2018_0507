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
import com.mysql.cj.jdbc.CallableStatement;

//@Repository
public class EditorialMySqlRepository implements CrudAble<Editorial> {

	private String urlBD;
	private String usuarioBD;
	private String passwordBD;
	
	public EditorialMySqlRepository() {
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
	public Long insert(Editorial pojo) {
		long numFilas =  0;
		try (Connection con = DriverManager.getConnection(urlBD, usuarioBD, passwordBD)) {
			String sql = "{call editoriales_insert(?)}";
			try (CallableStatement cst = (CallableStatement) con.prepareCall(sql)) {
				cst.setString(1, pojo.getNombre());

				numFilas = cst.executeUpdate();

			} catch (SQLException e) {
				throw new AccesoDatosException(e.getMessage(), e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException(e.getMessage(), e);
		}

		return numFilas;
	}

	@Override
	public List<Editorial> getAll() {
		Editorial editorial = null;
		ArrayList<Editorial> editoriales = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(urlBD, usuarioBD, passwordBD)) {
			String sql = "{call editoriales_getAll()}";
			try (CallableStatement cst = (CallableStatement) con.prepareCall(sql)) {

				try (ResultSet rs = cst.executeQuery()) {
					while (rs.next()) {
						editorial = new Editorial(rs.getLong("id"),
												rs.getString("editorial"));
								
						editoriales.add(editorial);
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

		return editoriales;
	}

	@Override
	public Editorial getById(Long id) {
		Editorial editorial = null;
		
		try (Connection con = DriverManager.getConnection(urlBD, usuarioBD, passwordBD)) {
			String sql = "{call editoriales_getById(?)}";
			try (CallableStatement cst = (CallableStatement) con.prepareCall(sql)) {
				cst.setLong(1, id);
				try (ResultSet rs = cst.executeQuery()) {
					if (rs.next()) {
						editorial = new Editorial(rs.getLong("id"), rs.getString("editorial"));
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

		return editorial;
	}

	@Override
	public boolean update(Editorial pojo) {
		try (Connection con = DriverManager.getConnection(urlBD, usuarioBD, passwordBD)) {
			String sql = "{call editoriales_update(?, ?)}";

			try (CallableStatement cst = (CallableStatement) con.prepareCall(sql)) {
				cst.setLong(1, pojo.getId());
				cst.setString(2, pojo.getNombre());
				
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

	@Override
	public boolean delete(Long id) {
		try (Connection con = DriverManager.getConnection(urlBD, usuarioBD, passwordBD)) {
			
			String sql = "{call editoriales_DeleteById(?)}";
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
