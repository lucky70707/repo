package pizza.summersolutions.popularmovieskotlin.Models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (
    @SerializedName("title") var title: String,
    @SerializedName("poster_path") var posterPath: String,
    @SerializedName("overview") var description: String,
    @SerializedName("vote_average") var rating:String,
    @SerializedName("release_date") var releaseDate:String,
    @SerializedName("backdrop_path") var backdropPath:String
) : Parcelable {
    fun getPosterUrl() = "https://image.tmdb.org/t/p/w500$posterPath"
    fun getDropUrl()= "https://image.tmdb.org/t/p/w500$backdropPath"
}


