package pizza.summersolutions.popularmovieskotlin.Models


import com.google.gson.annotations.SerializedName


data class Results(
    @SerializedName("results") var results: List<Movie>
)