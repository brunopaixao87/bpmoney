package br.com.bpaixao.bpmoney.api.event;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

public class RecursoEvent extends ApplicationEvent {

    private static final long serialVersionUID = -5377487111572433042L;

    private final HttpServletResponse response;
    private final Long codigo;

    private RecursoEvent(Object source, HttpServletResponse response, Long codigo) {
        super(source);
        this.response = response;
        this.codigo = codigo;
    }


    public HttpServletResponse getResponse() {
        return response;
    }

    public Long getCodigo() {
        return codigo;
    }

    public static RecursoEvent of(Object source, HttpServletResponse response, Long codigo) {
        return new RecursoEvent(source, response, codigo);
    }

}
