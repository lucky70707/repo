package pizza.summersolutions.whattodo.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import pizza.summersolutions.whattodo.R

import kotlinx.android.synthetic.main.activity_what_to_do.*

class WhatToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_what_to_do)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
             Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                 .setAction("Action", null).show()

             val fm : FragmentManager = supportFragmentManager
             val myDialogFragment=EditNameDialogFragment { view -> hideKeyboard(view)}
             myDialogFragment.show(fm,"Popped up")

/*
             val intent = Intent(this, MainActivity::class.java)
             startActivity(intent)
*/

        }
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

}
