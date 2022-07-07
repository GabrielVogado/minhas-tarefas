package br.com.uniciv.minhastarefas.repository;

import br.com.uniciv.minhastarefas.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
