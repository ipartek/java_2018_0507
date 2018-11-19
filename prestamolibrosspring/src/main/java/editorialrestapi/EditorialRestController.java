package editorialrestapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.prestamolibrosspring.model.Editorial;
import com.ipartek.formacion.prestamolibrosspring.repositories.CrudAble;

@RestController // capaz de recibir peticiones. se suma al mapin
public class EditorialRestController {
	@Autowired //intancia el objeto y lo hace unico (singelton)(se conecta a un repositori o component)
	private CrudAble<Editorial> repositorio;
	@GetMapping("/api/editoriales/{id}")
	public Editorial obtenerEditorialPorId(@PathVariable("id")Long id) {
		return repositorio.getById(id);
	}
	
	// PathVariable-->Recoge del enlace.
	// RequestBody-->Recoje de un formulario.
	
	//Debolver todas las editoriales
	@GetMapping("/api/editoriales")
	public List<Editorial> obtenerEditoritoriales() {
		return repositorio.getAll();
	}
	@PostMapping("api/editoriales")
	public Long crearNuevaEditorial(@RequestBody Editorial editorial) {
		return repositorio.insert(editorial);
	}
	@PutMapping("/api/editoriales/{id}")
		public void CambiarEditorial(@PathVariable("id")Long id, @RequestBody Editorial editorial) {
			repositorio.update(editorial);
		}
	@DeleteMapping("/api/editoriales/{id}")
		public void borrarEditorial(@PathVariable("idrecibido")Long id) {
			repositorio.delete(id);
	}
}
