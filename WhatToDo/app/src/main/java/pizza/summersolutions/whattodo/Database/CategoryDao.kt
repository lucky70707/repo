package pizza.summersolutions.whattodo.Database

import androidx.lifecycle.LiveData
import androidx.room.*
import pizza.summersolutions.whattodo.Models.Category

@Dao
interface CategoryDao {
    @Query("Select * FROM CategoryTable")
    fun getAllCategory(): LiveData<List<Category?>>

    @Insert
    fun insertCategory(category: Category)

    @Delete
    fun deleteCategory(category: Category)

    @Update
    fun updateCategory(category: Category)

    @Query("Delete FROM CategoryTable")
    fun deleteAllCategory()

}