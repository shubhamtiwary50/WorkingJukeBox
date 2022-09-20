package Main;
import DAO.*;
import Data.*;
import operations.SongOperation;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Impl {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        Impl obj = new Impl();
        SongOperation songOperation = new SongOperation();
        Scanner sc = new Scanner(System.in);
        System.out.println("======================================||Juke-Box||===========================================");
        System.out.println("----------------------------    Please make a choice :   ---------------------------------");
        System.out.println("=========================================================================================");
        System.out.println(" 1 : Songs");
        System.out.println(" 2 : Playlists");
        System.out.println("-1 : Exit ");


        int choice = sc.nextInt();
        sc.nextLine();


        switch (choice) {
            case 1: {
                System.out.println(" Please make a choice :");
                System.out.println(" 1 : List of all songs");
                System.out.println(" 2 : Display by song name");
                System.out.println(" 3 : Display by Artist name");
                System.out.println(" 4 : Display by Genre type");
                System.out.println(" 5 : Goto previous menu");

                int userchoice = sc.nextInt();

                switch (userchoice) {
                    case 1: {
                        List<Song> songlist = SongDAO.displayAll();
                        System.out.format("%-10s %-20s %-20s %-20s %-20s \n", "SongID", "SongName", "Duration", "Genre ID", "Artist ID");
                        System.out.println("--------------------------------------------------------------------------------------------------------");
                        for (Song song : songlist) {
                            System.out.format("%-10s %-20s %-20s %-20s %-20s \n",song.getSong_id(),song.getSong_name(),song.getSong_duration(),song.getGenre_id(),song.getArtist_id());
                        }

                            System.out.println("Enter the song ID which you want to play : ");
                             int song_id = sc.nextInt();
                             String song_path = SongDAO.fetchSongPathBySongId(song_id);
                             songOperation.PlaySong(song_path);

                        break;
                    }

                    case 2: {
                        sc.nextLine();
                        System.out.println(" Enter the name of the song you want : ");
                        String songName = sc.nextLine();
                        List<Song> songlist = SongDAO.displayBySongName(songName);

                        System.out.format("%-10s %-20s %-20s %-20s %-20s \n", "SongID", "SongName", "Duration", "Genre ID", "Artist ID");
                        System.out.println("--------------------------------------------------------------------------------------------------------");
                        for (Song song : songlist) {
                            System.out.format("%-10s %-20s %-20s %-20s %-20s \n",song.getSong_id(),song.getSong_name(),song.getSong_duration(),song.getGenre_id(),song.getArtist_id());
                        }

                        System.out.println("Enter the song ID which you want to play : ");
                             int song_id = sc.nextInt();
                            String song_path = SongDAO.fetchSongPathBySongId(song_id);
                             songOperation.PlaySong(song_path);

                        break;

                    }

                    case 3: {
                        System.out.println(" Enter the artist name : ");
                        sc.nextLine();
                        String artist_Name = sc.nextLine();
                        List<Artist> artistlist = ArtistDAO.displayByArtistName(artist_Name);
                        List<Song> songlist = SongDAO.displayingSongByArtistID(artistlist);

                        System.out.format("%-10s %-20s %-20s %-20s %-20s \n", "SongID", "SongName", "Duration", "Genre ID", "Artist ID");
                        System.out.println("--------------------------------------------------------------------------------------------------------");
                        for (Song song : songlist) {
                            System.out.format("%-10s %-20s %-20s %-20s %-20s \n",song.getSong_id(),song.getSong_name(),song.getSong_duration(),song.getGenre_id(),song.getArtist_id());
                        }

                        System.out.println("Enter the song ID which you want to play : ");
                        int song_id = sc.nextInt();
                        String song_path = SongDAO.fetchSongPathBySongId(song_id);
                        songOperation.PlaySong(song_path);

                        break;
                    }

                    case 4: {
                        System.out.println(" Enter the genre type : ");
                        sc.nextLine();
                        String genreName = sc.nextLine();
                        List<Genre> genrelist = GenreDAO.displayByGenre(genreName);
                        List<Song> songlist = SongDAO.displayingSongByGenreID(genrelist);
                        System.out.format("%-10s %-20s %-20s %-20s %-20s \n", "SongID", "SongName", "Duration", "Genre ID", "Artist ID");
                        System.out.println("--------------------------------------------------------------------------------------------------------");
                        for (Song song : songlist) {
                            System.out.format("%-10s %-20s %-20s %-20s %-20s \n",song.getSong_id(),song.getSong_name(),song.getSong_duration(),song.getGenre_id(),song.getArtist_id());
                        }

                        System.out.println("Enter the song ID which you want to play : ");
                        int song_id = sc.nextInt();
                        String song_path = SongDAO.fetchSongPathBySongId(song_id);
                        songOperation.PlaySong(song_path);

                        break;
                    }
                    case 5 : {
                        String [] arg= new String[0];
                        Impl.main(arg);
                        break;
                    }
                }
                break;
            }


            case 2: {
                System.out.println(" 1 : Create a new playlist");
                System.out.println(" 2 : Show all existing playlists");
                System.out.println(" 3 : Add songs to an exiting playlist");
                System.out.println(" 4 : Show all songs in an existing playlist");
                System.out.println(" 5 : Delete any song from a existing playlist ");
                System.out.println(" 6 : Return to previous menu ");

                int userchoice = sc.nextInt();
                switch (userchoice) {
                    case 1: {
                          PlaylistDAO.creatingAPlaylist();
                        List <Playlist> playlist = PlaylistDAO.showAllExistingPlaylists();
                        System.out.format("%-20s %-20s \n", "PlayList ID", "PlayList Name");
                        System.out.println("-----------------------------------------------");
                        for (Playlist playlist1 : playlist)
                        {
                            System.out.format("%-20s %-20s \n",playlist1.getPlaylist_id(),playlist1.getName_0f_playlist());
                        }

                        String [] arg= new String[0];
                        Impl.main(arg);
                        break;
                    }

                    case 2: {
                        List <Playlist> playlist = PlaylistDAO.showAllExistingPlaylists();
                        System.out.format("%-20s %-20s \n", "PlayList ID", "PlayList Name");
                        System.out.println("-----------------------------------------------");
                        for (Playlist playlist1 : playlist) {
                            System.out.format("%-20s %-20s \n",playlist1.getPlaylist_id(),playlist1.getName_0f_playlist());
                        }
                        String [] arg= new String[0];
                        Impl.main(arg);
                        break;
                    }

                    case 3: {
                             List<Playlist> playlist = PlaylistDAO.showAllExistingPlaylists();
                        System.out.format("%-20s %-20s \n", "PlayList ID", "PlayList Name");
                        System.out.println("-----------------------------------------------");
                        for (Playlist playlist1 : playlist) {
                            System.out.format("%-20s %-20s \n",playlist1.getPlaylist_id(),playlist1.getName_0f_playlist());
                        }
                        System.out.println(" Enter the Playlist ID into which you want to insert song");
                        int playlist_id= sc.nextInt();
                        List<Song> songlist = SongDAO.displayAll();
                        System.out.format("%-10s %-20s %-20s %-20s %-20s \n", "SongID", "SongName", "Duration", "Genre ID", "Artist ID");
                        System.out.println("--------------------------------------------------------------------------------------------------------");
                        for (Song song : songlist) {
                            System.out.format("%-10s %-20s %-20s %-20s %-20s \n",song.getSong_id(),song.getSong_name(),song.getSong_duration(),song.getGenre_id(),song.getArtist_id());
                        }
                        System.out.println(" Enter the Song ID which you want to insert");
                        int song_id= sc.nextInt();
                        SongPlaylistDataDAO.addSongToAnExistingPlaylist(song_id,playlist_id);
                        System.out.println("Song added to the selected playlist successfully.");
                        String [] arg= new String[0];
                        Impl.main(arg);
                        break;
                    }

                    case 4: {
                        List <Playlist> playlist = PlaylistDAO.showAllExistingPlaylists();
                        System.out.format("%-20s %-20s \n", "PlayList ID", "PlayList Name");
                        System.out.println("-----------------------------------------------");
                        for (Playlist playlist1 : playlist) {
                            System.out.format("%-20s %-20s \n",playlist1.getPlaylist_id(),playlist1.getName_0f_playlist());
                        }

                        System.out.println(" Enter the Playlist ID into which you view : ");
                        int playlist_id = sc.nextInt();
                        List<Playlist> playlist1 = PlaylistDAO.searchPlaylistByPlaylistId(playlist_id);
                        List<SongPlaylistData> listdata = SongPlaylistDataDAO.searchSongsIdFromPlaylistId(playlist1);
                        List<Song> list = SongDAO.showSongbySongId(listdata);
                        System.out.format("%-10s %-20s %-20s %-20s %-20s \n", "SongID", "SongName", "Duration", "Genre ID", "Artist ID");
                        System.out.println("--------------------------------------------------------------------------------------------------------");
                        for (Song song : list) {
                            System.out.format("%-10s %-20s %-20s %-20s %-20s \n",song.getSong_id(),song.getSong_name(),song.getSong_duration(),song.getGenre_id(),song.getArtist_id());
                        }
                        System.out.println(" Do you want to play the playlist ? :- 1-Yes, 2-Np");

                        int ch = sc.nextInt();
                        switch (ch){
                            case 1:{
                                songOperation.PlaySong(list);
                                break;
                            }
                            case 2: {
                                String[] arg = new String[0];
                                Impl.main(arg);
                                break;
                            }
                        }
                        break;
                    }
                    case 5: {
                        List <Playlist> playlist = PlaylistDAO.showAllExistingPlaylists();
                        System.out.format("%-20s %-20s \n", "PlayList ID", "PlayList Name");
                        System.out.println("-----------------------------------------------");
                        for (Playlist playlist1 : playlist) {
                            System.out.format("%-20s %-20s \n",playlist1.getPlaylist_id(),playlist1.getName_0f_playlist());
                        }
                        System.out.println("Enter the playlist_id from which you remove a song. ");
                        int playlist_id = sc.nextInt();
                        List<Playlist> playlist1 = PlaylistDAO.searchPlaylistByPlaylistId(playlist_id);
                        List<SongPlaylistData> listdata = SongPlaylistDataDAO.searchSongsIdFromPlaylistId(playlist1);
                        List<Song> list = SongDAO.showSongbySongId(listdata);
                        System.out.format("%-10s %-20s %-20s %-20s %-20s \n", "SongID", "SongName", "Duration", "Genre ID", "Artist ID");
                        System.out.println("--------------------------------------------------------------------------------------------------------");
                        for (Song song : list) {
                            System.out.format("%-10s %-20s %-20s %-20s %-20s \n",song.getSong_id(),song.getSong_name(),song.getSong_duration(),song.getGenre_id(),song.getArtist_id());
                        }
                        System.out.println(" Enter the song_id which you want removed from the selected playlist : ");
                        int song_id = sc.nextInt();
                        SongPlaylistDataDAO.removeSongsFromPlaylist(song_id,playlist_id);
                        System.out.println("Selected Song deleted from the currently selected playlist successfully");


                        String [] arg= new String[0];
                        Impl.main(arg);
                        break;
                    }
                    case 6 : {
                        String [] arg= new String[0];
                        Impl.main(arg);
                        break;
                    }
                }
                break;
            }
            case -1:{
                break;
            }

        }

    }
}
