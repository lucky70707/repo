package pizza.summersolutions.whattodo.Database

import androidx.lifecycle.LiveData
import androidx.room.*
import pizza.summersolutions.whattodo.Models.Task

@Dao
interface TaskDao {
    @Query("Select * FROM TaskTable")
    fun getAllTasks(): LiveData<List<Task?>>

    @Query("Select * FROM subtasktable where categoryId = :categoryId")
    fun getTasksByCategory(categoryId:Int): LiveData<List<Task?>>

    @Insert
    fun insertTask(task: Task)

    @Delete
    fun deleteTask(task: Task)

    @Update
    fun updateTask(task: Task)

    @Query("Delete FROM TaskTable")
    fun deleteAllTasks()
}