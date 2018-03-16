package br.com.bpaixao.bpmoney.api.service;

import br.com.bpaixao.bpmoney.api.model.Categoria;
import br.com.bpaixao.bpmoney.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarTodos(){
        return categoriaRepository.findAll();
    }

}
