package modelos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class Usuario {
	
	private Long id;
	private String email;
	private String password;
	private String equipo;

}
