package br.com.bpaixao.bpmoney.api.service;

import br.com.bpaixao.bpmoney.api.model.Pessoa;
import br.com.bpaixao.bpmoney.api.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public List<Pessoa> listarTodos() {
        return pessoaRepository.findAll();
    }

    public Pessoa obterPorCodigo(Long codigo) {
        Pessoa pessoaDb = pessoaRepository.findOne(codigo);
        if ( pessoaDb == null ){
            throw new EmptyResultDataAccessException(1);
        }
        return pessoaDb;
    }

    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa atualizar( Long codigo, Pessoa pessoa) {
        Pessoa pessoaDb = obterPorCodigo(codigo);
        BeanUtils.copyProperties(pessoa, pessoaDb, "codigo");
        return pessoaRepository.save(pessoaDb);
    }
    
    public Pessoa alterarStatus(Long codigo){
        Pessoa pessoaDb = obterPorCodigo(codigo);
        pessoaDb.alteraStatus();
        return pessoaRepository.save(pessoaDb);
    }

    public void remover(Long codigo) {
        pessoaRepository.delete(codigo);
    }

}
