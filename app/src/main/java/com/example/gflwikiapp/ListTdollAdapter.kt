package com.example.gflwikiapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListTdollAdapter(private val listTdoll: ArrayList<Tdoll>): RecyclerView.Adapter<ListTdollAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_tdoll, parent, false)
        return ListViewHolder(view)
    }

//    dont forget to add decription later
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, manufactur, faction, weapon, photo) = listTdoll[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
//        holder.tvDescription.text = description
        holder.tvManufactur.text = manufactur
        holder.tvFaction.text = faction
        holder.tvWeapon.text = weapon

    }

    override fun getItemCount(): Int = listTdoll.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvManufactur: TextView = itemView.findViewById(R.id.tv_item_manufactur)
        val tvFaction: TextView = itemView.findViewById(R.id.tv_item_faction)
        val tvWeapon: TextView = itemView.findViewById(R.id.tv_item_weapon)

    }
}