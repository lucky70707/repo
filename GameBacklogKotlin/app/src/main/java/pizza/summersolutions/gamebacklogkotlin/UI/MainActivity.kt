package pizza.summersolutions.gamebacklogkotlin.UI

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import pizza.summersolutions.gamebacklogkotlin.R
import pizza.summersolutions.gamebacklogkotlin.models.Game

class MainActivity : AppCompatActivity() {

    private var games = arrayListOf<Game>()
    private val backlogAdapter = BacklogAdapter(games)
    private lateinit var viewModel:GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        initViews()
        initViewModel()


    }
    private fun createItemTouchHelper(): ItemTouchHelper {

        // Callback which is used to create the ItemTouch helper. Only enables left swipe.
        // Use ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) to also enable right swipe.
        val callback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

            // Enables or Disables the ability to move items up and down.
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            // Callback triggered when a user swiped an item.
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                var removableGame : Game = games[position]
                games.removeAt(position)
                viewModel.deleteGame(removableGame)
                backlogAdapter.notifyDataSetChanged()

                //undo option in snackbar
                var displayString = "1 item deleted"
                val mySnackbar = Snackbar.make(findViewById(R.id.mainActivityID), displayString, Snackbar.LENGTH_LONG)
                mySnackbar.setAction("Undo" ){
                        viewModel.insertGame(removableGame)
                }
                mySnackbar.show()
            }
        }
        return ItemTouchHelper(callback)
    }


    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        viewModel.games.observe(this, Observer { games->
            this@MainActivity.games.clear()
            this@MainActivity.games.addAll(games)
            backlogAdapter.notifyDataSetChanged()
        })
    }

    private fun initViews() {
        rVBacklog.layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        rVBacklog.adapter = backlogAdapter

        fab.setOnClickListener { view ->
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

        createItemTouchHelper().attachToRecyclerView(rVBacklog)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_delete_backlog -> {
                deleteBacklog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun deleteBacklog() {
        var deletedGames = arrayListOf<Game>()
        deletedGames.addAll(games)
        var displayString = games.size.toString()+" items deleted"
        viewModel.deleteAllGames()
        val mySnackbar = Snackbar.make(findViewById(R.id.mainActivityID), displayString, Snackbar.LENGTH_LONG)
        mySnackbar.setAction("Undo" ){
            for (game: Game in deletedGames){
             viewModel.insertGame(game)
        }

        }
        mySnackbar.show()



    }
}
