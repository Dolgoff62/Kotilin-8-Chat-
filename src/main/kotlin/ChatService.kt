package ru.netology

class ChatService {

    private var chats: MutableMap<List<Int>, MutableList<Message>> = mutableMapOf()
    private var usersData = mutableListOf<User>()
    private var lastId = 1

    fun addUserToData(user: User): Boolean {
        return if (usersData.contains(user)) {
            println("Пользователь с таким Id уже существует!!")
            false
        } else {
            usersData.plusAssign(user)
            true
        }
    }

    fun addMessage(message: Message): Int? {
        val key: List<Int> = listOf(message.senderId, message.recipientId)
        val newMessage = message.cloneWithId(lastId++)

        chats.forEach { (k, v) ->
            if (k.contains(message.senderId) && k.contains(message.recipientId)) {
                chats[k] = v.plusElement(newMessage) as MutableList<Message>
                return chats[k]?.size
            }
        }

        chats[key] = mutableListOf(newMessage)
        return chats[key]?.size
    }

    fun deleteMessage(messageId: Int): Boolean {
        val iterator = chats.iterator()
        iterator.forEach { entry ->
            if (entry.value.removeAll { it.id == messageId }) {
                if (entry.value.isEmpty()) {
                    iterator.remove()
                }
                return true
            }
        }
        return false
    }

    fun deleteChatById(chatId: List<Int>): Boolean {
        val iterator = chats.iterator()
        iterator.forEach {
            if (it.key == chatId) {
                iterator.remove()
                return true
            }
        }
        println("Чат с данным Id не найден!!")
        return false
    }

    fun editingMessage(updatedMessage: Message): Boolean {
        chats.forEach { (_: List<Int>, value: MutableList<Message>) ->
            value.forEach { message: Message ->
                if (message.id == updatedMessage.id) {
                    message.update(updatedMessage)
                    return true
                }
            }
        }
        println("Сообщения с таким ID не найдено!!")
        return false
    }

    fun getChatList(): Map<List<Int>, MutableList<Message>> {
        return chats
    }

    fun getMessagesFromChat(chatId: List<Int>, lastMessageId: Int, numberOfMessages: Int): List<Message> {
        if (!chats.containsKey(chatId)) {
            println("Чат ID не найден!!")
            return emptyList()
        }

        val allMessageList = chats[chatId]!!
        val messages = allMessageList.asSequence()
            .filter { it.id > lastMessageId }
            .take(numberOfMessages)
            .toList()

        messages.forEach { message ->
            message.markAsRead()
        }

        return messages
    }

    fun getUnreadChats(userId: Int): Int {

        return chats.asSequence()
            .filter { entry ->
                entry.key.contains(userId) && entry.value.any { !it.isRead() && it.recipientId == userId }
            }
            .count()
    }
}

