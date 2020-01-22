package pizza.summersolutions.popularmovieskotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import pizza.summersolutions.popularmovieskotlin.Models.Movie
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity() {
    /*
    val baseImageUrl="https://image.tmdb.org/t/p/w500/"

    val request = "https://api.themoviedb.org/3/discover/movie?api_key=5594a89abcc1d72c9754d36bc3ce1dd0&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&year=2000"

    val baseUrl ="https://api.themoviedb.org"


   var myInterface = moviesApi.create(MoviesApiService::class.java)*/

    //val year: Int = 2000


    private lateinit var viewModel: MoviesViewModel

    private val movies = arrayListOf<Movie>()
    private val movieAdapter = MovieAdapter(movies) { movie ->  onClick(movie)}

    private fun onClick(movie: Movie) {
        val intent = Intent( this,DetailActivity::class.java)
        intent.putExtra(DetailActivity.MOVIE, movie)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initViewModel()
    }

    private fun initViewModel() {
       viewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)

        viewModel.movie.observe(this, Observer {
            this@MainActivity.movies.clear()
            this@MainActivity.movies.addAll(it)
            movieAdapter.notifyDataSetChanged()
        })

        viewModel.error.observe(this, Observer {
            Snackbar.make(rVMovies,"An error has occured: $it", Snackbar.LENGTH_LONG).show()
        })
    }

    private fun initViews() {

        btnSubmit.setOnClickListener{
            val year = eTYear.text.toString()
            loadMovies(parseInt(year))
            btnSubmit.setOnClickListener{

                loadMovies(parseInt(eTYear.text.toString()))
            }
        }

        rVMovies.adapter = movieAdapter
        rVMovies.layoutManager= GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false)


    }

    private fun loadMovies(year: Int) {
        viewModel.getMovies(year)
    }
}
