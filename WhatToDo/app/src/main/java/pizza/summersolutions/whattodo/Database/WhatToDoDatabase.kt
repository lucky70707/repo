package pizza.summersolutions.whattodo.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pizza.summersolutions.whattodo.Models.*
import java.util.*


@Database(entities = [Subtask::class, Task::class,Category::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class WhatToDoDatabase : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao
    abstract fun subtaskDao(): SubtaskDao
    abstract  fun taskDao(): TaskDao

    companion object {
        private const val DATABASE_NAME = "DATABASE"

        @Volatile
        private var INSTANCE: WhatToDoDatabase? = null

        fun getDatabase(context: Context): WhatToDoDatabase? {
            if (INSTANCE == null) {
                synchronized(Database::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            WhatToDoDatabase::class.java, DATABASE_NAME
                        )
                            .addCallback(object: RoomDatabase.Callback(){
                                override fun onCreate(db: SupportSQLiteDatabase){
                                    INSTANCE?.let{database ->
                                        CoroutineScope(Dispatchers.IO).launch {
                                            database.categoryDao().insertCategory(Category(0,"Health",""))
                                            database.categoryDao().insertCategory(Category(0,"Sports",""))
                                            database.categoryDao().insertCategory(Category(0,"Work",""))
                                            database.categoryDao().insertCategory(Category(0,"Study",""))
                                            database.categoryDao().insertCategory(Category(0,"Miscellaneous",""))


                                        }
                                    }
                                }
                            }
                            )
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }

}
