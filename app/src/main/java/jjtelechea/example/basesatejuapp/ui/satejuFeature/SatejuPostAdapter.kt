package jjtelechea.example.basesatejuapp.ui.satejuFeature

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import jjtelechea.example.basesatejuapp.data.database.entity.SatejuPostEntity
import jjtelechea.example.basesatejuapp.databinding.ListItemSatejuPostBinding

class SatejuPostAdapter :
    ListAdapter<SatejuPostEntity, SatejuPostAdapter.ViewHolder>(SatejuPostDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder private constructor(private val binding: ListItemSatejuPostBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SatejuPostEntity) {
            binding.satejuPost = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemSatejuPostBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class SatejuPostDiffCallback : DiffUtil.ItemCallback<SatejuPostEntity>() {

    override fun areItemsTheSame(oldItem: SatejuPostEntity, newItem: SatejuPostEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SatejuPostEntity, newItem: SatejuPostEntity): Boolean {
        return oldItem == newItem
    }

}