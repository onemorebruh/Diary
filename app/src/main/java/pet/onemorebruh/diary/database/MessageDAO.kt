package pet.onemorebruh.diary.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MessageDAO {

    @Query("SELECT * FROM messages")
    fun getMessages(): LiveData<List<Message>>

    @Insert
    suspend fun insert(vararg : Message)

    
}