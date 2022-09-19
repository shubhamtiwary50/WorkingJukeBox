package DAO;

import Data.Playlist;
import Data.Song;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistDAOTest {

    PlaylistDAO playlistDAO;

    @BeforeEach
    void setUp() {
        playlistDAO= new PlaylistDAO();
    }

    @AfterEach
    void tearDown() {
        playlistDAO = null;
    }

    @Test
    void showAllExistingPlaylists() throws SQLException, ClassNotFoundException {
        List<Playlist> songsList = PlaylistDAO.showAllExistingPlaylists();
        assertEquals(6,songsList.size());
    }

    @Test
    void searchPlaylistByPlaylistId() throws SQLException, ClassNotFoundException {
        int playlist_id = 1;
        List<Playlist> songsList = PlaylistDAO.searchPlaylistByPlaylistId(playlist_id);
        assertEquals(1,songsList.size());
    }

//    @Test
//    void deleteAnExistingPlaylist() {
//
//    }
}