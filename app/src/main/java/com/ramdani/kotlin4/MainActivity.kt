package com.ramdani.kotlin4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val array = arrayOf("Jakarta", "Bandung", "Yogyakarta",
            "Padang", "Lampung")
        val adapter = ArrayAdapter(this,
            R.layout.listview_item, array)
        val listView:ListView = findViewById(R.id.lv_kota)
        listView.setAdapter(adapter)
        listView.onItemClickListener = object :
            AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>,
                                     view: View,
                                     position: Int, id: Long) {
// value of item that is clicked
                val itemValue =
                    listView.getItemAtPosition(position) as String
// Toast the values
                Toast.makeText(applicationContext,
                    "Position in Array : $position" +
                            "\n Item Value : $itemValue",
                    Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when (item.itemId){
            R.id.list -> {
                val moveIntent = Intent(this@MainActivity,
                    MainActivity::class.java)
                startActivity(moveIntent)
                Toast.makeText(this,"ListView",Toast.LENGTH_SHORT).show()
            }
            R.id.grid -> {
                val moveIntent = Intent(this@MainActivity,
                    GridActivity::class.java)
                startActivity(moveIntent)
                Toast.makeText(this,"GridView",Toast.LENGTH_SHORT).show()
            }
            R.id.exit -> {
                finish()
                Toast.makeText(this,"KeluarAplikasi",Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}