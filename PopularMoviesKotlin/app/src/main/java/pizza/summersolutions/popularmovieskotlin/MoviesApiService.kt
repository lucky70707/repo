package pizza.summersolutions.popularmovieskotlin

import pizza.summersolutions.popularmovieskotlin.Models.Results
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

public interface MoviesApiService {
    @GET("movie?api_key=5594a89abcc1d72c9754d36bc3ce1dd0&language=en-US&sort_by=popularity.desc&include_adult=true&include_video=false")
    fun getMoviesInYear(@Query("primary_release_year")year : Int): Call<Results>


}