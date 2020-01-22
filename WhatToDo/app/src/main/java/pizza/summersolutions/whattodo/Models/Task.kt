package pizza.summersolutions.whattodo.Models

import android.os.Parcelable
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Task(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var deadline: Date,
    var difficulty: Int,
    var categoryId: Int

    ) : Parcelable