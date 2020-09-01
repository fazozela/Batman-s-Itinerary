package com.example.androidstudygroup.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidstudygroup.R
import com.example.androidstudygroup.model.Villain
import kotlinx.android.synthetic.main.villain_row.view.*
import java.lang.IllegalArgumentException

class VillainAdapter(
    val context: Context,
    val villainList: List<Villain>,
    val itemClickListener: OnVillainCLickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnVillainCLickListener{
        fun onItemClick(item: Villain)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return VillainViewHolder(LayoutInflater.from(context).inflate(R.layout.villain_row, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is VillainViewHolder -> holder.bind(villainList[position], position)
            else -> throw IllegalArgumentException("No se reconocer el holder")
        }
    }

    override fun getItemCount(): Int {
        return villainList.size
    }

    inner class VillainViewHolder(itemView: View): BaseViewHolder<Villain>(itemView){
        override fun bind(item: Villain, position: Int) {

            itemView.setOnClickListener { itemClickListener.onItemClick(item) }

            Glide.with(context).load(item.img).into(itemView.villain_img)
            itemView.villain_name.text = item.name
            itemView.villain_danger.text = item.danger
            itemView.villain_last_seen.text = item.lastSeen
        }

    }

}