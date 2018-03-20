package br.com.bpaixao.bpmoney.api.service;

import br.com.bpaixao.bpmoney.api.model.Lancamento;
import br.com.bpaixao.bpmoney.api.repository.LancamentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public List<Lancamento> listarTodos(){
        return lancamentoRepository.findAll();
    }

    public Lancamento obterPorCodigo(Long codigo){
        Lancamento lancamentoDb = lancamentoRepository.findOne(codigo);
        if(lancamentoDb == null){
            throw new EmptyResultDataAccessException(1);
        }

        return lancamentoDb;
    }

    public Lancamento criar(Lancamento lancamento){
        return lancamentoRepository.save(lancamento);
    }

    public Lancamento atualizar(Long codigo , Lancamento lancamento){
        Lancamento lancamentoDb = obterPorCodigo(codigo);
        BeanUtils.copyProperties(lancamento, lancamentoDb, "codigo");
        return lancamentoRepository.save(lancamentoDb);
    }

}
