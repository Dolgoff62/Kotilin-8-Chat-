package ru.netology

data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,

    ) {
    override fun toString(): String {
        return "UserId = $id, $firstName $lastName"
    }
}