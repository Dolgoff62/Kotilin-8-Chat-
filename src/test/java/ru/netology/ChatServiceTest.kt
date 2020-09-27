package ru.netology

import org.junit.Test

import org.junit.Assert.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ChatServiceTest {

    @Test
    fun addUserToData() {
        // arrange
        val lena = User(
            id = 2,
            firstName = "Lena",
            lastName = "Berkova",
            emptyList(),
            emptyList()
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
            lastName = "Berkova",
            emptyList(),
            emptyList()
        )
        val anotherLena = User(
            id = 2,
            firstName = "Lena",
            lastName = "Berkova",
            emptyList(),
            emptyList()
        )
        val chatService = ChatService()

        // act
        chatService.addUserToData(lena)
        val result = chatService.addUserToData(anotherLena)

        // assert
        assertFalse(result)
    }

    @Test
    fun createChat() {
        // arrange
        val time: LocalDateTime = LocalDateTime.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        val formatted: String = time.format(formatter)
        val chatService = ChatService()
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
        val message1 = Message(
                dateTime = formatted,
                text = "first",
                senderId = 1,
                recipientId = 2
        )

        //act
        chatService.addUserToData(vasya)
        chatService.addUserToData(lena)
        val result = chatService.createChat(message1)

        //assert
        assertEquals(result,1)
    }

    @Test
    fun createChat_SecondChat() {
        // arrange
        val time: LocalDateTime = LocalDateTime.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        val formatted: String = time.format(formatter)
        val chatService = ChatService()
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
                recipientId = 3
        )

        //act
        chatService.addUserToData(vasya)
        chatService.addUserToData(lena)
        chatService.addUserToData(jora)
        chatService.createChat(message1)
        val result = chatService.createChat(message3)

        //assert
        assertEquals(result,2)
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
        chatService.createChat(message1)
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
        chatService.createChat(message1)
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
        val message1 = Message(
                dateTime = formatted,
                text = "first",
                senderId = 1,
                recipientId = 2
        )

        //act
        chatService.addUserToData(vasya)
        chatService.addUserToData(lena)
        chatService.createChat(message1)
        val chatKey = listOf<Int>(1, 2)
        val result = chatService.deleteChatById(chatKey)

        //assert
        assertTrue(result)
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
        chatService.createChat(message1)
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
        chatService.createChat(message1)
        val result = chatService.editingMessage(updatedMessage)

        // assert
        assertFalse(result)
    }

    @Test
    fun getChats() {
    }

    @Test
    fun getMessagesFromChat() {
    }

    @Test
    fun getUnreadChats() {
    }
}