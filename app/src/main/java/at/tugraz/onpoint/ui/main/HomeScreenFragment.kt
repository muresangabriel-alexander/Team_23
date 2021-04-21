package at.tugraz.onpoint.ui.main

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.print.PrintAttributes
import android.text.Layout
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginBottom
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import at.tugraz.onpoint.R


/**
 * A placeholder fragment containing a simple view.
 */
class HomeScreenFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("begin of fragment")
        val root = inflater.inflate(R.layout.fragment_home_screen, container, false)


        val todoLayout = root.findViewById(R.id.homescreen_todo_list_id) as ViewGroup
        val recentLayout = root.findViewById(R.id.recent_linear_layout) as ViewGroup
        val todoList = listOf<String>("todo1", "todo2")
        val recentList = listOf<String>("recent1")
        for(todoItem in todoList){
            // TextView2
            println("In todo loop")
            val lptv = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT)

            lptv.setMargins(10, 50, 10, 0)
            val textView = TextView(activity)
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20.0F)
            textView.setLayoutParams(lptv)
            textView.setText(todoItem)
            textView.setTextColor(R.color.text_grey)
            textView.setPadding(30 , 40, 30, 40)
            textView.setBackgroundColor(R.color.lightGray_main)
            textView.gravity = Gravity.CENTER

           // textView.textAlignment =
            todoLayout.addView(textView)


        }

        for(recentItem in recentList){
            // TextView2
            println("In todo loop")
            val lptv = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT)

            lptv.setMargins(10, 50, 10, 0)
            val textView = TextView(activity)
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20.0F)
            textView.setLayoutParams(lptv)
            textView.setText(recentItem)
            textView.setTextColor(R.color.text_grey)
            textView.setPadding(30 , 40, 30, 40)
            textView.setBackgroundColor(R.color.lightGray_main)
            textView.gravity = Gravity.CENTER

            recentLayout.addView(textView)


        }

        return root
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): HomeScreenFragment {
            return HomeScreenFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}