package pizza.summersolutions.gamebacklogkotlin.UI

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import pizza.summersolutions.gamebacklogkotlin.R

import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.content_add.*
import kotlinx.android.synthetic.main.content_add.view.*
import kotlinx.android.synthetic.main.list_item.*
import pizza.summersolutions.gamebacklogkotlin.models.Game

class AddActivity : AppCompatActivity() {
   lateinit var viewModel:GameViewModel
    var validGame = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)

        initViews()
        initViewModel()
    }

    private fun initViewModel() {
       viewModel= ViewModelProviders.of(this).get(GameViewModel::class.java)
    }

    private fun initViews() {
        fab.setOnClickListener { view ->
            validGame = true
            var title : String = tIETTitle.text.toString()
            var platforms : String = tIETPlatform.text.toString()


            var dayString: String = tIETDay.text.toString()//.toInt()
            var monthString: String = tIETMonth.text.toString()//.toInt()
            var yearString: String = tIETYear.text.toString()//.toInt()

            var day : Int = 0
            var month: Int = 0
            var year: Int = 0

            if(TextUtils.isEmpty(title)){
                tIETTitle.error = "This cannot be empty."
                validGame=false
            }

            if(TextUtils.isEmpty(platforms)){
                tIETPlatform.error = "This cannot be empty."
                validGame=false
            }

            if(TextUtils.isEmpty(dayString)){
                tIETDay.error=("This cannot be empty.")
                validGame=false
            }else{
                day=dayString.toInt()
                if(day>31){
                    displayError("a valid day")
                }
            }

            if(TextUtils.isEmpty(monthString)){
                tIETMonth.error = "This cannot be empty."
                validGame=false
            }else{
                month=monthString.toInt()
                if(month>12){
                    displayError("a valid month")
                }
            }

            if(TextUtils.isEmpty(yearString)){
                tIETYear.error = "This cannot be empty."
                validGame=false
            }else{
                year=yearString.toInt()
            }

            if(validGame){
                viewModel.insertGame(Game(0,title,platforms,day,month,year))
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        }
    }

    private fun displayError(errorMsg: String) {
        validGame=false
        var error :String = "Please fill in a "
        Toast.makeText(this,error+errorMsg,Toast.LENGTH_LONG).show()
    }

}
