package ru.netology

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main() {
    val time: LocalDateTime = LocalDateTime.now()
    val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
    val formatted: String = time.format(formatter)
    val chatService = ChatService()

    val vasya = User(
        id = 1,
        firstName = "Vasya",
        lastName = "Pupkin",
    )
    val lena = User(
        id = 2,
        firstName = "Lena",
        lastName = "Berkova",
    )
    val jora = User(
        id = 3,
        firstName = "Giorgio",
        lastName = "Vkarmani",
    )
    val leo = User(
        id = 4,
        firstName = "Leo",
        lastName = "Di Tolstoy",
    )

    val message1 = Message(
        dateTime = formatted,
        text = "first",
        senderId = 1,
        recipientId = 2
    )
    val message2 = Message(
        dateTime = formatted,
        text = "second",
        senderId = 2,
        recipientId = 1
    )
    val message3 = Message(
        dateTime = formatted,
        text = "third",
        senderId = 1,
        recipientId = 3
    )
    val message4 = Message(
        dateTime = formatted,
        text = "fourth",
        senderId = 3,
        recipientId = 1
    )
    val message5 = Message(
        dateTime = formatted,
        text = "fifth",
        senderId = 2,
        recipientId = 1
    )
    val message6 = Message(
        dateTime = formatted,
        text = "sixth",
        senderId = 2,
        recipientId = 1
    )
    val message7 = Message(
        dateTime = formatted,
        text = "seventh",
        senderId = 2,
        recipientId = 1
    )
    val message8 = Message(
        dateTime = formatted,
        text = "eighth",
        senderId = 2,
        recipientId = 3
    )
    val message9 = Message(
        dateTime = formatted,
        text = "ninth",
        senderId = 2,
        recipientId = 1
    )
    val message10 = Message(
        dateTime = formatted,
        text = "tenth",
        senderId = 4,
        recipientId = 2
    )
    val message11 = Message(
        dateTime = formatted,
        text = "eleventh",
        senderId = 1,
        recipientId = 2
    )
    val updatedMessage = Message(
        id = 1,
        dateTime = formatted,
        text = "UPDATED!!!",
        senderId = 1,
        recipientId = 2
    )

    chatService.addUserToData(vasya)
    chatService.addUserToData(lena)
    chatService.addUserToData(jora)
    chatService.addUserToData(leo)

    chatService.addMessage(message1)
    chatService.addMessage(message2)
    chatService.addMessage(message3)
    chatService.addMessage(message4)
    chatService.addMessage(message5)
    chatService.addMessage(message6)
    chatService.addMessage(message7)
    chatService.addMessage(message8)
    chatService.addMessage(message9)
    chatService.addMessage(message10)
    chatService.addMessage(message11)

    chatService.editingMessage(updatedMessage)
    val unreadChat = chatService.getUnreadChats(3)
    println("Количество непрочитанных чатов = $unreadChat")
    chatService.deleteMessage(5)
    chatService.deleteChatById(listOf(4, 2))
    chatService.getMessagesFromChat(chatId = listOf(1, 2), 5, 2)

    val print = chatService.getChatList()

    for ((k, v) in print) {
        println("$k\t$v")
    }
}
