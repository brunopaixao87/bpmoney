package br.com.bpaixao.bpmoney.api.resource;

import br.com.bpaixao.bpmoney.api.event.RecursoEvent;
import br.com.bpaixao.bpmoney.api.model.Lancamento;
import br.com.bpaixao.bpmoney.api.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/lacamentos")
public class LancamentoResource {

    @Autowired
    private LancamentoService lancamentoService;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @GetMapping
    public List<Lancamento> listarTodos(){
        return lancamentoService.listarTodos();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Lancamento> obterPorCodigo(@PathVariable Long codigo){
        Lancamento lancamento = lancamentoService.obterPorCodigo(codigo);
        return ResponseEntity.ok(lancamento);
    }

    @PostMapping
    public ResponseEntity<Lancamento> criar(@Valid @RequestBody Lancamento lancamento, HttpServletResponse response){
        Lancamento lancamentoSalvo = lancamentoService.criar(lancamento);

        applicationEventPublisher.publishEvent(RecursoEvent.of(this, response, lancamentoSalvo.getCodigo()));

        return ResponseEntity.status(HttpStatus.CREATED).body(lancamento);

    }

}
