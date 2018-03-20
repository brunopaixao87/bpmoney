package br.com.bpaixao.bpmoney.api.convert;

import br.com.bpaixao.bpmoney.api.model.Cep;
import com.google.common.base.Strings;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class CepAttributeConverter implements AttributeConverter<Cep, String> {


    @Override
    public String convertToDatabaseColumn(Cep cep) {
        if (cep == null) {
            return null;
        }

        return cep.getValue();
    }

    @Override
    public Cep convertToEntityAttribute(String dbData) {
        if (Strings.isNullOrEmpty(dbData)) {
            return null;
        }

        return Cep.of(dbData);
    }
}
