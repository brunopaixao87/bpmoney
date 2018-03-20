package br.com.bpaixao.bpmoney.api.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

	private static final long serialVersionUID = 3693595005375805939L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@NotNull
	@Size(min = 3, max = 50)
	private String nome;

	Categoria(){}

	private Categoria(String nome) {
		this.nome = nome;
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public static Categoria of(String nome) {
		return new Categoria(nome);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Categoria categoria = (Categoria) o;
		return Objects.equal(codigo, categoria.codigo) &&
				Objects.equal(nome, categoria.nome);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(codigo, nome);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("codigo", codigo)
				.add("nome", nome)
				.toString();
	}
}
