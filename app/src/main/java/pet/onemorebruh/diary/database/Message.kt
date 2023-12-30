package pet.onemorebruh.diary.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp

@Entity(tableName = "Messages")
data class Message(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val text: String,
    val time: Timestamp
)