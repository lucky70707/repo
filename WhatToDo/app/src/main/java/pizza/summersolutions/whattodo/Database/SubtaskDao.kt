package pizza.summersolutions.whattodo.Database

import androidx.lifecycle.LiveData
import androidx.room.*
import pizza.summersolutions.whattodo.Models.Subtask

@Dao
interface SubtaskDao {

    @Query("Select * FROM SubtaskTable")
    fun getAllSubtasks(): LiveData<List<Subtask?>>

    @Query("Select * FROM subtasktable where categoryId = :categoryId")
    fun getSubtasksByCategory(categoryId:Int): LiveData<List<Subtask?>>

    @Insert
    fun insertSubtask(subtask: Subtask)

    @Delete
    fun deleteSubtask(subtask: Subtask)

    @Update
    fun updateSubtask(subtask: Subtask)

    @Query("Delete FROM SubtaskTable")
    fun deleteAllSubtasks()
}