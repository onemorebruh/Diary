package pet.onemorebruh.diary.database

import androidx.lifecycle.LiveData

class MessageRepository(private val messageDAO: MessageDAO) {
    val allMessages: LiveData<List<Message>> = messageDAO.getMessages()

    suspend fun insertMessage(message: Message) {
        messageDAO.insert(message)
    }
}