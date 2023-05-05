package com.example.rickandmorty.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmorty.data.local.CharacterEntity
import com.example.rickandmorty.databinding.ItemCharacterBinding

class CharactersAdapter : RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>() {

    private var character = emptyList<CharacterEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharactersViewHolder(binding)
    }

    override fun getItemCount(): Int = character.size

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.bind(character[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(character: List<CharacterEntity>) {
        this.character = character
        notifyDataSetChanged()
    }

    class CharactersViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: CharacterEntity) {
            binding.name.text = character.name
            binding.gender.text = character.gender
            if(character.type.isBlank()) binding.type.visibility = View.GONE
            else binding.type.text = character.type
            binding.species.text = character.species
            binding.status.text = character.status
            binding.origin.text = character.origin.nameOrigin
            Glide
                .with(binding.root.context)
                .load(character.image)
                .centerCrop()
                .into(binding.characterImage)
        }
    }
}
