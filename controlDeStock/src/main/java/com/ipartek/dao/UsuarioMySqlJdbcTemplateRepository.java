package com.ipartek.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.modelos.Usuario;

@Repository
public class UsuarioMySqlJdbcTemplateRepository implements CrudAble{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Usuario getByUsuario(String usuario) {
		return new Usuario();
	}

	

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long insert(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Object t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
