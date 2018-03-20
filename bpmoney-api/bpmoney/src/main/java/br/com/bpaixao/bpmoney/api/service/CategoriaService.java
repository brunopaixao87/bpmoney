package br.com.bpaixao.bpmoney.api.service;

import br.com.bpaixao.bpmoney.api.model.Categoria;
import br.com.bpaixao.bpmoney.api.repository.CategoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarTodos() {
        return categoriaRepository.findAll();
    }

    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria atualizar(Long codigo, Categoria categoria) {
        Categoria categoriaDb = buscarPorCodigo(codigo);
        if (categoriaDb == null) {
            throw new EmptyResultDataAccessException(1);
        }
        BeanUtils.copyProperties(categoria, categoriaDb, "codigo");
        return categoriaRepository.save(categoriaDb);
    }

    public Categoria buscarPorCodigo(Long codigo) {
        return categoriaRepository.findOne(codigo);
    }

    public void remover(Long codigo) {
        categoriaRepository.delete(codigo);
    }

}
