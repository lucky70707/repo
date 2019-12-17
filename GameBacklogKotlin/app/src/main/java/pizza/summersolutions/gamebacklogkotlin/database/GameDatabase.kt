package pizza.summersolutions.gamebacklogkotlin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pizza.summersolutions.gamebacklogkotlin.models.Game

@Database(entities= [Game::class],version =1, exportSchema = false)
abstract class GameDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao

    companion object{
        private const val DATABASE_NAME = "GAME_DATABASE"

        @Volatile
        private var gameDatabaseInstance: GameDatabase? = null

        fun getDatabase(context: Context): GameDatabase? {
            if(gameDatabaseInstance == null){
                synchronized(GameDatabase::class.java){
                    if(gameDatabaseInstance==null){
                        gameDatabaseInstance = Room.databaseBuilder(
                            context.applicationContext,
                            GameDatabase::class.java,
                            DATABASE_NAME
                        )
                            .allowMainThreadQueries()
                            .build()
                    }
                }
            }
            return gameDatabaseInstance
        }
    }
}