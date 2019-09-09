package pizza.summersolutions.higher_lower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var score = 0
    var highscore = 0
    var lastThrow = 0
    var dicenumber = 1
    var lastDicenumber=1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        throwDice()
        BtnReset.setOnClickListener{
            throwDice()
            resetScores()
            updateUI()
        }
        BtnHigher.setOnClickListener{
            throwDice()
            if(lastDicenumber<dicenumber){
                score++
                if(score >highscore){
                    highscore = score
                }
            }else{
                score = 0
            }
            updateUI()
        }
        BtnLower.setOnClickListener{
            throwDice()
            if(lastDicenumber>dicenumber){
                score++
                if(score >highscore){
                    highscore = score
                }
            }else{
                score = 0
            }
            updateUI()
        }

        BtnEquals.setOnClickListener{
            throwDice()
            if(lastDicenumber==dicenumber){
                score++
                if(score >highscore){
                    highscore = score
                }
            }else{
                score = 0
            }
            updateUI()
        }

    }

    fun resetScores(){
         score = 0
         highscore = 0
         lastThrow = 0
        dicenumber=0
        lastDicenumber =0

    }

    fun throwDice(){
        lastDicenumber = dicenumber
        dicenumber = Random.nextInt(1, 7)
        when(dicenumber){
            1-> {
                iVdice.setImageResource(R.drawable.dice1)
                iVdice.contentDescription =String.format("%s 1",getString(R.string.diceDescription))
            }
            2->{
                iVdice.setImageResource(R.drawable.dice2)
                iVdice.contentDescription =String.format("%s 2",getString(R.string.diceDescription))
            }
            3->{
                iVdice.setImageResource(R.drawable.dice3)
                iVdice.contentDescription =String.format("%s 3",getString(R.string.diceDescription))
            }
            4->{
                iVdice.setImageResource(R.drawable.dice4)
                iVdice.contentDescription =String.format("%s 4",getString(R.string.diceDescription))
            }

            5->{
                iVdice.setImageResource(R.drawable.dice5)
                iVdice.contentDescription =String.format("%s 5",getString(R.string.diceDescription))
            }
            6->{
                iVdice.setImageResource(R.drawable.dice6)
                iVdice.contentDescription =String.format("%s 6",getString(R.string.diceDescription))
            }
        }

    }

    fun updateUI(){
        tVScore.setText(String.format("%s %d",getString(R.string.score),score))
        tVHighscore.setText(String.format("%s %d",getString(R.string.highscore),highscore))
        tVLastThrow.setText(String.format("%s %d",getString(R.string.last_throw),lastDicenumber))
    }
}
