package br.com.bpaixao.bpmoney.api.repository;

import br.com.bpaixao.bpmoney.api.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
