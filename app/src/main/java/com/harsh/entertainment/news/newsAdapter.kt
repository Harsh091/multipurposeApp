package com.harsh.entertainment.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.harsh.entertainment.R
import java.util.ArrayList

class newsAdapter( private val newslistener:news_item_clicked): RecyclerView.Adapter<newsViewHolder>() {
    private val items:ArrayList<newsData> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):newsViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
        val viewHolder=newsViewHolder(view)
        view.setOnClickListener {
newslistener.OnitemClicked(items[viewHolder.adapterPosition])
        }
return viewHolder
    }

    override fun onBindViewHolder(holder:newsViewHolder, position: Int) {
        val currentItem = items[position]
        holder.titleView.text = currentItem.title
    }

    override fun getItemCount(): Int {
       return items.size
    }

fun updateNews(updatedNews:ArrayList<newsData>)
{
    items.clear()
    items.addAll(updatedNews)
    notifyDataSetChanged()
}




}

    class newsViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
val titleView:TextView=itemView.findViewById(R.id.title)
    }

interface news_item_clicked{
    fun OnitemClicked(item:newsData)
}