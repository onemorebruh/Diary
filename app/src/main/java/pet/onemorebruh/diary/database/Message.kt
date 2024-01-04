package pet.onemorebruh.diary.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")// it should be named as message but i have used it too much time to refactor right now
data class Message(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val text: String,
    val time: String,
    val image: ByteArray?,
    val isHidden: Boolean = false
) {
    //It was recommended to override because of ByteArray
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Message

        if (id != other.id) return false
        if (text != other.text) return false
        if (time != other.time) return false
        if (!image.contentEquals(other.image)) return false
        return isHidden == other.isHidden
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + text.hashCode()
        result = 31 * result + time.hashCode()
        result = 31 * result + image.contentHashCode()
        result = 31 * result + isHidden.hashCode()
        return result
    }
}