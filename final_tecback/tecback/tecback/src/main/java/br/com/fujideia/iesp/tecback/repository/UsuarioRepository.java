package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByAnoLancamento (Long Id, String nome);
}
