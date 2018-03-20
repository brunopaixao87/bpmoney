package br.com.bpaixao.bpmoney.api.model;

import br.com.bpaixao.bpmoney.api.enumerated.TipoLancamento;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import static com.google.common.base.Preconditions.checkNotNull;

@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable {

    private static final long serialVersionUID = -3773765338472798109L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String descricao;

    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    private BigDecimal valor;

    private String observacao;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoLancamento tipo;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "codigo_categoria")
    private Categoria categoria;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "codigo_pessoa")
    private Pessoa pessoa;

    Lancamento(){}

    private Lancamento(String descricao, LocalDate dataVencimento, LocalDate dataPagamento, BigDecimal valor, String observacao) {
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.valor = valor;
        this.observacao = observacao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public TipoLancamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoLancamento tipo) {
        this.tipo = tipo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa){
        this.pessoa = pessoa;
    }

    public static Lancamento of(String descricao, LocalDate dataVencimento, LocalDate dataPagamento, BigDecimal valor, String observacao) {
        checkNotNull(descricao);
        checkNotNull(dataVencimento);
        checkNotNull(dataPagamento);
        checkNotNull(valor);
        checkNotNull(observacao);
        return new Lancamento(descricao, dataVencimento, dataPagamento, valor, observacao);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("codigo", codigo)
                .add("descricao", descricao)
                .add("dataVencimento", dataVencimento)
                .add("dataPagamento", dataPagamento)
                .add("valor", valor)
                .add("tipo", tipo)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lancamento lancamento = (Lancamento) o;
        return Objects.equal(codigo, lancamento.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }
}
