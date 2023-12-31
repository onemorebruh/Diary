package pet.onemorebruh.diary.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database( entities = [Message::class], version = 1)
abstract class Database: RoomDatabase() {
    abstract fun MessageDAO(): MessageDAO

    companion object{
        @Volatile
        private var INSTANCE: pet.onemorebruh.diary.database.Database? = null

        fun getDatabase(context: Context): pet.onemorebruh.diary.database.Database {
            val temporaryInstance = INSTANCE
            if (temporaryInstance != null){
                return temporaryInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext, pet.onemorebruh.diary.database.Database::class.java, "database")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}