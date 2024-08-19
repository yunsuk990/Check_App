package com.example.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.DomainDataScore
import com.example.presentation.databinding.ScoreRecyclerItemBinding
import com.example.presentation.viewModel.MainViewModel

class ScoreRecyclerViewAdapter(
    private val viewModel: MainViewModel
): RecyclerView.Adapter<ScoreRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ScoreRecyclerItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: DomainDataScore){
            binding.data = data
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ScoreRecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = viewModel.scoreList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(viewModel.scoreList[position])
    }


}