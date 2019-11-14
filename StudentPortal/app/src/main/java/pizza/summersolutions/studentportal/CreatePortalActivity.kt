package pizza.summersolutions.studentportal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_portal.*

class CreatePortalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_portal)

        initViews()
    }

    private fun initViews() {
        btnSubmitPortal.setOnClickListener{
            var title : String = etTitle.text.toString()
            var portal = uriET.text.toString()

            val submitIntent = Intent(this,MainActivity::class.java)
            submitIntent.putExtra("TITLE", title)
            submitIntent.putExtra("PORTAL",portal)

            setResult(100,submitIntent)
            onBackPressed()
        }
    }
}
