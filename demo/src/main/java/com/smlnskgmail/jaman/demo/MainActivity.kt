package com.smlnskgmail.jaman.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smlnskgmail.jaman.demo.logic.Item
import com.smlnskgmail.jaman.demo.logic.ItemsAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val items = listOf(
        Item("New York", "New York"),
        Item("Los Angeles", "California"),
        Item("Chicago", "Illinois"),
        Item("Houston", "Texas"),
        Item("Phoenix", "Arizona"),
        Item("Philadelphia", "Philadelphia"),
        Item("San Antonio", "Texas"),
        Item("San Diego", "California"),
        Item("Dallas", "Texas"),
        Item("San Jose", "California")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        demo_list.messageView = demo_list_message

        var isItemsIsLoaded = false
        demo_list_refresh.setOnClickListener {
            if (!isItemsIsLoaded) {
                demo_list.adapter = ItemsAdapter(items)
                demo_list_refresh.setText(R.string.text_refresh_button_clean)
            } else {
                demo_list.adapter = ItemsAdapter(emptyList())
                demo_list_refresh.setText(R.string.text_refresh_button_load)
            }
            isItemsIsLoaded = !isItemsIsLoaded
        }
    }

}
