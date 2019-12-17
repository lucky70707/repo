package pizza.summersolutions.notepadkotlinv2.ui.database

import android.content.Context
import androidx.lifecycle.LiveData
import pizza.summersolutions.notepadkotlinv2.models.Note

class NoteRepository(context: Context) {
    private  val noteDao: NoteDao

    init{
        val database = NotePadRoomDatabase.getDatabase(context)
        noteDao = database!!.noteDao()
    }

    fun getNotepad(): LiveData<Note?>{
        return noteDao.getNotepad()
    }

    suspend fun updateNotePad(note: Note){
        noteDao.updateNote(note)
    }
}