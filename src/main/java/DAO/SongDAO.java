package DAO;

import Data.Artist;
import Data.Genre;
import Data.Song;
import Data.SongPlaylistData;
import Utilities.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongDAO {

    public static List<Song> displayAll() throws SQLException, ClassNotFoundException,NumberFormatException{ //displays all songs
        Connection connection = DBConnection.getConnection();
        List<Song> songList = new ArrayList<>();
//        String query = "select songs.sno, playlistentry.name, playlistentry.artist, songs.album, songs.genre, playlistentry.duration\n" +
//                "from playlistentry join songs on playlistentry.sno = songs.entryno;\n";
        String sql = "SELECT * FROM songs;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            double duration = resultSet.getDouble(3);
            String song_path = resultSet.getString(4);
            String artist_id = resultSet.getString(5);
            String genre_id = resultSet.getString(6);
            Song songs = new Song(id, name,duration,song_path, artist_id, genre_id);
            songList.add(songs);
        }
        return songList;
    }

    public static List<Song> displayBySongName(String name) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        List<Song> songList = new ArrayList<>();
        String sql = "SELECT * from songs where song_name like '%" + name + "%'";
//        String sql = "Select class_id from class_tbl where class_name = ? and section = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name1 = resultSet.getString(2);
            String song_path = resultSet.getString(4);
            double duration = resultSet.getDouble(3);
            String artist_id = resultSet.getString(5);
            String genre_id = resultSet.getString(6);
            Song songs = new Song(id, name,duration,song_path, artist_id, genre_id);
            songList.add(songs);
        }
        return songList;
    }
    public static List<Song> displayingSongByArtistID(List<Artist> artistList) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        List<Song> songList = new ArrayList<>();
        for (Artist e: artistList)
        {
        String sql = "SELECT * from songs where artist_id = '"+e.getArtist_id()+"'";
//        String sql = "Select class_id from class_tbl where class_name = ? and section = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name1 = resultSet.getString(2);
            String song_path = resultSet.getNString(4);
            double duration = resultSet.getDouble(3);
            String artist_id = resultSet.getString(5);
            String genre_id = resultSet.getString(6);
            Song songs = new Song(id, name1,duration,song_path, artist_id, genre_id);
            songList.add(songs);
        }
        }
        return songList;
    }
    public static List<Song> displayingSongByGenreID(List<Genre> genreList) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        List<Song> songList = new ArrayList<>();
        for (Genre e: genreList)
        {
            String sql = "SELECT * from songs where genre_id = '"+e.getGenre_id()+"'";
//          String sql = "Select class_id from class_tbl where class_name = ? and section = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name1 = resultSet.getString(2);
                double duration = resultSet.getDouble(3);
                String song_path = resultSet.getString(4);
                String artist_id = resultSet.getString(5);
                String genre_id = resultSet.getString(6);
                Song song = new Song(id, name1,duration,song_path, artist_id, genre_id);
                songList.add(song);
            }
        }
        return songList;
    }
    public  static List<Song> showSongbySongId(List<SongPlaylistData> songPlaylistData) throws SQLException, ClassNotFoundException {
        List<Song> songsList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();

        for (SongPlaylistData element : songPlaylistData)
        {
            String sql = "SELECT* FROM Songs WHERE song_id = '" + element.getSong_id() +"'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                int song_id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String song_path = resultSet.getString(4);
                double song_duration = resultSet.getDouble(3);
                String genre_id = resultSet.getString(5);
                String artist_id = resultSet.getString(6);
                Song song = new Song(song_id, name,song_duration,song_path, artist_id, genre_id);
                songsList.add(song);
            }
        }
        return  songsList;
    }

    public static String fetchSongPathBySongId(int song_id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        String sql = "Select song_path from songs where song_id = '" +song_id +"'";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        String songPath = null;
        if (resultSet.next()) {
            songPath = resultSet.getString(1);
        }
        return songPath;
    }
}

