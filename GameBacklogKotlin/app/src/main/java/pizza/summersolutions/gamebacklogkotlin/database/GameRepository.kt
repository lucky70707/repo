package pizza.summersolutions.gamebacklogkotlin.database

import android.content.Context
import androidx.lifecycle.LiveData
import pizza.summersolutions.gamebacklogkotlin.models.Game

public class GameRepository(context: Context) {
    private var gameDao:GameDao

    init{
        val gameDatabase = GameDatabase.getDatabase(context)
        gameDao =  gameDatabase!!.gameDao()
    }

    fun getAllGames() : LiveData<List<Game>>{
        return gameDao.getAllGames()
    }

    fun insertGame(game: Game){
        gameDao.insertGame(game)
    }

    suspend fun deleteGame(game: Game){
        gameDao.deleteGame(game)
    }

    suspend fun updateGame(game: Game){
        gameDao.updateGame(game)
    }

    suspend fun deleteAllGames(){
        gameDao.deleteAllGames()
    }
}