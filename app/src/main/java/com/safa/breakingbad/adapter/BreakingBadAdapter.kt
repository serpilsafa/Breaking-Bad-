package com.safa.breakingbad.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.safa.breakingbad.R
import com.safa.breakingbad.model.Actor
import javax.inject.Inject

class BreakingBadAdapter @Inject constructor(
    val glide: RequestManager
): RecyclerView.Adapter<BreakingBadAdapter.BreakingBadViewHolder>() {

    class BreakingBadViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val diffUtil = object : DiffUtil.ItemCallback<Actor>(){
        override fun areItemsTheSame(oldItem: Actor, newItem: Actor): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Actor, newItem: Actor): Boolean {
            return oldItem == newItem
        }

    }

    private val recyclerViewDiffer = AsyncListDiffer(this, diffUtil)

    var breakingBadList: List<Actor>
        get() = recyclerViewDiffer.currentList
        set(value) = recyclerViewDiffer.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreakingBadViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.breaking_bad_recyclerview_row, parent, false)
        return BreakingBadViewHolder(view)
    }

    override fun onBindViewHolder(holder: BreakingBadViewHolder, position: Int) {
        val imageView = holder.itemView.findViewById<ImageView>(R.id.characterImage)
        val nameText = holder.itemView.findViewById<TextView>(R.id.chracNameText)

        val character = breakingBadList[position]
        holder.itemView.apply {
            nameText.text = character.name
            glide.load(character.img).into(imageView)
        }
    }

    override fun getItemCount(): Int {
        return breakingBadList.size
    }
}