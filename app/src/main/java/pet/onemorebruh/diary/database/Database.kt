package pet.onemorebruh.diary.database

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database( entities = [Message::class], version = 2,
    autoMigrations = [
        AutoMigration(from = 1, to = 2)
    ]) //
abstract class Database: RoomDatabase() {
    abstract fun MessageDAO(): MessageDAO

    companion object{
        @Volatile
        private var INSTANCE: pet.onemorebruh.diary.database.Database? = null

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                //init cursor
                val cursor = database.query("SELECT * FROM `messages`")

                // get data and migrate
                cursor.moveToFirst()
                while (!cursor.isAfterLast){
                    val id_index = cursor.getColumnIndex("id")// it is the way it works. it wouldn't work if i write it in one line
                    val id = cursor.getInt(id_index)

                    val text_index = cursor.getColumnIndex("text")// it is the way it works. it wouldn't work if i write it in one line
                    val text = cursor.getString(id_index)

                    val time_index = cursor.getColumnIndex("time")// it is the way it works. it wouldn't work if i write it in one line
                    val time = cursor.getString(id_index)

                    //paste default values and move next
                    database.execSQL("""UPDATE messages SET image = NULL, isHidden = false WHERE id = $id""")
                    cursor.moveToNext()
                }
            }
        }

        fun getDatabase(context: Context): pet.onemorebruh.diary.database.Database {
            val temporaryInstance = INSTANCE
            if (temporaryInstance != null){
                return temporaryInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext, pet.onemorebruh.diary.database.Database::class.java, "database")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}