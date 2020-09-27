package ru.netology


data class Message(
        val id: Int = 0,
        val dateTime: String,
        val text: String?,
        val readStatus: Boolean = false,
        override val senderId: Int,
        override val recipientId: Int
) : Chat