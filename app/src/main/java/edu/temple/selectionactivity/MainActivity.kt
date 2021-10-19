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

    lateinit var selectionFragment: SelectionFragment
    lateinit var displayFragment: DisplayFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var items = generateTestData()
        selectionFragment = SelectionFragment.getInstance(items)
        displayFragment = DisplayFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView, selectionFragment)
            .add(R.id.fragmentContainerView2, displayFragment)
            .commit()

    }
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

