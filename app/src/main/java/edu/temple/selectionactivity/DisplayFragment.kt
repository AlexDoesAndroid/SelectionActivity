package edu.temple.selectionactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider





class DisplayFragment : Fragment() {
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView

    override fun onStart() {
        super.onStart()
        val itemModel: itemModel = ViewModelProvider(requireActivity()).get(itemModel::class.java)
    }

    private lateinit var layout:View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
           // param1 = it.getString(ARG_PARAM1)
           // param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        layout = inflater.inflate(R.layout.fragment_display, container, false)
        //var DisplayItem = intent.getSerializableExtra("Items") as Item
        imageView = layout.findViewById<ImageView>(R.id.imageView)
        textView = layout.findViewById<TextView>(R.id.textView)

       // imageView.setImageResource(DisplayItem.resourceId)
        //textView.text = DisplayItem.description
        ViewModelProvider(requireActivity())
            .get(itemModel::class.java)
            .getItem()?.observe(requireActivity(), {
                changeItem(it)
            })
        return layout
    }
    private fun changeItem(_item:Item) {
        imageView.setImageResource(_item.resourceId)
        textView.text = _item.description

    }

    //companion object {
     //   fun newInstance(param1: String, param2: String) =
       //     DisplayFragment().apply {
         //       arguments = Bundle().apply {
                   // putString(ARG_PARAM1, param1)
                    //putString(ARG_PARAM2, param2)
          //      }
          //  }
    //}
}