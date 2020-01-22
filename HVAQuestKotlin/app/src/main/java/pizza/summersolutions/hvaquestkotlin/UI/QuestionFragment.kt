package pizza.summersolutions.hvaquestkotlin.UI


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_question.*
import kotlinx.android.synthetic.main.fragment_winning.*

import pizza.summersolutions.hvaquestkotlin.R

/**
 * A simple [Fragment] subclass.
 */
class QuestionFragment : Fragment() {
    private var questRepository = QuestRepository()
    private val questions = questRepository.getHvaQuest()
    private val arguments: QuestionFragmentArgs by navArgs()
    private var answerChosen =""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

        }


    private fun initViews() {
        btnNextloc.isEnabled=false
        val nextIndex= arguments.QuestionCount + 1
        tVQuestion.text = questions[arguments.QuestionCount].question
        tVQuestionCount.text = "${nextIndex}/10"
        rBQuestion1.text=questions[arguments.QuestionCount].choices[0]
        rBQuestion2.text=questions[arguments.QuestionCount].choices[1]
        rBQuestion3.text=questions[arguments.QuestionCount].choices[2]

        btnNextloc.setOnClickListener{
            if (btnNextloc.isEnabled){
                val action = QuestionFragmentDirections.actionQuestionFragmentToLocationFragment(nextIndex,questions[arguments.QuestionCount].clue)
                findNavController().navigate(action)
            }else{
                Toast.makeText(context,"Correct answer has not been supplied yet",Toast.LENGTH_SHORT).show()
            }


        }


        rBQuestion1.setOnClickListener {
            if (questions[arguments.QuestionCount].choices[0]==questions[arguments.QuestionCount].correctAnswer){
                btnNextloc.isEnabled=true
            }else{
                Toast.makeText(context,"Wrong answer",Toast.LENGTH_SHORT).show()
            }
        }
        rBQuestion2.setOnClickListener {
            if (questions[arguments.QuestionCount].choices[1]==questions[arguments.QuestionCount].correctAnswer){
                btnNextloc.isEnabled=true
            }else{
                Toast.makeText(context,"Wrong answer",Toast.LENGTH_SHORT).show()
            }
        }
        rBQuestion3.setOnClickListener {
            if (questions[arguments.QuestionCount].choices[2]==questions[arguments.QuestionCount].correctAnswer){
                btnNextloc.isEnabled=true
            }else{
                Toast.makeText(context,"Wrong answer",Toast.LENGTH_SHORT).show()
            }
        }

}

}
