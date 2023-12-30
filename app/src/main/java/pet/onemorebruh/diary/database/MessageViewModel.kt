package pet.onemorebruh.diary.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MessageViewModel(application: Application): AndroidViewModel(application) {

    private val messageDAO = Database.getDatabese(application)!!.MessageDAO()
    private val repository: MessageRepository = MessageRepository(messageDAO)
    val allMessages: LiveData<List<Message>> =  repository.allMessages

    fun insertMessage(message: Message){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertMessage(message)
        }
    }

}