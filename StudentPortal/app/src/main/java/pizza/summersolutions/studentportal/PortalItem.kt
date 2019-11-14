package pizza.summersolutions.studentportal

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PortalItem (var title:String, var uri:String):Parcelable