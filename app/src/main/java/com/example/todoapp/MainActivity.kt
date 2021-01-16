package com.example.todoapp



import android.media.MediaPlayer
import android.os.Bundle
import android.util.SparseBooleanArray
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)        // Initializing the array lists and the adapter
    var itemlist = arrayListOf<String>()
    var adapter =ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_multiple_choice
        , itemlist)

    val ring: MediaPlayer = MediaPlayer.create(this@MainActivity, R.raw.ring)
    ring.start()

    add.setOnClickListener {

        itemlist.add(editText.text.toString())
        listView.adapter =  adapter
        adapter.notifyDataSetChanged()

        editText.text.clear()
    }

    clear.setOnClickListener {

        itemlist.clear()
        adapter.notifyDataSetChanged()        }
    listView.setOnItemClickListener { adapterView, view, i, l -> android.widget.Toast.makeText(this, "You Selected the item --> "+itemlist.get(i), android.widget.Toast.LENGTH_SHORT).show()        }
    delete.setOnClickListener {
        val position: SparseBooleanArray = listView.checkedItemPositions
        val count = listView.count
        var item = count - 1
        while (item >= 0) {
            if (position.get(item))
            {
                adapter.remove(itemlist.get(item))
            }
            item--
        }
        position.clear()
        adapter.notifyDataSetChanged()
    }
}
}