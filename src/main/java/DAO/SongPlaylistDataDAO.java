package DAO;

import Data.Playlist;
import Data.SongPlaylistData;
import Utilities.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongPlaylistDataDAO {
    public static void addSongToAnExistingPlaylist(int song_id,int playlist_id ) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        String sql = "Insert into songsplaylistdata (song_id, playlist_id) " +
                "values ('" + song_id + "','" + playlist_id + "')";
        // PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }
    public static List<SongPlaylistData> searchSongsIdFromPlaylistId(List<Playlist> playlist) throws SQLException, ClassNotFoundException {
        List<SongPlaylistData> songPlaylistData = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        for (Playlist element : playlist) {
            String sql = "SELECT*FROM songsplaylistdata WHERE playlist_id = '" + element.getPlaylist_id() + "'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int song_id = resultSet.getInt(2);
                int playlist_id = resultSet.getInt(3);
                SongPlaylistData songPlaylistData1 = new SongPlaylistData(id, song_id, playlist_id);
                     songPlaylistData.add(songPlaylistData1);
            }
        }
        return songPlaylistData;
    }
}
