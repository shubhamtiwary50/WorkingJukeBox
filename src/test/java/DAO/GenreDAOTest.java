package DAO;

import Data.Genre;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenreDAOTest {

    GenreDAO genreDAO;

    @BeforeEach
    void setUp() {
        genreDAO = new GenreDAO();
    }

    @AfterEach
    void tearDown() {
        genreDAO = null;
    }

    @Test
    void displayByGenre() throws SQLException, ClassNotFoundException {
        String genreType = "pop";
        List<Genre> songsList = GenreDAO.displayByGenre(genreType);
        assertEquals(1,songsList.size());
    }
}