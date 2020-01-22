package pizza.summersolutions.hvaquestkotlin.UI


import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_location.*
import kotlinx.android.synthetic.main.fragment_winning.*



import pizza.summersolutions.hvaquestkotlin.R

/**
 * A simple [Fragment] subclass.
 */
class LocationFragment : Fragment() {
    private val arguments: LocationFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        iVLocationImage.setImageDrawable(context?.let { getDrawable(it,arguments.HvAImage) })
        var action: NavDirections
        btnNext.setOnClickListener{

            if(arguments.QuestionCount<10){
                action = LocationFragmentDirections.actionLocationFragmentToQuestionFragment(arguments.QuestionCount)

            }else{
                action = LocationFragmentDirections.actionLocationFragmentToWinningFragment()
            }
            findNavController().navigate(action)
        }
    }


}
