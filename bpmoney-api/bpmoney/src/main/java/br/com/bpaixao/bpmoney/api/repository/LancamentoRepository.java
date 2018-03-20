package br.com.bpaixao.bpmoney.api.repository;

import br.com.bpaixao.bpmoney.api.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
}
