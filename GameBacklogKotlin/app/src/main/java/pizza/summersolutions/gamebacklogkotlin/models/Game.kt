package pizza.summersolutions.gamebacklogkotlin.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "GameTable")
data class Game(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title : String,
    var platforms : String,
    var day: Int,
    var month: Int,
    var year: Int
):Parcelable