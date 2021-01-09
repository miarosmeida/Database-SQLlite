package com.example.mydatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DBAdapter(private val listDataku: ArrayList<DBModel>): RecyclerView.Adapter<DBAdapter.CardViewHolder>() {
    inner class CardViewHolder(itemV: View): RecyclerView.ViewHolder(itemV) {
        var tvemailku: TextView = itemV.findViewById(R.id.tv_emailku)
        var tvfullnameku: TextView = itemV.findViewById(R.id.tv_fullnameku)
        var tvaddressku: TextView = itemV.findViewById(R.id.tv_addressku)
        var tvgenderku: TextView = itemV.findViewById(R.id.tv_genderku)
        var tvtelpku: TextView = itemV.findViewById(R.id.tv_telpku)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_dataku, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val dataku = listDataku[position]
        holder.tvemailku.text = dataku.email
        holder.tvfullnameku.text = dataku.fullname
        holder.tvaddressku.text = dataku.address
        holder.tvgenderku.text = dataku.gender
        holder.tvtelpku.text = dataku.telp
    }

    override fun getItemCount(): Int {
        return listDataku.size
    }
}