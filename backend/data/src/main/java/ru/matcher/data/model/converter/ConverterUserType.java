package ru.matcher.data.model.converter;

import ru.matcher.commons.UserType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ConverterUserType implements AttributeConverter<UserType, Integer> {

	@Override
	public Integer convertToDatabaseColumn(UserType attribute) {
		return attribute.getId();
	}

	@Override
	public UserType convertToEntityAttribute(Integer dbData) {
		return UserType.fromId(dbData).orElseThrow();
	}
}
