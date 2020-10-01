package ru.netology


class Message(
    val id: Int = 0,
    private var dateTime: String,
    private var text: String?,
    private var readStatus: Boolean = false,
    val senderId: Int,
    val recipientId: Int
) {

    fun cloneWithId(newId: Int): Message {
        return Message(
            id = newId,
            dateTime = dateTime,
            text = text,
            readStatus = false,
            senderId = senderId,
            recipientId = recipientId
        )
    }

    fun update(updated: Message) {
        dateTime = updated.dateTime
        text = updated.text
        readStatus = true
    }

    fun isRead(): Boolean {
        return readStatus
    }

    fun markAsRead() {
        readStatus = true
    }

    override fun toString(): String {
        return "(Id=$id, Text=$text, senderId=$senderId, recipientId=$recipientId readStatus=$readStatus)"
    }
}