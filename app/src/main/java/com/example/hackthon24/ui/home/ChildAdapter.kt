package com.example.hackthon24.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hackthon24.DetailActivity
import com.example.hackthon24.databinding.ItemChildBinding

class ChildAdapter(
    private val childList: List<ChildItem>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(childItem: ChildItem)
    }

    companion object {
        private const val TYPE_A = 1
        private const val TYPE_B = 2
    }

    override fun getItemViewType(position: Int): Int {
        return when (childList[position]) {
            is ChildItem.ChildTypeA -> TYPE_A
            is ChildItem.ChildTypeB -> TYPE_B
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_A -> {
                val binding = ItemChildBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ChildAViewHolder(binding) // Return the ChildAViewHolder instance
            }
            TYPE_B -> {
                val binding = ItemChildBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ChildBViewHolder(binding) // Return the ChildBViewHolder instance
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val childItem = childList[position]
        when (holder) {
            is ChildAViewHolder -> holder.bind(childItem as ChildItem.ChildTypeA)
            is ChildBViewHolder -> holder.bind(childItem as ChildItem.ChildTypeB)
        }
    }

    override fun getItemCount(): Int = childList.size

    inner class ChildAViewHolder(private val binding: ItemChildBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(child: ChildItem.ChildTypeA) {
            binding.tvName.text = child.name
            binding.tvAge.text = child.age

            // Load image using Glide
            Glide.with(binding.root.context)
                .load(child.imgUrl) // Assuming child has an imageUrl property
                .into(binding.tvImg)

            binding.root.setOnClickListener {
                itemClickListener.onItemClick(child)
                // Launch DetailActivity
                val context = binding.root.context
                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra(DetailActivity.EXTRA_NAME, child.name)
                    // putExtra(DetailActivity.EXTRA_DESCRIPTION, child.age)  // You can customize this based on the item details
                }
                context.startActivity(intent)
            }
        }
    }

    inner class ChildBViewHolder(private val binding: ItemChildBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(child: ChildItem.ChildTypeB) {
            binding.tvName.text = child.title
            binding.tvAge.text = child.description

            // Load image using Glide
            Glide.with(binding.root.context)
                .load(child.imgUrl) // Assuming child has an imageUrl property
                .into(binding.tvImg)

            binding.root.setOnClickListener {
                itemClickListener.onItemClick(child)
                // Launch DetailActivity
                val context = binding.root.context
                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra(DetailActivity.EXTRA_NAME, child.title)
                    //   putExtra(DetailActivity.EXTRA_DESCRIPTION, child.description)  Customize this based on the item details
                }
                context.startActivity(intent)
            }
        }
    }
}
