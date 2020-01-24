package pizza.summersolutions.whattodo.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import pizza.summersolutions.whattodo.Database.Repository

class MainActivityViewModel(application: Application): AndroidViewModel(application) {
    private val repository = Repository(application.applicationContext)

    val tasks = repository.getAllTask()

    val subtasks= repository.getAllSubttasks()

    val categories= repository.getAllCategory()
}