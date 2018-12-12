package com.ipartek.formacion.multimodulo_repositoriorest;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.multimodulo_modelo.Usuario;

@RepositoryRestResource(collectionResourceRel = "usuarios", path = "usuarios")
public interface UsuarioRestRepository extends PagingAndSortingRepository<Usuario, Long> {
	List<Usuario> findByEmail(@Param("email") String email);
}
