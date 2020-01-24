package pizza.summersolutions.whattodo.Models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName ="TaskTable")
data class Task(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var deadline: Date,
    var difficulty: Int,
    var isCompleted: Boolean,
    var categoryId: Int

    ) : Parcelable