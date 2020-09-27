package ru.netology

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main() {
    val time: LocalDateTime = LocalDateTime.now()
    val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
    val formatted: String = time.format(formatter)
    val chatService = ChatService()
    val printInformation = PrintInformation()

    val vasya = User(
            id = 1,
            firstName = "Leo",
            lastName = "Di Tolstoy",
            emptyList(),
            emptyList()
    )
    val lena = User(
            id = 2,
            firstName = "Lena",
            lastName = "Berkova",
            emptyList(),
            emptyList()
    )
    val jora = User(id = 3,
            firstName = "Giorgio",
            lastName = "Vkarmani",
            emptyList(),
            emptyList()
    )
    val leo = User(id = 4,
            firstName = "Leo",
            lastName = "Di Tolstoy",
            emptyList(),
            emptyList()
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
            senderId = 1,
            recipientId = 4
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
            senderId = 2,
            recipientId = 1
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

    chatService.createChat(message1)
    chatService.createChat(message2)
    chatService.createChat(message3)
    chatService.createChat(message4)
    chatService.createChat(message5)
    chatService.createChat(message6)
    chatService.createChat(message7)
    chatService.createChat(message8)
    chatService.createChat(message9)
    chatService.createChat(message10)
    chatService.createChat(message11)

    chatService.editingMessage(updatedMessage)


    chatService.getMessagesFromChat(chatId = listOf(1, 2), 5, 2)
    chatService.getUnreadChats(4)
//    chatService.deleteMessage(8)
//    chatService.deleteChatById(listOf(1, 3))
    printInformation.printChats()
//    chatService.getChats()
}

