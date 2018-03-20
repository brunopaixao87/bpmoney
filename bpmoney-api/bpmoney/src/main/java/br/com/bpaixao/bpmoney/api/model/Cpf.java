package br.com.bpaixao.bpmoney.api.model;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

import java.io.Serializable;
import java.util.Formattable;
import java.util.Formatter;

import static com.google.common.base.Preconditions.*;
import static java.util.FormattableFlags.ALTERNATE;
import static java.util.FormattableFlags.LEFT_JUSTIFY;

public class Cpf implements Serializable, Formattable, Comparable<Cpf> {

    private static final long serialVersionUID = -8514870452563374448L;

    private String value;

    Cpf(){}

    private Cpf(String value) {

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Cpf of(String value) {
        checkNotNull(value);
        String digits = value.replaceAll("\\D", "");
        checkArgument(digits.matches("\\d{11}"));
        checkArgument(!digits.matches("(\\d)\\1+"));
        checkArgument(isValid(digits.substring(0, 10)));
        checkArgument(isValid(digits));
        return new Cpf(digits);
    }

    static boolean isValid(String digits) {
        if (Long.parseLong(digits) % 10 == 0) {
            return somaPonderada(digits) % 11 < 2;
        }
        else {
            return somaPonderada(digits) % 11 == 0;
        }
    }

    static int somaPonderada(String digits) {
        char[] cs = digits.toCharArray();
        int soma = 0;
        for (int i = 0; i < cs.length; i++) {
            soma += Character.digit(cs[i], 10) * (cs.length - i);
        }
        return soma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cpf cpf = (Cpf) o;
        return Objects.equal(value, cpf.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        StringBuilder sb = new StringBuilder();
        boolean alternate = (flags & ALTERNATE) == ALTERNATE;
        if (alternate) {
            sb.append(value);
        }
        else {
            sb.append(String.format("%s.%s.%s-%s", value.substring(0, 3), value.substring(3, 6),
                    value.substring(6, 9), value.substring(9)));
        }
        int length = sb.length();
        if (length < width) {
            for (int i = 0; i < width - length; i++) {
                if (alternate) {
                    sb.insert(0, '0');
                }
                else {
                    boolean leftJustified = (flags & LEFT_JUSTIFY) == LEFT_JUSTIFY;
                    if (leftJustified) {
                        sb.append(' ');
                    }
                    else {
                        sb.insert(0, ' ');
                    }
                }
            }
        }
        formatter.format(sb.toString());
    }

    @Override
    public int compareTo(Cpf o) {
        return ComparisonChain
                .start()
                .compare(this.value, o.value)
                .result();
    }
}
