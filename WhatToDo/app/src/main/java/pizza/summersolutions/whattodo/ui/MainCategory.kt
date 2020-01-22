package pizza.summersolutions.whattodo.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import pizza.summersolutions.whattodo.R

class MainCategory : Fragment() {

    companion object {
        fun newInstance() = MainCategory()
    }

    private lateinit var viewModel: MainCategoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_category_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainCategoryViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
