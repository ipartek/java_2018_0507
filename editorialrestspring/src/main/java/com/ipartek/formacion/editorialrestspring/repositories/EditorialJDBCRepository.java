package com.ipartek.formacion.editorialrestspring.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.editorialrestspring.modelos.Editorial;
import com.ipartek.formacion.editorialrestspring.modelos.EditorialRowMapper;

@Repository
public class EditorialJDBCRepository implements CrudAble<Editorial>{

	@Autowired
    JdbcTemplate jdbcTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<Editorial> getAll() {
		 SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				 .withProcedureName("editoriales_getAll")
				 .returningResultSet("editoriales", new EditorialRowMapper());
		
		 Map<String, Object> out = simpleJdbcCall.execute();
		 return (List<Editorial>)out.get("editoriales");
	}

	@Override
	public Editorial getById(Long id) {
		 SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				 .withProcedureName("editoriales_getById");
		 
		SqlParameterSource in = new MapSqlParameterSource().addValue("param_id", id);
		
		Map<String, Object> out = simpleJdbcCall.execute(in);
		
		Editorial editorial = new Editorial();
		editorial.setId((Long) out.get("id"));
		editorial.setNombre((String) out.get("nombre"));
		//((java.util.ArrayList)out.get("#result-set-1")).get(0)
		 
		return editorial;     
	}

	@Override
	public Long insert(Editorial t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Editorial t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
