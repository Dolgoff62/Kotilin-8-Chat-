package ru.netology

import org.junit.Assert.*
import org.junit.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ChatServiceTest {

    @Test
    fun addUserToData() {
        // arrange
        val lena = User(
            id = 2,
            firstName = "Lena",
            lastName = "Berkova"
        )
        val chatService = ChatService()

        // act
        val result = chatService.addUserToData(lena)

        // assert
        assertTrue(result)
    }

    @Test
    fun addUserToData_False() {
        // arrange
        val lena = User(
            id = 2,
            firstName = "Lena",
            lastName = "Berkova"
        )
        val anotherLena = User(
            id = 2,
            firstName = "Lena",
            lastName = "Berkova"
        )
        val chatService = ChatService()

        // act
        chatService.addUserToData(lena)
        val result = chatService.addUserToData(anotherLena)

        // assert
        assertFalse(result)
    }

    @Test
    fun addMessage() {
        // arrange
        val time: LocalDateTime = LocalDateTime.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        val formatted: String = time.format(formatter)
        val chatService = ChatService()
        val vasya = User(
            id = 1,
            firstName = "Leo",
            lastName = "Di Tolstoy"
        )
        val lena = User(
            id = 2,
            firstName = "Lena",
            lastName = "Berkova"
        )
        val message1 = Message(
            dateTime = formatted,
            text = "first",
            senderId = 1,
            recipientId = 2
        )

        //act
        chatService.addUserToData(vasya)
        chatService.addUserToData(lena)
        val result = chatService.addMessage(message1)

        //assert
        assertEquals(result, 1)
    }

    @Test
    fun addMessage_SecondMessage() {
        // arrange
        val time: LocalDateTime = LocalDateTime.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        val formatted: String = time.format(formatter)
        val chatService = ChatService()
        val vasya = User(
            id = 1,
            firstName = "Leo",
            lastName = "Di Tolstoy"
        )
        val lena = User(
            id = 2,
            firstName = "Lena",
            lastName = "Berkova"
        )
        val message1 = Message(
            dateTime = formatted,
            text = "first",
            senderId = 1,
            recipientId = 2
        )
        val message3 = Message(
            dateTime = formatted,
            text = "third",
            senderId = 1,
            recipientId = 2
        )

        //act
        chatService.addUserToData(vasya)
        chatService.addUserToData(lena)
        chatService.addMessage(message1)
        val result = chatService.addMessage(message3)

        //assert
        assertEquals(result, 2)
    }

    @Test
    fun deleteMessage_True() {
        // arrange
        val time: LocalDateTime = LocalDateTime.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        val formatted: String = time.format(formatter)
        val chatService = ChatService()
        val vasya = User(
            id = 1,
            firstName = "Leo",
            lastName = "Di Tolstoy"
        )
        val lena = User(
            id = 2,
            firstName = "Lena",
            lastName = "Berkova"
        )
        val message1 = Message(
            id = 1,
            dateTime = formatted,
            text = "first",
            senderId = 1,
            recipientId = 2
        )

        //act
        chatService.addUserToData(vasya)
        chatService.addUserToData(lena)
        chatService.addMessage(message1)
        val result = chatService.deleteMessage(1)

        //assert
        assertTrue(result)
    }

    @Test
    fun deleteMessage_False() {
        // arrange
        val time: LocalDateTime = LocalDateTime.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        val formatted: String = time.format(formatter)
        val chatService = ChatService()
        val vasya = User(
            id = 1,
            firstName = "Leo",
            lastName = "Di Tolstoy"
        )
        val lena = User(
            id = 2,
            firstName = "Lena",
            lastName = "Berkova"
        )
        val message1 = Message(
            id = 1,
            dateTime = formatted,
            text = "first",
            senderId = 1,
            recipientId = 2
        )

        //act
        chatService.addUserToData(vasya)
        chatService.addUserToData(lena)
        chatService.addMessage(message1)
        val result = chatService.deleteMessage(5)

        //assert
        assertFalse(result)
    }

    @Test
    fun deleteChatById_True() {
        // arrange
        val time: LocalDateTime = LocalDateTime.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        val formatted: String = time.format(formatter)
        val chatService = ChatService()
        val vasya = User(
            id = 1,
            firstName = "Leo",
            lastName = "Di Tolstoy"
        )
        val lena = User(
            id = 2,
            firstName = "Lena",
            lastName = "Berkova"
        )
        val message1 = Message(
            dateTime = formatted,
            text = "first",
            senderId = 1,
            recipientId = 2
        )

        //act
        chatService.addUserToData(vasya)
        chatService.addUserToData(lena)
        chatService.addMessage(message1)
        val chatKey = listOf(1, 2)
        val result = chatService.deleteChatById(chatKey)

        //assert
        assertTrue(result)
    }

    @Test
    fun deleteChatById_False() {
        // arrange
        val time: LocalDateTime = LocalDateTime.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        val formatted: String = time.format(formatter)
        val chatService = ChatService()
        val vasya = User(
            id = 1,
            firstName = "Leo",
            lastName = "Di Tolstoy"
        )
        val lena = User(
            id = 2,
            firstName = "Lena",
            lastName = "Berkova"
        )
        val message1 = Message(
            dateTime = formatted,
            text = "first",
            senderId = 1,
            recipientId = 2
        )

        //act
        chatService.addUserToData(vasya)
        chatService.addUserToData(lena)
        chatService.addMessage(message1)
        val chatKey = listOf(5, 2)
        val result = chatService.deleteChatById(chatKey)

        //assert
        assertFalse(result)
    }

    @Test
    fun editingMessage_True() {
        // arrange
        val time: LocalDateTime = LocalDateTime.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        val formatted: String = time.format(formatter)
        val chatService = ChatService()
        val vasya = User(
            id = 1,
            firstName = "Leo",
            lastName = "Di Tolstoy"
        )
        val lena = User(
            id = 2,
            firstName = "Lena",
            lastName = "Berkova"
        )
        val message1 = Message(
            dateTime = formatted,
            text = "first",
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

        // act
        chatService.addUserToData(vasya)
        chatService.addUserToData(lena)
        chatService.addMessage(message1)
        val result = chatService.editingMessage(updatedMessage)

        // assert
        assertTrue(result)
    }

    @Test
    fun editingMessage_False() {
        // arrange
        val time: LocalDateTime = LocalDateTime.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        val formatted: String = time.format(formatter)
        val chatService = ChatService()
        val vasya = User(
            id = 1,
            firstName = "Leo",
            lastName = "Di Tolstoy"
        )
        val lena = User(
            id = 2,
            firstName = "Lena",
            lastName = "Berkova"
        )
        val message1 = Message(
            dateTime = formatted,
            text = "first",
            senderId = 1,
            recipientId = 2
        )
        val updatedMessage = Message(
            id = 5,
            dateTime = formatted,
            text = "UPDATED!!!",
            senderId = 1,
            recipientId = 2
        )

        // act
        chatService.addUserToData(vasya)
        chatService.addUserToData(lena)
        chatService.addMessage(message1)
        val result = chatService.editingMessage(updatedMessage)

        // assert
        assertFalse(result)
    }

    @Test
    fun getChatList() {
        // arrange
        val time: LocalDateTime = LocalDateTime.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        val formatted: String = time.format(formatter)
        val chatService = ChatService()
        val vasya = User(
            id = 1,
            firstName = "Leo",
            lastName = "Di Tolstoy"
        )
        val lena = User(
            id = 2,
            firstName = "Lena",
            lastName = "Berkova"
        )
        val message1 = Message(
            id = 1,
            dateTime = formatted,
            text = "first",
            senderId = 1,
            recipientId = 2
        )

        //act
        chatService.addUserToData(vasya)
        chatService.addUserToData(lena)
        chatService.addMessage(message1)
        val result = chatService.getChatList()

        // assert
        assertTrue(result.size == 1)
    }

    @Test
    fun getMessagesFromChat() {
        // arrange
        val time: LocalDateTime = LocalDateTime.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        val formatted: String = time.format(formatter)
        val chatService = ChatService()
        val vasya = User(
            id = 1,
            firstName = "Leo",
            lastName = "Di Tolstoy"
        )
        val lena = User(
            id = 2,
            firstName = "Lena",
            lastName = "Berkova"
        )
        val message1 = Message(
            id = 1,
            dateTime = formatted,
            text = "first",
            senderId = 1,
            recipientId = 2
        )
        val message2 = Message(
            id = 2,
            dateTime = formatted,
            text = "second",
            senderId = 1,
            recipientId = 2
        )

        //act
        chatService.addUserToData(vasya)
        chatService.addUserToData(lena)
        chatService.addMessage(message1)
        chatService.addMessage(message2)
        message2.markAsRead()
        val result = chatService.getMessagesFromChat(chatId = listOf(1, 2), 1, 1)

        // assert
        assertTrue(result.size == 1 && result[0].id == message2.id)
    }

    @Test
    fun getMessagesFromChat_IdError() {
        // arrange
        val time: LocalDateTime = LocalDateTime.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        val formatted: String = time.format(formatter)
        val chatService = ChatService()
        val vasya = User(
            id = 1,
            firstName = "Leo",
            lastName = "Di Tolstoy"
        )
        val lena = User(
            id = 2,
            firstName = "Lena",
            lastName = "Berkova"
        )
        val message1 = Message(
            id = 1,
            dateTime = formatted,
            text = "first",
            senderId = 1,
            recipientId = 2
        )
        val message2 = Message(
            id = 2,
            dateTime = formatted,
            text = "second",
            senderId = 1,
            recipientId = 2
        )

        //act
        chatService.addUserToData(vasya)
        chatService.addUserToData(lena)
        chatService.addMessage(message1)
        chatService.addMessage(message2)
        message2.markAsRead()
        val result = chatService.getMessagesFromChat(chatId = listOf(3, 1), 1, 1)

        // assert
        assertTrue(result.isEmpty())
    }

    @Test
    fun getUnreadChats() {
        // arrange
        val time: LocalDateTime = LocalDateTime.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        val formatted: String = time.format(formatter)
        val chatService = ChatService()
        val lena = User(
            id = 2,
            firstName = "Lena",
            lastName = "Berkova"
        )
        val jora = User(
            id = 3,
            firstName = "Giorgio",
            lastName = "Vkarmani"
        )
        val message8 = Message(
            dateTime = formatted,
            text = "eighth",
            senderId = 2,
            recipientId = 3
        )

        // act
        chatService.addUserToData(lena)
        chatService.addUserToData(jora)
        chatService.addMessage(message8)
        val result = chatService.getUnreadChats(3)

        // assert
        assertTrue(result == 1)
    }
}