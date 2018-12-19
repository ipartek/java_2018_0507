package com.ipartek.formacion.springrestcrud.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.springrestcrud.entidades.Comentario;
import com.ipartek.formacion.springrestcrud.entidades.Incidencia;
import com.ipartek.formacion.springrestcrud.entidades.Usuario;

@Repository
public class IncidenciaMySqlJdbcTemplateRepository implements CrudAble<Incidencia> {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Incidencia> getAll() {
		return jdbcTemplate.query("select * from incidencia", new IncidenciaMapper());
	}
	
	
	@Override
	public List<Incidencia> getByEquipo(String equipo) {
		if(equipo!=null) {
			return (jdbcTemplate.query("select * from incidencia where equipo=?", new Object[] { equipo }, 
											new IncidenciaMapper()));
		}else {
			return jdbcTemplate.query("select * from incidencia", new IncidenciaMapper());		
		}
	}
	
	@Override
	public List<Incidencia> getByUsuario(String usuario) {
		if(usuario!=null) {
			return (jdbcTemplate.query("select * from incidencia where usuario_asignado=?", new Object[] { usuario }, 
											new IncidenciaMapper()));
		}else {
			return jdbcTemplate.query("select * from incidencia", new IncidenciaMapper());		
		}
	}
	
	@Override
	public List<Incidencia> getByEstado(String estado) {
		//System.out.println("Estado recibido" + estado);
		if(estado!=null) {
			return (jdbcTemplate.query("select * from incidencia where estado=?", new Object[] { estado }, 
											new IncidenciaMapper()));
		}else {
			return jdbcTemplate.query("select * from incidencia", new IncidenciaMapper());		
		}
	}
	
	private static final class IncidenciaMapper implements RowMapper<Incidencia> {
		public Incidencia mapRow(ResultSet rs, int rowNum) throws SQLException {
			if (rowNum==-1) {
				//System.out.println("no encontrada");
				return null;
			}else {
			return new Incidencia(rs.getLong("id"), rs.getString("fecha"),rs.getString("usuario_creador"),
					 rs.getString("titulo"), rs.getString("descripcion"), rs.getString("equipo"),
					 rs.getString("usuario_asignado"), rs.getString("estado")
					);
			}
		}
	}

	@Override
	public Incidencia getById(Long id_buscar) {
		
		//System.out.println("ID a buscar" + id_buscar);
		
		if(id_buscar!=null) {
			//System.out.println("dentro del if");
			return (jdbcTemplate.queryForObject("select * from incidencia where id=?", new Object[] { id_buscar },
				new IncidenciaMapper()));
			}else {
				return jdbcTemplate.queryForObject("select * from incidencia", new IncidenciaMapper());
						
			}
		
	}

	@Override
	public void insert(Incidencia incidencia) {
		jdbcTemplate.update("insert into incidencia (fecha,usuario_creador,titulo,descripcion"
				+ ",equipo,usuario_asignado,estado) values (?,?,?,?,?,?,?)",
				new Object[] { 
							incidencia.getFecha(),incidencia.getUsuario_creador() , 
							incidencia.getTitulo(),incidencia.getDescripcion(),incidencia.getEquipo(),
							incidencia.getUsuario_asignado(), incidencia.getEstado(),
						});
	}

	@Override
	public void update(Incidencia incidencia) {
		jdbcTemplate.update("update incidencia set usuario_creador=?,titulo=?,descripcion=?,equipo=?,usuario_asignado=?,estado=? where id=?",
				
				new Object[] { 
						incidencia.getUsuario_creador(),incidencia.getTitulo(), incidencia.getDescripcion() 
						, incidencia.getEquipo(),incidencia.getUsuario_asignado(),incidencia.getEstado(), incidencia.getId(), 
					});
	}

	@Override
	public List<Comentario> getByIdIncidencia(String incidencia_id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Usuario> getUsuarioLogin(String usuario, String password) {
		// TODO Auto-generated method stub
		return null;
	}



}
