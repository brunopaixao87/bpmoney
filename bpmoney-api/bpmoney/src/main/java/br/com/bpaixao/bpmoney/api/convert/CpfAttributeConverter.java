package br.com.bpaixao.bpmoney.api.convert;

import br.com.bpaixao.bpmoney.api.model.Cpf;
import com.google.common.base.Strings;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class CpfAttributeConverter implements AttributeConverter<Cpf, String> {
    @Override
    public String convertToDatabaseColumn(Cpf cpf) {
        if (cpf == null) {
            return null;
        }

        return cpf.getValue();
    }

    @Override
    public Cpf convertToEntityAttribute(String dbData) {
        if (Strings.isNullOrEmpty(dbData)) {
            return null;
        }

        return Cpf.of(dbData);
    }
}
