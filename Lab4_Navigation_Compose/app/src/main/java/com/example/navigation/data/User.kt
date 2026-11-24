package com.example.navigation.data

/**
 * Модель пользователя приложения.
 *
 * @property id уникальный идентификатор
 * @property name имя пользователя
 * @property age возраст
 * @property city город проживания
 * @property email электронная почта
 */
data class User(
    val id: Int,
    val name: String,
    val age: Int,
    val city: String,
    val email: String = ""
)

/** Возвращает демонстрационный список пользователей. */
fun getSampleUsers(): List<User> = listOf(
    User(1, "Алексей Смирнов", 25, "Москва", "alex@mail.ru"),
    User(2, "Мария Иванова", 30, "Санкт-Петербург", "maria@mail.ru"),
    User(3, "Иван Петров", 22, "Казань", "ivan@mail.ru"),
    User(4, "Екатерина Сидорова", 28, "Новосибирск", "ekaterina@mail.ru"),
    User(5, "Дмитрий Козлов", 35, "Екатеринбург", "dmitry@mail.ru"),
    User(6, "Анна Волкова", 27, "Самара", "anna@mail.ru")
)
