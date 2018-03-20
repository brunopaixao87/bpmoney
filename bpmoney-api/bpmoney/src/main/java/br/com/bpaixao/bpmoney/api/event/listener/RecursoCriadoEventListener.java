package br.com.bpaixao.bpmoney.api.event.listener;

import br.com.bpaixao.bpmoney.api.event.RecursoEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
public class RecursoCriadoEventListener implements ApplicationListener<RecursoEvent> {

    @Override
    public void onApplicationEvent(RecursoEvent recursoCriadoEvent) {

        HttpServletResponse response = recursoCriadoEvent.getResponse();
        Long codigo = recursoCriadoEvent.getCodigo();

        adicionarHeaderLocation(response, codigo);

    }

    private void adicionarHeaderLocation(HttpServletResponse response, Long codigo) {
        URI uri = ServletUriComponentsBuilder.
                fromCurrentContextPath()
                .path("/{codigo}")
                .buildAndExpand(codigo)
                .toUri();
        response.setHeader("Location",uri.toASCIIString());
    }
}
