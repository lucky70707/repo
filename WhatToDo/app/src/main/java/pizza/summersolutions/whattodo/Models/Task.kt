package pizza.summersolutions.whattodo.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Task(
    var id: Int,
    var name: String

) : Parcelable