package edu.temple.selectionactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = generateTestData()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)


        //val imageView = findViewById<ImageView>(R.id.imageView)
        //val textView = findViewById<TextView>(R.id.textView)

        recyclerView.layoutManager = GridLayoutManager(this, 3)

        // View.OnClickListener is created in the activity
        // and then passed to adapter
        // This allows the onClick() callback
        // to have access to the activity's members
        val onClickListener = View.OnClickListener {
            val itemPosition = recyclerView.getChildAdapterPosition(it)

            val intent = Intent(this, DisplayActivity::class.java)
            intent.putExtra("Items", items[itemPosition])
            // start your next activity
            startActivity(intent)

        // imageView.setImageResource(items[itemPosition].resourceId)
            //textView.text = items[itemPosition].description
        }

        recyclerView.adapter = ImageAdapter(items, onClickListener)
    }

    // Test data
    fun generateTestData(): Array<Item> {
        val array = resources.getStringArray(R.array.succulentsArray)
        return arrayOf(Item(R.drawable.agaveattenuata, array[0])
            , Item(R.drawable.aloevera,array[1])
            , Item(R.drawable.blackprince,array[2])
            , Item(R.drawable.echeverialola,array[3])
            , Item(R.drawable.ladyfinger,array[4])
            , Item(R.drawable.parodiamagnifica,array[5])
            , Item(R.drawable.perlevonnurnburg,array[6])
            , Item(R.drawable.prettysucc,array[7])
            , Item(R.drawable.succulent,array[8])
            , Item(R.drawable.tigertooth,array[9]))
    }
}

