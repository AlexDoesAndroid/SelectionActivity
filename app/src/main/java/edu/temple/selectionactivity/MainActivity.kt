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

        selectionFragment = SelectionFragment.getInstance(1)
        displayFragment = DisplayFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView, selectionFragment)
            .add(R.id.fragmentContainerView2, displayFragment)
            .commit()

    }

}

