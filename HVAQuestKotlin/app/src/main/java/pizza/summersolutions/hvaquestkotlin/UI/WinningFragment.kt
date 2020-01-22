package pizza.summersolutions.hvaquestkotlin.UI


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_winning.*

import pizza.summersolutions.hvaquestkotlin.R
import pizza.summersolutions.hvaquestkotlin.R.id.iVWinningImage

/**
 * A simple [Fragment] subclass.
 */
class WinningFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_winning, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        val action= WinningFragmentDirections.actionWinningFragmentToStartFragment()
        btnFinish.setOnClickListener{
            findNavController().navigate(action)
        }

        iVWinningImage.setImageResource(R.drawable.ic_cake_red_24dp)
    }


}
