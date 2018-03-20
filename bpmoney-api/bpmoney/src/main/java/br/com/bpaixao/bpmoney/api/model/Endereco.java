package br.com.bpaixao.bpmoney.api.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

import static com.google.common.base.Preconditions.checkNotNull;

@Embeddable
public class Endereco implements Serializable {


    private static final long serialVersionUID = 8295226902633015168L;

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private Cep cep;
    private String cidade;

    Endereco(){}

    private Endereco(String logradouro, String numero, String complemento, String bairro, Cep cep, String cidade, String estado) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    public static Endereco of(String logradouro, String numero, String complemento, String bairro, Cep cep, String cidade, String estado) {
        checkNotNull(logradouro);
        checkNotNull(numero);
        checkNotNull(complemento);
        checkNotNull(bairro);
        checkNotNull(cep);
        checkNotNull(cidade);
        checkNotNull(estado);
        return new Endereco(logradouro, numero, complemento, bairro, cep, cidade, estado);
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public Cep getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    private String estado;




}
