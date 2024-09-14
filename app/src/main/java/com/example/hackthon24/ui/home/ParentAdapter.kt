package com.example.hackthon24.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hackthon24.databinding.ItemParentABinding

class ParentAdapter(
    private val parentList: List<ParentItem>,
    private val childItemClickListener: ChildAdapter.OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_A = 1
        private const val TYPE_B = 2
    }

    override fun getItemViewType(position: Int): Int {
        return when (parentList[position]) {
            is ParentItem.ParentTypeA -> TYPE_A
            is ParentItem.ParentTypeB -> TYPE_B
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_A -> ParentAViewHolder(ItemParentABinding.inflate(LayoutInflater.from(parent.context), parent, false))
            TYPE_B -> ParentBViewHolder(ItemParentABinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val parentItem = parentList[position]
        when (holder) {
            is ParentAViewHolder -> holder.bind(parentItem as ParentItem.ParentTypeA)
            is ParentBViewHolder -> holder.bind(parentItem as ParentItem.ParentTypeB)
        }
    }

    override fun getItemCount(): Int = parentList.size

    inner class ParentAViewHolder(private val binding: ItemParentABinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(parent: ParentItem.ParentTypeA) {
            binding.tvParentTitle.text = parent.title
            binding.childRecyclerView.layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
            binding.childRecyclerView.adapter = ChildAdapter(parent.children, childItemClickListener)
        }
    }

    inner class ParentBViewHolder(private val binding: ItemParentABinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(parent: ParentItem.ParentTypeB) {
            binding.tvParentTitle.text = parent.title
            binding.childRecyclerView.layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
            binding.childRecyclerView.adapter = ChildAdapter(parent.children, childItemClickListener)
        }
    }
}
