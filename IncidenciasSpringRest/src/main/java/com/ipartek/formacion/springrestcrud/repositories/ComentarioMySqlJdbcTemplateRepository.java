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
public class ComentarioMySqlJdbcTemplateRepository implements CrudAble<Comentario> {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Comentario> getAll() {
		return jdbcTemplate.query("select * from comentario", new ComentarioMapper());
	}

	private static final class ComentarioMapper implements RowMapper<Comentario> {
		public Comentario mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Comentario(rs.getLong("id"),rs.getLong("id_incidencia"),rs.getString("usuario"),rs.getString("comentario"),rs.getString("fecha"));
		}
	}

	@Override
	public Comentario getById(Long id) {
		return jdbcTemplate.queryForObject("select * from comentario where id=?", new Object[] { id },
				new ComentarioMapper());
	}

	@Override
	public List<Comentario> getByIdIncidencia(String incidencia_id) {
		System.out.println("getByIdIncidencia" + incidencia_id);
		if(incidencia_id!=null) {
			//ESta select no va
			return (jdbcTemplate.query("select * from comentario where id_incidencia=?", new Object[] { incidencia_id }, 
											new ComentarioMapper()));
		}else {
			return jdbcTemplate.query("select * from comentario", new ComentarioMapper());		
		}
	}
	
	@Override
	public void insert(Comentario comentario) {
		jdbcTemplate.update("insert into comentario (id_incidencia,usuario,comentario,fecha) values (?,?,?,?)",
				new Object[] {comentario.getId_incidencia(),comentario.getUsuario(),comentario.getComentario(),comentario.getFecha()});

	}

	@Override
	public void update(Comentario comentario) {
		jdbcTemplate.update("update comentario set id_incidencia=? ,usuario=?,comentario=?,fecha=? where id=?",
				new Object[] {comentario.getId_incidencia(),comentario.getUsuario(),comentario.getComentario(),comentario.getFecha(),comentario.getId()});

	}

	@Override
	public List<Comentario> getByEquipo(String equipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comentario> getUsuarioLogin(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Incidencia> getByUsuario(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Incidencia> getByEstado(String estado) {
		// TODO Auto-generated method stub
		return null;
	}
}
