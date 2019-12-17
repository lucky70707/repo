package pizza.summersolutions.bottomnavigationbar

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        initNavigation()
    }

        private fun initNavigation(){
            val navController = findNavController(R.id.navHostFragment)

            NavigationUI.setupWithController(navView, navController)

            val appbarConfiguration = AppbarConfiguration(navController.graph)

            toolbar.setupWithNavController(navController, appBarConfiguration)

            navController.addOnDestinationChangedListener { controller, destination, arguments ->
                when (destination.id) {
                    R.id.homeFragment -> showBottomNavigationBar(true)
                    R.id.rateFragment -> showBottomNavigationBar(true)
                    R.id.ratedFragment -> showBottomNavigationBar(false)
                }
            }
        }


    private fun showBottomNavigationBar(visible: Boolean) {
        when (visible) {
            true -> navView.visibility = View.VISIBLE
            false -> navView.visibility = View.GONE
        }
    }



}
