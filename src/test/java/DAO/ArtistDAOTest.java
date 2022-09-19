package DAO;

import Data.Artist;
import Data.Song;
import org.junit.jupiter.api.BeforeEach;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArtistDAOTest {
    ArtistDAO artistDAO;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        artistDAO = new ArtistDAO();

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        artistDAO = null;

    }

    @org.junit.jupiter.api.Test
    void displayByArtistName() throws SQLException, ClassNotFoundException {
        String artistName = "shaan";
        List<Artist> songsList = ArtistDAO.displayByArtistName(artistName);
        assertEquals(1,songsList.size());
        artistName="KK";
        songsList = ArtistDAO.displayByArtistName(artistName);
        assertEquals(1,songsList.size());
    }
}