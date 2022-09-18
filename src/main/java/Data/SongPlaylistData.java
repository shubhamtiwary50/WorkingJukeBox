package Data;

import Utilities.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongPlaylistData {
     private int songPlaylistData_id;
     private int song_id;
     private int playlist_id;


    public SongPlaylistData(int songPlaylistData_id, int song_id, int playlist_id) {
        this.songPlaylistData_id = songPlaylistData_id;
        this.song_id = song_id;
        this.playlist_id = playlist_id;
    }


    public int getSongPlaylistData_id() {
        return songPlaylistData_id;
    }

    public void setSongPlaylistData_id(int songPlaylistData_id) {
        this.songPlaylistData_id = songPlaylistData_id;
    }

    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }

    public int getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(int playlist_id) {
        this.playlist_id = playlist_id;
    }
}

