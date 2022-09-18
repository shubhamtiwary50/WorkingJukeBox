package DAO;

import Data.Artist;
import Data.Song;
import Utilities.DBConnection;
import com.mysql.cj.jdbc.CallableStatement;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAO {
public static List<Artist> displayByArtistName(String artistName) throws SQLException, ClassNotFoundException
{ //displays by artist name entered by user
    Connection connection = DBConnection.getConnection();
    List <Artist> artistList = new ArrayList<>();
//        String query = "select songs.sno, playlistentry.name, playlistentry.artist, songs.album, songs.genre, playlistentry.duration\n" +
//                "from playlistentry join songs on playlistentry.sno = songs.entryno;\n";
    String sql = "SELECT * FROM artist where artist_name like '%"+artistName+"%'";

    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ResultSet resultSet = preparedStatement.executeQuery(sql);
    while(resultSet.next()){
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);
        Artist artist = new Artist(id,name);
        artistList.add(artist);
    }
    return  artistList;
}
}
