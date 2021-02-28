package ru.matcher.data.model.converter;

import ru.matcher.commons.OrganizationType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;

/**
 * Конвертер типа организации
 *
 * @author Максим Щербаков
 */
@Converter(autoApply = true)
public class ConverterOrganizationType implements AttributeConverter<OrganizationType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(OrganizationType attribute) {
        Objects.requireNonNull(attribute, "OrganizationType cannot be null");
        return attribute.getId();
    }

    @Override
    public OrganizationType convertToEntityAttribute(Integer dbData) {
        return OrganizationType.fromId(dbData).orElseThrow();
    }
}
