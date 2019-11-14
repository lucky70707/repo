package pizza.summersolutions.swipequiz

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_question.view.*

class QuizAdapter(private val quizQuestions: List<QuizQuestion>) :
    RecyclerView.Adapter<QuizAdapter.ViewHolder>() {
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_question, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return quizQuestions.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(quizQuestions[position])
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(quizQuestion: QuizQuestion) {
            itemView.tvQuestion.text = quizQuestion.question

        }
    }
}
