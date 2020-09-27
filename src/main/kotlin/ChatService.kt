package ru.netology

class ChatService {
    private var chats = mutableMapOf<List<Int>, MutableList<Message>>()
    private var usersData = mutableListOf<User>()
    private var lastId = 1

    fun addUserToData(user: User): Boolean{
        if (usersData.contains(user)) {
            println("Пользователь с таким Id уже существует!!")
            return false
        } else {
            usersData.plusAssign(user)
            return true
        }
    }

    fun createChat(message: Message) : Int {
        val key: List<Int> = listOf(message.senderId, message.recipientId)
        val newMessage = message.copy(id = lastId++)

        if (!chats.containsKey(key) && !chats.containsKey(key.reversed())) {
            chats[key] = mutableListOf(newMessage)
        } else {
            chats.forEach { (k, v) ->
                if (k.contains(message.senderId) && k.contains(message.recipientId)) {
                    chats[k] = v.plusElement(newMessage) as MutableList<Message>
                }
            }
        }
        return chats.size
    }

    fun deleteMessage(messageId: Int) : Boolean {
        chats.forEach { (key: List<Int>, value: MutableList<Message>) ->
            value.forEach { message: Message ->
                if (message.id == messageId) {
                    val n = value.filterNot { it.id == messageId } as MutableList
                    chats[key] = n
                } else {
                    println("Сообщения с Id= $messageId не найдено!!")
                    return false
                }
            }
        }
        val iterator = chats.iterator()
        iterator.forEach {
            if (it.value.isEmpty()) {
                iterator.remove()
            }
        }
       return true
    }

    fun deleteChatById(chatId: List<Int>) : Boolean {
        val iterator = chats.iterator()
        iterator.forEach {
            if (it.key == chatId) {
                iterator.remove()
            }
        }
        return true
    }

    fun editingMessage(updatedMessage: Message) : Boolean {
        chats.forEach { (_: List<Int>, value: MutableList<Message>) ->
            value.forEach { message: Message ->
                if (message.id == updatedMessage.id) {
                    val newMessage = message.copy(
                            dateTime = updatedMessage.dateTime,
                            text = updatedMessage.text,
                            readStatus = true
                    )
                    value[value.indexOf(message)] = newMessage
                } else {
                    println("Сообщения с Id= ${updatedMessage.id} не найдено!!")
                    return false
                }
            }
        }
        return true
    }

    fun getChats() : MutableMap<Int, MutableList<Message>> {
        var chatList = mutableMapOf<Int, MutableList<Message>>()
        var key = 1
        for ((k, v) in chats) {
            chatList.put(key, v)
            key += 1
        }
       return chatList
    }

    fun getMessagesFromChat(chatId: List<Int>, lastMessageId: Int, numberOfMessages: Int) {
        chats.forEach { (key: List<Int>, value: List<Message>) ->
            if (key == chatId) {
                println("Список сообщений чата ${key[0]}-${key[1]}:")
                val filteredListOfMessages =
                        value.filter { it.id >= lastMessageId }.subList(0, numberOfMessages)

                filteredListOfMessages.forEach { message ->
                    value[value.indexOf(message)] = message.copy(readStatus = true)
                }
                println("$filteredListOfMessages")
            }
        }
    }

    fun getUnreadChats(userId: Int) {
        var unreadChatCount = 0

        chats.forEach { (key, value) ->
            if (key.contains(userId)) {
                val newList = value.filter { it.recipientId == userId && !it.readStatus }
                if (newList.any { !it.readStatus }) {
                    unreadChatCount += 1
                }
            }
        }
        println("Количество непрочитанных чатов пользователя: $unreadChatCount")
    }
}

