package DAO;

import Data.Playlist;
import Utilities.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlaylistDAO {
    public static void creatingAPlaylist() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a playlist name which you want created :");
        String playlistName= sc.nextLine();
        String sql = "Insert into Playlist (playlist_name) values ('"+ playlistName+"')";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }
   public static List<Playlist> showAllExistingPlaylists() throws SQLException, ClassNotFoundException {
        List<Playlist> playlist = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        String sql = "Select * from Playlist";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
       ResultSet resultSet =  preparedStatement.executeQuery();
        while(resultSet.next())
        {
            int playlist_id = resultSet.getInt(1);
            String playlist_name = resultSet.getString(2);
            Playlist playlist1 = new Playlist(playlist_id,playlist_name);
            playlist.add(playlist1);
        }
        return playlist;
    }
    public static List<Playlist> searchPlaylistByPlaylistId(int playlist_id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        List<Playlist> playlistList = new ArrayList<>();
        String sql = "SELECT* FROM songsplaylistdata WHERE playlist_id = '" + playlist_id + "'";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);

            Playlist playlist = new Playlist(id,name);
            playlistList.add(playlist);
        }
        return playlistList;
    }
}
