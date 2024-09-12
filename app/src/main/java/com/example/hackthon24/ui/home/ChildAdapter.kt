package com.example.hackthon24.ui.home
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hackthon24.databinding.ItemChildBinding

class ChildAdapter(private val childList: List<ChildItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // Define view types
    companion object {
        private const val TYPE_A = 1
        private const val TYPE_B = 2
        private const val TYPE_C = 3
        private const val TYPE_D = 4
    }

    override fun getItemViewType(position: Int): Int {
        return when (childList[position]) {
            is ChildItem.ChildTypeA -> TYPE_A
            is ChildItem.ChildTypeB -> TYPE_B

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_A -> ChildAViewHolder(ItemChildBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            TYPE_B -> ChildBViewHolder(ItemChildBinding.inflate(LayoutInflater.from(parent.context), parent, false))
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

    // ViewHolders for each child type
    inner class ChildAViewHolder(private val binding: ItemChildBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(child: ChildItem.ChildTypeA) {
            binding.tvName.text = child.name
            binding.tvAge.text = child.age
        }
    }

    inner class ChildBViewHolder(private val binding: ItemChildBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(child: ChildItem.ChildTypeB) {
            binding.tvName.text = child.title
            binding.tvAge.text = child.description
        }
    }
}
