package com.example.artbook

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.artbook.databinding.ItemBinding

class ArtAdapter(val list : List<Art>) : RecyclerView.Adapter<ArtAdapter.ArtViewHolder>() {


    class ArtViewHolder(val binding : ItemBinding) : RecyclerView.ViewHolder(binding.root) {
//              val textView = binding.root
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtViewHolder {
        val view = ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  ArtViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArtViewHolder, position: Int) {
        holder.binding.textView.text = list.get(position).artName
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,ArtActivity::class.java)
            intent.putExtra("old","old")
            intent.putExtra("id",list.get(position).id)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
         return  list.size
     }


}