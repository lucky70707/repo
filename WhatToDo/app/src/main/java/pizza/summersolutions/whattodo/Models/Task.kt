package pizza.summersolutions.whattodo.Models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.time.LocalDate
import java.util.*

@Parcelize
@Entity(tableName ="TaskTable")
data class Task(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var deadline: LocalDate?,
    var difficulty: Int,
    var isCompleted: Boolean,
    var dateCompleted: LocalDate?,
    var categoryId: Int

    ) : Parcelable