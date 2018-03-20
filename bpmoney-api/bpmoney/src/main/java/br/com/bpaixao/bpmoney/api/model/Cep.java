package br.com.bpaixao.bpmoney.api.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class Cep implements Serializable {

    private String value;

    Cep(){}

    private Cep(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Cep of(String value) {
        checkNotNull(value);
        String digits = value.replaceAll("\\D", "");
        checkArgument(digits.matches("\\d{8}"));

        return new Cep(digits);
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cep cep = (Cep) o;
        return Objects.equal(value, cep.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
