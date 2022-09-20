package DAO;

import Data.*;
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
    void displayingSongByArtistID() throws SQLException, ClassNotFoundException {
        String artistName = "arijit";
        List<Artist> artistList = ArtistDAO.displayByArtistName(artistName);
        List<Song> songlist = SongDAO.displayingSongByArtistID(artistList);
        assertEquals(2,songlist.size());
    }

    @Test
    void displayingSongByGenreID() throws SQLException, ClassNotFoundException {
        String genreName = "classical";
        List<Genre> genreList = GenreDAO.displayByGenre(genreName);
        List<Song> songlist = SongDAO.displayingSongByGenreID(genreList);
        assertEquals(1,songlist.size());

    }

//    @Test
//    void showSongbySongId() throws SQLException, ClassNotFoundException {
//
//    }
}