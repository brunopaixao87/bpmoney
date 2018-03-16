package br.com.bpaixao.bpmoney.api.resource;

import br.com.bpaixao.bpmoney.api.model.Categoria;
import br.com.bpaixao.bpmoney.api.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listarTodos(){
        return categoriaService.listarTodos();
    }

}
