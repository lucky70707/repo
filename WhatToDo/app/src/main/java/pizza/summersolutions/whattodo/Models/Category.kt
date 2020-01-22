package pizza.summersolutions.whattodo.Models

import android.os.Parcelable
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
class Category (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var iconPath: String

): Parcelable