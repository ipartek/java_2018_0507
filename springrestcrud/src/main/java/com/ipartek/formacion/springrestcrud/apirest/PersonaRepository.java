package com.ipartek.formacion.springrestcrud.apirest;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.springrestcrud.entidades.Persona;

@RepositoryRestResource(collectionResourceRel = "personas", path = "persona")
public interface PersonaRepository extends PagingAndSortingRepository<Persona, Long> {

	List<Persona> findByApellidos(@Param("nombre") String nombre);
}
