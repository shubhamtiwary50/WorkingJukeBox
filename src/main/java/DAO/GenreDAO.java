package DAO;
import Data.Genre;
import Utilities.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO {
    public static List<Genre> displayByGenre(String genreName) throws SQLException, ClassNotFoundException
    { //displays by Genre entered by user
        Connection connection = DBConnection.getConnection();
        List <Genre> genreList = new ArrayList<>();
         String sql = "SELECT * FROM genre where genre_name like '%"+genreName+"%'";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery(sql);
        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            Genre genre = new Genre(id,name);
            genreList.add(genre);
        }
        return  genreList;
    }
}

