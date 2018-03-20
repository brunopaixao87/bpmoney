package br.com.bpaixao.bpmoney.api.model;


import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

import static com.google.common.base.Preconditions.*;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 8203039485058250699L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotNull
    private Cpf cpf;

    @NotNull
    private String nome;

    @NotNull
    @Embedded
    private Endereco endereco;

    @NotNull
    private boolean ativo = true;

    Pessoa(){}

    private Pessoa(String nome, Cpf cpf, Endereco endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void alteraStatus(){
        ativo = !ativo;
    }

    public static Pessoa of(String nome, Cpf cpf, Endereco endereco) {
        checkNotNull(nome);
        checkNotNull(endereco);
        checkNotNull(cpf);
        return new Pessoa(nome, cpf, endereco);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("codigo", codigo)
                .add("cpf", cpf)
                .add("nome", nome)
                .add("ativo", ativo)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equal(codigo, pessoa.codigo) &&
                Objects.equal(cpf, pessoa.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo, cpf);
    }
}
