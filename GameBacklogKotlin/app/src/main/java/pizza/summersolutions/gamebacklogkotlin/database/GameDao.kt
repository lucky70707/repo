package pizza.summersolutions.gamebacklogkotlin.database

import androidx.lifecycle.LiveData
import androidx.room.*
import pizza.summersolutions.gamebacklogkotlin.models.Game

@Dao
interface GameDao{
    @Query("SELECT * FROM gametable ORDER BY year DESC, month DESC, day DESC")
    fun getAllGames(): LiveData<List<Game>>

    @Insert
    fun insertGame(game: Game)

    @Delete
    suspend fun deleteGame(game: Game)

    @Update suspend fun updateGame(game: Game)

    @Query("DELETE FROM gametable")
    suspend fun deleteAllGames()
}