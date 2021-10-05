package edu.temple.selectionactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        var DisplayItem = intent.getSerializableExtra("Items") as Item

        val imageView = findViewById<ImageView>(R.id.imageView)
        val textView = findViewById<TextView>(R.id.textView)

        imageView.setImageResource(DisplayItem.resourceId)
        textView.text = DisplayItem.description
    }

}