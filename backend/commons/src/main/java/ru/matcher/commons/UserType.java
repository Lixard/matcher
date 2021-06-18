package ru.matcher.commons;

import java.util.Optional;

/**
 * Перечисление для хранения типа пользователя
 *
 * @author Андрей Герасимов
 */
public enum UserType {
	STUDENT(1),
	EMPLOYEE(2);

	public final int id;

	UserType(int id) {
		this.id = id;
	}

	public static Optional<UserType> fromId(Integer id) {
		if (id == null){
			return Optional.empty();
		}
		for (UserType type: UserType.values()){
			if (type.getId() == id){
				return Optional.of(type);
			}
		}
		return Optional.empty();
	}

	public int getId() {
		return id;
	}
}
