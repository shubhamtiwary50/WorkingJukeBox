package DAO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SongPlaylistDataDAOTest {

    SongPlaylistDataDAO songPlaylistDataDAO;

    @BeforeEach
    void setUp() {
        songPlaylistDataDAO= new SongPlaylistDataDAO();
    }

    @AfterEach
    void tearDown() {
        songPlaylistDataDAO = null;
    }

    @Test
    void addSongToAnExistingPlaylist() {
    }

    @Test
    void searchSongsIdFromPlaylistId() {
    }

    @Test
    void removeSongsFromPlaylist() {
    }
}