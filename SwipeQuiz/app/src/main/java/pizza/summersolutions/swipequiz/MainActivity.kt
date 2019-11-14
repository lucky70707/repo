package pizza.summersolutions.swipequiz


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val quizQuestions = arrayListOf<QuizQuestion>()
    private val quizAdapter = QuizAdapter(quizQuestions)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        // use snackbar to give feedback to user, aka wrong answer right answer.


    }
    private fun createItemTouchHelper(): ItemTouchHelper{
        val callback= object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean{
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                var givenAnswer : Boolean
                var message: String

                givenAnswer = direction ==1

                if(quizQuestions[position].isTrue==givenAnswer){
                     message= "Correct! the answer was: "+quizQuestions[position]

                    Snackbar.make(findViewById(R.id.mainLayout),message, Snackbar.LENGTH_SHORT).show()

                }else{
                    message = "Incorrect! the answer was: "+quizQuestions[position]
                    Snackbar.make(findViewById(R.id.mainLayout),message,Snackbar.LENGTH_SHORT).show()


                }

                quizAdapter.notifyItemChanged(viewHolder.adapterPosition)
            }
        }
        return ItemTouchHelper(callback)
    }
    private fun initViews(){
        swipequizRV.layoutManager = LinearLayoutManager(this)
        swipequizRV.adapter = quizAdapter

        for(i in QuizQuestion.QUESTIONS.indices){
            quizQuestions.add(QuizQuestion(QuizQuestion.QUESTIONS[i],
                QuizQuestion.ANSWERS[i]))
        }
        quizAdapter.notifyDataSetChanged()
        createItemTouchHelper().attachToRecyclerView(swipequizRV)

    }
}
