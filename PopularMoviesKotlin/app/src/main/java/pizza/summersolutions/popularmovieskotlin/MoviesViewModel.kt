package pizza.summersolutions.popularmovieskotlin


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import pizza.summersolutions.popularmovieskotlin.Models.Movie
import pizza.summersolutions.popularmovieskotlin.Models.Results
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesViewModel (application: Application): AndroidViewModel(application){
    private val moviesRepository = MoviesRepository()
    val movie = MutableLiveData<List<Movie>>()
    val error = MutableLiveData<String>()

    fun getMovies(year: Int){//check 1
        moviesRepository.getMovies(year).enqueue(object: Callback<Results> {
            override fun onFailure(call: Call<Results>, t: Throwable) {
                error.value = t.message
                }

            override fun onResponse(call: Call<Results>, response: Response<Results>) {
                if(response.isSuccessful){
                    movie.apply {value = response.body()?.results}
                }
                else error.value = "An error Occured: ${response.errorBody().toString()}"
                }

        })
    }


}
