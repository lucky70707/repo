package pizza.summersolutions.popularmovieskotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item.view.*
import pizza.summersolutions.popularmovieskotlin.Models.Movie

class  MovieAdapter(private var movies: List<Movie>, private val onClick: (Movie)->Unit):
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType :  Int): ViewHolder{
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        )
    }
    override fun getItemCount(): Int {
        return movies.size
    }
    override fun onBindViewHolder(holder : ViewHolder, position: Int){
        return holder.bind(movies[position])
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init{
            itemView.setOnClickListener{onClick(movies[adapterPosition])}
        }
        fun bind(movie: Movie){
            var position = adapterPosition
            itemView.tVPosterIndex.text = (position+1).toString()
            Glide.with(context).load(movie.getPosterUrl()).into(itemView.iVPoster2)
        }
    }}
