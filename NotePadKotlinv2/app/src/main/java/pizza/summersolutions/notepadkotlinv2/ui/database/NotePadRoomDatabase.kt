package pizza.summersolutions.notepadkotlinv2.ui.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pizza.summersolutions.notepadkotlinv2.models.Note
import java.util.*

@Database(entities = [Note::class], version=1,exportSchema = false)
@TypeConverters(Converters::class)
abstract class NotePadRoomDatabase : RoomDatabase() {

    abstract fun noteDao() : NoteDao

    companion object {
        private const val DATABASE_NAME = "NOTEPAD_DATABASE"

        @Volatile
        private var INSTANCE: NotePadRoomDatabase? = null

        fun getDatabase(context: Context): NotePadRoomDatabase?{
            if (INSTANCE ==null){
                synchronized(NotePadRoomDatabase::class.java){
                    if (INSTANCE==null){
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            NotePadRoomDatabase::class.java,
                            DATABASE_NAME
                        )
                            .fallbackToDestructiveMigration()
                            .addCallback(object: RoomDatabase.Callback(){
                                    override fun onCreate(db: SupportSQLiteDatabase) {
                                        super.onCreate(db)
                                        INSTANCE?.let{database ->
                                            CoroutineScope(Dispatchers.IO).launch{
                                                database.noteDao().insertNote(Note("Title", Date(), "",0))}
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