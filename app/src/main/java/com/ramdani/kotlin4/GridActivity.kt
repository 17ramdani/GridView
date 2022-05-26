package com.ramdani.kotlin4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.GridView
import android.widget.Toast
class GridActivity : AppCompatActivity() {
    lateinit var gridView: GridView
    private var menuNames = arrayOf("Ghost","Human", "Angel",
        "Vampire","Witch","Siti")
    private var menuImages = intArrayOf(R.drawable.halloween1,
        R.drawable.halloween2, R.drawable.halloween3,
        R.drawable.halloween4,R.drawable.halloween5,R.drawable.halloween6)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)
        title = "KotlinApp"
        gridView = findViewById(R.id.gridView)
        val mainAdapter = GridAdapter(this@GridActivity,
            menuNames, menuImages)
        gridView.adapter = mainAdapter
        gridView.onItemClickListener = OnItemClickListener { _,
                                                             _, position, _ ->
            Toast.makeText(applicationContext, "You CLicked " +
                    menuNames[+position],
                Toast.LENGTH_SHORT).show()
        }
    }
}