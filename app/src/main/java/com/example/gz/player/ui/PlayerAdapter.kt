package com.example.gz.player.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gz.media.domain.Playlist
import com.example.playlistmaker.databinding.LayoutPlayerPlaylistsBinding

class PlayerAdapter(): RecyclerView.Adapter<PlayerViewHolder>(){
    var playlists = arrayListOf<Playlist>()
    var clickListener: ((Playlist) -> Unit)? = null
    var imagePath = ""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val layoutInspector = LayoutInflater.from(parent.context)

        return PlayerViewHolder(
            LayoutPlayerPlaylistsBinding.inflate(
                layoutInspector,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = playlists.size

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bind(playlists[position], imagePath)
        holder.itemView.setOnClickListener { clickListener?.invoke(playlists[position]) }
    }
}