package edu.temple.selectionactivity

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectionFragment : Fragment() {
    private var param1: Array<Item>?=null
    private lateinit var layout:View
    lateinit var items : Array<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getSerializable("startupIndex") as Array<Item>
            items = param1 as Array<Item>
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        layout = inflater.inflate(R.layout.fragment_selection, container, false)



        val recyclerView = layout.findViewById<RecyclerView>(R.id.recyclerView)


        //val imageView = findViewById<ImageView>(R.id.imageView)
        //val textView = findViewById<TextView>(R.id.textView)

        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)

        // View.OnClickListener is created in the activity
        // and then passed to adapter
        // This allows the onClick() callback
        // to have access to the activity's members
        val onClickListener = View.OnClickListener {
            val itemPosition = recyclerView.getChildAdapterPosition(it)

            val intent = Intent(requireContext(), DisplayFragment::class.java)
            intent.putExtra("Items", items[itemPosition])
            // start your next activity

            startActivity(intent)

            // imageView.setImageResource(items[itemPosition].resourceId)
            //textView.text = items[itemPosition].description
        }

        recyclerView.adapter = ImageAdapter(items, onClickListener)


        return layout
    }

    companion object {

        fun getInstance (input: Array<Item>) : SelectionFragment {
            val fragment = SelectionFragment()
            val bundle: Bundle = Bundle()
            bundle.putSerializable("startupIndex", input)
            fragment.arguments = bundle
            return fragment
        }
    }


}