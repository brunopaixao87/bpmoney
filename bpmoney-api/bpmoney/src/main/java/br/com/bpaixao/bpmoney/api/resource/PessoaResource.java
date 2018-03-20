package br.com.bpaixao.bpmoney.api.resource;

import br.com.bpaixao.bpmoney.api.event.RecursoEvent;
import br.com.bpaixao.bpmoney.api.model.Pessoa;
import br.com.bpaixao.bpmoney.api.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

    @Autowired
    PessoaService pessoaService;

    @Autowired
    ApplicationEventPublisher eventPublishe;

    @GetMapping
    public List<Pessoa> listarTodos() {
        return pessoaService.listarTodos();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Pessoa> obterPorId(@PathVariable Long codigo) {
        Pessoa pessoa = pessoaService.obterPorCodigo(codigo);
        return pessoa != null ? ResponseEntity.ok(pessoa) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {
        Pessoa pessoaSalva = pessoaService.save(pessoa);

        eventPublishe.publishEvent(RecursoEvent.of(this, response, pessoaSalva.getCodigo()));

        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);

    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Pessoa> criar(@PathVariable Long codigo, @Valid @RequestBody Pessoa pessoa) {
        Pessoa pessoaSalva = pessoaService.atualizar(codigo, pessoa);
        return ResponseEntity.ok(pessoaSalva);

    }

    @PutMapping("/{codigo}/status")
    public ResponseEntity<Pessoa> alterarStatus(@PathVariable Long codigo) {
        Pessoa pessoaSalva = pessoaService.alterarStatus(codigo);
        return ResponseEntity.ok(pessoaSalva);

    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long codigo) {
        pessoaService.remover(codigo);
    }
}
