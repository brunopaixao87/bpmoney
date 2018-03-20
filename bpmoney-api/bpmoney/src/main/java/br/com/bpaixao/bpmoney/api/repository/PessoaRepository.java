package br.com.bpaixao.bpmoney.api.repository;

import br.com.bpaixao.bpmoney.api.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
