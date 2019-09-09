package pizza.summersolutions.logicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var quiztype = "AND"
    var trueVal = "T"
    var falseVal = "F"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        A1TV.setText(trueVal)
        A2TV.setText(trueVal)
        A3TV.setText(falseVal)
        A4TV.setText(falseVal)

        B1TV.setText(trueVal)
        B2TV.setText(falseVal)
        B3TV.setText(trueVal)
        B4TV.setText(falseVal)


        submitBtn.setOnClickListener{
            when(quiztype){
                "AND"->if(firstTB.isChecked && !secondTB.isChecked && !thirdTB.isChecked && !fourthTB.isChecked){
                    Toast.makeText(applicationContext,"CORRECT",Toast.LENGTH_SHORT).show()
                }else{
                Toast.makeText(applicationContext,"INCORRECT",Toast.LENGTH_SHORT).show()
            }
            }
        }




    }
}
