package pizza.summersolutions.whattodo.Database

import android.content.Context
import androidx.lifecycle.LiveData
import pizza.summersolutions.whattodo.Models.Category
import pizza.summersolutions.whattodo.Models.Subtask
import pizza.summersolutions.whattodo.Models.Task

class Repository(context: Context) {
    private val categoryDao: CategoryDao
    private val taskDao: TaskDao
    private val subtaskDao: SubtaskDao

    init {
        val database = WhatToDoDatabase.getDatabase(context)
        categoryDao = database!!.categoryDao()
        subtaskDao = database!!.subtaskDao()
        taskDao = database!!.taskDao()
    }

    //Category queries
    fun getAllCategory(): LiveData<List<Category?>> {
        return categoryDao.getAllCategory()
    }

    fun insertCategory(category: Category) {
        categoryDao.insertCategory(category)
    }

    fun deleteCategory(category: Category) {
        categoryDao.deleteCategory(category)
    }


    fun updateCategory(category: Category) {
        categoryDao.updateCategory(category)
    }


    fun deleteAllCategory() {
        categoryDao.deleteAllCategory()
    }

    //Subtask Queries
    fun getAllSubttasks(): LiveData<List<Subtask?>> {
        return subtaskDao.getAllSubtasks()
    }

    fun getSubtaskByCategory(categoryId: Int): LiveData<List<Subtask?>> {
        return subtaskDao.getSubtasksByCategory(categoryId)
    }


    fun insertSubtask(subtask: Subtask) {
        subtaskDao.insertSubtask(subtask)
    }

    fun deleteSubtask(subtask: Subtask) {
        subtaskDao.deleteSubtask(subtask)

    }

    fun updateSubtask(subtask: Subtask) {
        subtaskDao.updateSubtask(subtask)
    }


    fun deleteAllSubtasks() {
        subtaskDao.deleteAllSubtasks()
    }

    //Task Queries
    fun getAllTask(): LiveData<List<Task?>> {
        return taskDao.getAllTasks()
    }

    fun getTaskByCategory(categoryId: Int): LiveData<List<Task?>> {
        return taskDao.getTasksByCategory(categoryId)
    }


    fun insertTask(task: Task){
        taskDao.insertTask(task)
    }


    fun deleteTask(task: Task){
        taskDao.deleteTask(task)
    }


    fun updateTask(task: Task){
        taskDao.updateTask(task)
    }


    fun deleteAllTasks(){
        taskDao.deleteAllTasks()
    }

}