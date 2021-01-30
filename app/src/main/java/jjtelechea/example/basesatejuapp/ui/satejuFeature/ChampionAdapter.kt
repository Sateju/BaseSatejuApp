package jjtelechea.example.basesatejuapp.ui.satejuFeature

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import jjtelechea.example.basesatejuapp.databinding.ListItemSatejuPostBinding
import jjtelechea.example.basesatejuapp.domain.model.ChampionEntity

class ChampionAdapter : ListAdapter<ChampionEntity, ChampionAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder private constructor(private val binding: ListItemSatejuPostBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ChampionEntity) {
            binding.entity = item
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

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ChampionEntity>() {
            override fun areItemsTheSame(
                oldItem: ChampionEntity,
                newItem: ChampionEntity
            ): Boolean = oldItem.name == newItem.name

            override fun areContentsTheSame(
                oldItem: ChampionEntity,
                newItem: ChampionEntity
            ): Boolean = oldItem == newItem
        }
    }
}