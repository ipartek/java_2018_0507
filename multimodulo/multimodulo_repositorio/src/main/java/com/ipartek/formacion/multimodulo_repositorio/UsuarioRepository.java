package com.ipartek.formacion.multimodulo_repositorio;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.multimodulo_modelo.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
