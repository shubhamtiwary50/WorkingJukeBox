package DAO;

import Data.Playlist;
import Data.Song;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SongDAOTest {

    SongDAO songDAO;

    @BeforeEach
    void setUp() {
        songDAO = new SongDAO();
    }

    @AfterEach
    void tearDown() {
        songDAO = null;
    }

    @Test
    void displayAll() throws SQLException, ClassNotFoundException {
        List<Song> songsList = SongDAO.displayAll();
        assertEquals(6,songsList.size());
    }

    @Test
    void displayBySongName() throws SQLException, ClassNotFoundException {
        String name = "Dua";
        List<Song> songList = SongDAO.displayBySongName(name);
        assertEquals(1,songList.size());

    }

    @Test
    void displayingSongByArtistID() {

//        List<Song> songList = SongDAO.displayingSongByArtistID();
//        assertEquals(1,songList.size());
    }

    @Test
    void displayingSongByGenreID() {
    }

    @Test
    void showSongbySongId() {
    }
}