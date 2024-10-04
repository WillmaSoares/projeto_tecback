package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Diretor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface DiretorRepository  extends JpaRepository<Diretor, Long> {

    List<Diretor> findByAnoLancamento (Long Id, String nome);


}
