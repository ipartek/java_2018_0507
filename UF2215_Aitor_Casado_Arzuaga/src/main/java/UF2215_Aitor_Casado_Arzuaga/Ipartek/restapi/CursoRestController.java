package UF2215_Aitor_Casado_Arzuaga.Ipartek.restapi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Curso;
import model.Profesor;

@RestController
public class CursoRestController {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/api/cursos")
	public List<Curso> obtenerCursos() {
		return jdbcTemplate.query( "SELECT * FROM curso", new RowMapper<Curso>() {
		    public Curso mapRow(ResultSet rs, int rowNum) throws SQLException {
		    	return new Curso(rs.getString("nombre"), rs.getString("identificador"), rs.getInt("nHoras"), null);
		    }
		});	
	}
	
	@GetMapping("/api/profesores")
	public List<Profesor> obtenerProfes() {
		return jdbcTemplate.query( "SELECT * FROM profesor", new RowMapper<Profesor>() {
		    public Profesor mapRow(ResultSet rs, int rowNum) throws SQLException {
		    	return new Profesor(rs.getString("nombre"), rs.getString("apellidos"));
		    }
		});	
	}
	
	@GetMapping("/api/cursoProfes")
	public List<Curso> obtenerTodos() {
		return jdbcTemplate.query( "SELECT c.nombre, c.identificador, c.nHoras, p.nombre, p.apellidos from curso c, profesor p where c.profesor_codigo = p.codigo", new RowMapper<Curso>() {
		    public Curso mapRow(ResultSet rs, int rowNum) throws SQLException {
		    	return new Curso(rs.getString("c.nombre"), rs.getString("c.identificador"), rs.getInt("c.nHoras"), new Profesor(rs.getString("p.nombre"), rs.getString("p.apellidos")));
		    }
		});	
	}
	
	
}
