package pizza.summersolutions.popularmovieskotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*
import pizza.summersolutions.popularmovieskotlin.Models.Movie

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initViews()
    }

    private fun initViews() {
        val movie = intent.extras?.getParcelable<Movie>(MOVIE)
        tVDescription.text = movie?.description
        tVRating.text = movie?.rating
        tVReleasedate.text = movie?.releaseDate
        tVTitle.text = movie?.title
        Glide.with(this).load(movie?.getPosterUrl()).into(iVPoster2)
        Glide.with(this).load(movie?.getDropUrl()).into(iVBackdrop)
    }
    companion object{
        const val MOVIE = "MOVIE"
    }
}
