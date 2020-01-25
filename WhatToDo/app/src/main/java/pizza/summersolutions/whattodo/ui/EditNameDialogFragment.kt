package pizza.summersolutions.whattodo.ui


import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.item_add_dialog_layout.*
import pizza.summersolutions.whattodo.Models.Task
import pizza.summersolutions.whattodo.R
import java.time.LocalDate
import java.time.format.DateTimeParseException
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class EditNameDialogFragment(private val hideKeyboard: (View) -> Unit) : DialogFragment() {

    var isSubtaskFragment: Boolean = false
    lateinit var editTextFilledExposedDropdown: AutoCompleteTextView
    var difficulty: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.item_add_dialog_layout, container, false)

        return root

    }


    override fun onStart() {
        super.onStart()

        if (dialog == null) {
            return
        }
        var width: Int = resources.getDimensionPixelSize(R.dimen.popup_width)
        var height: Int = resources.getDimensionPixelSize(R.dimen.popup_height)
        dialog!!.window!!.setLayout(width, height)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }


    private fun initViews() {
        btnCancel.setOnClickListener {
            dismiss()
        }
        btnSave.setOnClickListener {
            dismiss()
        }
        btnSubtask.setOnClickListener {

            checkFields()

        }

        tietName.onFocusChangeListener = View.OnFocusChangeListener { _, hasfocus ->
            if (!hasfocus) {
                //ToDo add functionality to edit texts
            }

        }
        tilName.onFocusChangeListener = View.OnFocusChangeListener { _, hasfocus ->
            if (!hasfocus) {

            }

        }

        tietName.setOnEditorActionListener { v, actionId, event ->
            when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    hideKeyboard(v ?: View(context)); v.clearFocus(); true
                }
                EditorInfo.IME_ACTION_NEXT -> {
                    hideKeyboard(v ?: View(context));v.clearFocus(); true
                }
                EditorInfo.IME_ACTION_PREVIOUS -> {
                    hideKeyboard(v ?: View(context)); v.clearFocus();true
                }
                else -> false
            }
        }

        tietDeadline.setOnEditorActionListener { v, actionId, event ->
            when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    hideKeyboard(v ?: View(context)); v.clearFocus(); true
                }
                EditorInfo.IME_ACTION_NEXT -> {
                    hideKeyboard(v ?: View(context));v.clearFocus(); true
                }
                EditorInfo.IME_ACTION_PREVIOUS -> {
                    hideKeyboard(v ?: View(context)); v.clearFocus();true
                }
                else -> false
            }
        }

        tietDeadline

        //todo handle radiobuttons
        rbDifficulty1.setOnClickListener {
            difficulty = 1
        }
        rbDifficulty2.setOnClickListener {
            difficulty = 2
        }
        rbDifficulty3.setOnClickListener {
            difficulty = 3
        }


        //todo handle saving properly
        //todo handle categories properly

        val Categories = arrayOf("Health", "Sports", "Work", "Study", "Misc.")
        val adapter: ArrayAdapter<String> = context?.let {
            ArrayAdapter<String>(
                it,
                R.layout.dropdown_menu_popup_item,
                Categories
            )
        }!!

        editTextFilledExposedDropdown =
            view!!.findViewById(R.id.filled_exposed_dropdown)
        editTextFilledExposedDropdown.setAdapter(adapter)


        //todo add datepicker
    }

    fun setupSubtask() {
        val output: String = editTextFilledExposedDropdown.text.toString()
        Toast.makeText(context, output, Toast.LENGTH_SHORT).show()

        /*
        tvOverlayTitle.text = "New Subtask"
        isSubtaskFragment = true

        btnSubtask.isEnabled = false

        btnCancel.setOnClickListener{
            tvOverlayTitle.text = "New Task"
            isSubtaskFragment = false
            btnSubtask.isEnabled=true
        }*/
    }

    fun checkFields() {


        var name: String = tietName.text.toString()
        var deadlineString: String = ""

        var deadlineDate: LocalDate? = null


        try {
            deadlineString = tietDeadline.text.toString()
            try {
                if (deadlineString != "") {
                    deadlineDate = LocalDate.parse(deadlineString)
                }

            } catch (e: DateTimeParseException) {
                deadlineDate = null
                tilDeadline.error = "Follow the format YYYY-MM-DD"
            }
        } catch (e: Error) {
            tilDeadline.error = "Please choose a date"
        }


        var category: String = editTextFilledExposedDropdown.text.toString()

        //var difficultyFilled: Boolean = rgDifficulty.checkedRadioButtonId != -1

        var nameFilled: Boolean = name != ""
        var deadlineFilled: Boolean = deadlineString != ""
        var categoryFilled: Boolean = category != ""

        if (categoryFilled && nameFilled) {
            var task: Task = Task(0, name, deadlineDate, difficulty, false, null, 0)
            btnSave.isEnabled = true
        }
    }


}


