package br.com.bpaixao.bpmoney.api.resource;

import br.com.bpaixao.bpmoney.api.event.RecursoEvent;
import br.com.bpaixao.bpmoney.api.model.Categoria;
import br.com.bpaixao.bpmoney.api.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listarTodos() {
        return categoriaService.listarTodos();
    }

    @Autowired
    ApplicationEventPublisher eventPublishe;

    /*
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestBody Categoria categoria, HttpServletResponse httpServletResponse) {
        Categoria categoriaSalva = categoriaService.salvar(categoria);

        URI uri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/{codigo}")
                    .buildAndExpand(categoriaSalva.getCodigo())
                    .toUri();

        httpServletResponse.setHeader("Location",uri.toASCIIString());
    }*/

    @GetMapping("/{codigo}")
    public ResponseEntity<Categoria> buscarPorCodigo(@PathVariable Long codigo) {
        Categoria categoria = categoriaService.buscarPorCodigo(codigo);
        return categoria != null ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
        Categoria categoriaSalva = categoriaService.salvar(categoria);

        eventPublishe.publishEvent(RecursoEvent.of(this, response, categoria.getCodigo()));

        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
    }
    @PutMapping("/{codigo}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Long codigo, @Valid @RequestBody Categoria categoria) {
        Categoria categoriaSalva = categoriaService.atualizar(codigo, categoria);
        return ResponseEntity.ok(categoriaSalva);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long codigo) {
        categoriaService.remover(codigo);
    }


}
