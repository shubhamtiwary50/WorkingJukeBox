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
        System.out.println("=========================================================================================");
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
              //  System.out.println(" -1 : Exit ");

//                    System.out.println(" Please enter your choice");
                int userchoice = sc.nextInt();
              //  while (){
                switch (userchoice) {
                    case 1: {
                        List<Song> songlist = SongDAO.displayAll();
                        System.out.format("%-10s %-20s %-20s %-20s %-20s \n", "SongID", "SongName", "Duration", "Genre ID", "Artist ID");
                        System.out.println("--------------------------------------------------------------------------------------------------------");
                        for (Song song : songlist) {
                            System.out.format("%-10s %-20s %-20s %-20s %-20s \n",song.getSong_id(),song.getSong_name(),song.getSong_duration(),song.getGenre_id(),song.getArtist_id());
                        }

//                        for (Song song : songlist) {
//                            System.out.println(song);
//                        }
//                        System.out.println("Do you want to play a song ? : Yes or No");
//                        String playsongchoice= sc.nextLine();
//                        Thread.sleep(5);
//                        if (playsongchoice.equalsIgnoreCase("Yes"))
//                        {
                            System.out.println("Enter the song ID which you want to play : ");
                             int song_id = sc.nextInt();
                             String song_path = SongDAO.fetchSongPathBySongId(song_id);
                             songOperation.PlaySong(song_path);
                        //}
//                        String [] arg= new String[0];
//                        Impl.main(arg);
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
                        //System.out.println(songlist);

                        System.out.println("Enter the song ID which you want to play : ");
                             int song_id = sc.nextInt();
                            String song_path = SongDAO.fetchSongPathBySongId(song_id);
                             songOperation.PlaySong(song_path);

//                        String [] arg= new String[0];
//                        Impl.main(arg);
                        break;

                    }

                    case 3: {
                        System.out.println(" Enter the artist name : ");
                        //sc.nextLine();
                        String artistName = sc.nextLine();
                        List<Artist> artistList = ArtistDAO.displayByArtistName(artistName);
                        List<Song> songlist = SongDAO.displayingSongByArtistID(artistList);

                        System.out.format("%-10s %-20s %-20s %-20s %-20s \n", "SongID", "SongName", "Duration", "Genre ID", "Artist ID");
                        System.out.println("--------------------------------------------------------------------------------------------------------");
                        for (Song song : songlist) {
                            System.out.format("%-10s %-20s %-20s %-20s %-20s \n",song.getSong_id(),song.getSong_name(),song.getSong_duration(),song.getGenre_id(),song.getArtist_id());
                        }

                       // System.out.println(songlist);

                        System.out.println("Enter the song ID which you want to play : ");
                        int song_id = sc.nextInt();
                        String song_path = SongDAO.fetchSongPathBySongId(song_id);
                        songOperation.PlaySong(song_path);

//                        String [] arg= new String[0];
//                        Impl.main(arg);
                        break;
                    }

                    case 4: {
                        System.out.println(" Enter the genre name : ");
                        sc.nextLine();
                        String genreName = sc.nextLine();
                        List<Genre> genreList = GenreDAO.displayByGenre(genreName);
                        System.out.println(genreList);
                        List<Song> songList = SongDAO.displayingSongByGenreID(genreList);

                        System.out.format("%-10s %-20s %-20s %-20s %-20s \n", "SongID", "SongName", "Duration", "Genre ID", "Artist ID");
                        System.out.println("--------------------------------------------------------------------------------------------------------");
                        for (Song song : songList) {
                            System.out.format("%-10s %-20s %-20s %-20s %-20s \n",song.getSong_id(),song.getSong_name(),song.getSong_duration(),song.getGenre_id(),song.getArtist_id());
                        }

                       // System.out.println(songList);

                        System.out.println("Enter the song ID which you want to play : ");
                        int song_id = sc.nextInt();
                        String song_path = SongDAO.fetchSongPathBySongId(song_id);
                        songOperation.PlaySong(song_path);

//                        String [] arg= new String[0];
//                        Impl.main(arg);
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
//                System.out.println(" 6 : Delete an entire existing playlist ");
//                System.out.println(" 7 : Return to previous menu ");
              //  System.out.println(" -1 : Exit ");

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
                            //System.out.println(playlist1);
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
                            //System.out.println(playlist1);
                        }
                        System.out.println(" Enter the Playlist ID into which you want to insert song");
                        int playlist_id= sc.nextInt();
                        List<Song> songlist = SongDAO.displayAll();
                        System.out.format("%-10s %-20s %-20s %-20s %-20s \n", "SongID", "SongName", "Duration", "Genre ID", "Artist ID");
                        System.out.println("--------------------------------------------------------------------------------------------------------");
                        for (Song song : songlist) {
                            System.out.format("%-10s %-20s %-20s %-20s %-20s \n",song.getSong_id(),song.getSong_name(),song.getSong_duration(),song.getGenre_id(),song.getArtist_id());
                        }
//                        for (Song song : songlist) {
//                             System.out.println(song);
//                        }
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
                            //System.out.println(playlist1);
                        }
//                        for (Playlist playlist1 : playlist) {
//                            System.out.println(" Playlist Id : "+""+playlist1.getPlaylist_id()+" Playlist Name : "+""+playlist1.getName_0f_playlist());
//                        }
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
                        String [] arg= new String[0];
                        Impl.main(arg);
                        break;
                    }
                    case 5: {
                        List <Playlist> playlist = PlaylistDAO.showAllExistingPlaylists();
                        System.out.format("%-20s %-20s \n", "PlayList ID", "PlayList Name");
                        System.out.println("-----------------------------------------------");
                        for (Playlist playlist1 : playlist) {
                            System.out.format("%-20s %-20s \n",playlist1.getPlaylist_id(),playlist1.getName_0f_playlist());
                            //System.out.println(playlist1);
                        }
//                        for (Playlist playlist1 : playlist) {
//                            System.out.println(" Playlist Id : "+""+playlist1.getPlaylist_id()+" Playlist Name : "+""+playlist1.getName_0f_playlist());
//                        }
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

//                        System.out.format("%-20s %-20s \n", "PlayList ID", "PlayList Name");
//                        System.out.println("-----------------------------------------------");
//                        for (Playlist playlist2 : playlist) {
//                            System.out.format("%-20s %-20s \n",playlist2.getPlaylist_id(),playlist2.getName_0f_playlist());
//                            //System.out.println(playlist1);
//                        }
                        String [] arg= new String[0];
                        Impl.main(arg);
                        break;
                    }
                    case 6: {
                        List <Playlist> playlist = PlaylistDAO.showAllExistingPlaylists();
                        System.out.format("%-20s %-20s \n", "PlayList ID", "PlayList Name");
                        System.out.println("-----------------------------------------------");
                        for (Playlist playlist1 : playlist) {
                            System.out.format("%-20s %-20s \n",playlist1.getPlaylist_id(),playlist1.getName_0f_playlist());
                            //System.out.println(playlist1);
                        }
//                        for (Playlist playlist1 : playlist) {
//                            System.out.println(" Playlist Id : "+""+playlist1.getPlaylist_id()+" Playlist Name : "+""+playlist1.getName_0f_playlist());
//                        }
                        System.out.println("Enter the id of the playlist you want deleted :");
                        int playlist_id = sc.nextInt();
                        PlaylistDAO.deleteAnExistingPlaylist(playlist_id);
                    }
                    case 7 : {
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
