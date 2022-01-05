package com.smlnskgmail.jaman.demo.logic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smlnskgmail.jaman.demo.R
import kotlinx.android.synthetic.main.list_item.view.*

class ItemsAdapter(
    private val items: List<Item>
) : RecyclerView.Adapter<ItemsAdapter.ItemsHolder>() {

    inner class ItemsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Item) {
            itemView.list_item_title.text = item.title
            itemView.list_item_subtitle.text = item.subtitle
        }

    }

    override fun onBindViewHolder(holder: ItemsHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsHolder {
        return ItemsHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.count()
    }

}