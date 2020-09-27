package ru.netology

class PrintInformation {
    private val chatService = ChatService()


    fun printChats() {
        println("Список чатов:")
        chatService.getChats().forEach { (key: Int, value: MutableList<Message>) ->
            println("$key  $value")
        }
    }

}