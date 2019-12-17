package pizza.summersolutions.gamebacklogkotlin.UI

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pizza.summersolutions.gamebacklogkotlin.database.GameRepository
import pizza.summersolutions.gamebacklogkotlin.models.Game

class GameViewModel(application : Application): AndroidViewModel(application) {
    private val ioScope = CoroutineScope(Dispatchers.IO)
    private val gameRepository = GameRepository(application.applicationContext)
    private lateinit var undoGames:  LiveData<List<Game>>

    val games : LiveData<List<Game>> = gameRepository.getAllGames()

    fun insertGame(game: Game){
        ioScope.launch {
            gameRepository.insertGame(game)
        }
    }

    fun deleteGame(game: Game){
        ioScope.launch {
            gameRepository.deleteGame(game)
        }
    }

    fun deleteAllGames(){
        undoGames = games
        ioScope.launch {
            gameRepository.deleteAllGames()
        }
    }

    fun undo(){


    }




}