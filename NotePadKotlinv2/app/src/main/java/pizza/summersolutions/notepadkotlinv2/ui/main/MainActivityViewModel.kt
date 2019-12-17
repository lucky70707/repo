package pizza.summersolutions.notepadkotlinv2.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import pizza.summersolutions.notepadkotlinv2.ui.database.NoteRepository

class MainActivityViewModel (application: Application) : AndroidViewModel(application) {
    private val noteRepository =    NoteRepository(application.applicationContext)

    val note = noteRepository.getNotepad()
}