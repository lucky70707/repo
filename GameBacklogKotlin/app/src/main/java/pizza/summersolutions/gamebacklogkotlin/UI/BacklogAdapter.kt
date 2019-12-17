package pizza.summersolutions.gamebacklogkotlin.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*
import pizza.summersolutions.gamebacklogkotlin.R
import pizza.summersolutions.gamebacklogkotlin.models.Game
import java.lang.StringBuilder

class BacklogAdapter(val games : ArrayList<Game>) :  RecyclerView.Adapter<BacklogAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        return ViewHolder (LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false))

    }

    override fun getItemCount(): Int {
       return games.size
    }

    override fun onBindViewHolder(holder: BacklogAdapter.ViewHolder, position: Int) =holder.bind(games[position])

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        fun bind(game:Game){
            itemView.tVTitle.text = game.title
            itemView.tVPlatform.text = game.platforms
            var sb : StringBuilder = StringBuilder("Release: "+ game.day )
            when (game.month){
                1 -> sb.append(" January ")
                2->sb.append(" February ")
                3->sb.append( " March ")
                4->sb.append( " April ")
                5->sb.append(" May ")
                6->sb.append(" June ")
                7->sb.append(" July ")
                8->sb.append(" August ")
                9->sb.append(" September ")
                10->sb.append(" October ")
                11 -> sb.append(" November ")
                12 -> sb.append(" December ")
            }
            sb.append(game.year)

            itemView.tVDate.text = sb.toString()
        }
    }

}