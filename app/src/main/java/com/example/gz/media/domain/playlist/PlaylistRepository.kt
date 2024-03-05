package com.example.gz.media.domain.playlist

import com.example.gz.media.domain.Playlist
import com.example.gz.search.domain.TrackModel
import kotlinx.coroutines.flow.Flow

interface PlaylistRepository {


    suspend fun insertPlaylist(playlist: Playlist)

    suspend fun deletePl (idPl : Int)

    suspend fun addNewTrack(track: TrackModel, playlist: Playlist)

    suspend fun getPlaylists(): Flow<List<Playlist>>

    suspend fun getPlaylistById (idPl : Int) : Playlist

    suspend fun deleteTrackFromPlaylist(trackId: String, idPl : Int  )

    suspend fun updatePl(idPl: Int?, namePl: String?,  descriptPl: String?)

    suspend fun deleteLinkTrackPl (trackId: String, idPl: Int)

    suspend fun deletePlfromTable (idPl : Int)

    suspend fun deleteLinkPl (idPl : Int)

    suspend fun deleteOrfanTrack ()
}