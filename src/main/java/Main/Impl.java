package Main;
import DAO.*;
import Data.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Impl {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Hello ! Please make a choice ");
        System.out.println(" 1 : I want to play a song");
        System.out.println(" 2 : I want to create a playlist first and add songs into it");
        System.out.println(" -1 : Exit ");


        int choice = sc.nextInt();
        sc.nextLine();


        switch (choice) {
            case 1: {

                System.out.println(" 1 : Display list of all songs");
                System.out.println(" 2 : Display by song name");
                System.out.println(" 3 : Display by Artist name");
                System.out.println(" 4 : Display by Genre type");
                System.out.println(" 5 : Goto previous menu");
                System.out.println(" -1 : Exit ");

//                    System.out.println(" Please enter your choice");
                int userchoice = sc.nextInt();

                switch (userchoice) {
                    case 1: {
                        List<Song> songlist = SongDAO.displayAll();
                        System.out.println("----All Songs-----");
                        for (Song song : songlist) {
                            System.out.println(song);
                        }
                        break;
                    }

                    case 2: {
                        sc.nextLine();
                        System.out.println(" Enter the name of the song you want : ");
                        String songName = sc.nextLine();
                        List<Song> songlist = SongDAO.displayBySongName(songName);
                        System.out.println(songlist);
                        break;
                    }

                    case 3: {
                        System.out.println(" Enter the artist name : ");
                        sc.nextLine();
                        String artistName = sc.nextLine();
                        List<Artist> artistList = ArtistDAO.displayByArtistName(artistName);
                        System.out.println(artistList);
                        List<Song> songlist = SongDAO.displayingSongByArtistID(artistList);
                        System.out.println(songlist);
                        break;
                    }

                    case 4: {
                        System.out.println(" Enter the genre name : ");
                        sc.nextLine();
                        String genreName = sc.nextLine();
                        List<Genre> genreList = GenreDAO.displayByGenre(genreName);
                        System.out.println(genreList);
                        List<Song> songList = SongDAO.displayingSongByGenreID(genreList);
                        System.out.println(songList);
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
                System.out.println(" 1 : Create your own playlist");
                System.out.println(" 2 : Show all existing playlists");
                System.out.println(" 3 : Add songs to an exiting playlist");
                System.out.println(" 4 : Show all songs in an existing playlist");
                System.out.println(" 5 : Delete any song from a existing playlist ");
                System.out.println(" 6 : Delete an entire existing playlist ");
                System.out.println(" 7 : Return to previous menu ");
                System.out.println(" -1 : Exit ");

                int userchoice = sc.nextInt();
                switch (userchoice) {
                    case 1: {
                        PlaylistDAO.creatingAPlaylist();
                        break;
                    }

                    case 2: {
                        List <Playlist> playlist = PlaylistDAO.showAllExistingPlaylists();
                        for (Playlist playlist1 : playlist) {
                            System.out.println(playlist1);
                        }
                        break;
                    }

                    case 3: {
                             List<Playlist> playlist = PlaylistDAO.showAllExistingPlaylists();
                        for (Playlist playlist1 : playlist) {
                            System.out.println(playlist1);
                        }
                        System.out.println(" Enter the Playlist ID into which you want to insert song");
                        int playlist_id= sc.nextInt();
                        List<Song> songlist = SongDAO.displayAll();
                        for (Song song : songlist) {
                            System.out.println(song);
                        }
                        System.out.println(" Enter the Song ID which you want to insert");
                        int song_id= sc.nextInt();
                        SongPlaylistDataDAO.addSongToAnExistingPlaylist(song_id,playlist_id);
                        break;
                    }

                    case 4: {
                        List <Playlist> playlist = PlaylistDAO.showAllExistingPlaylists();
                        for (Playlist playlist1 : playlist) {
                            System.out.println(" Playlist Id : "+""+playlist1.getPlaylist_id()+" Playlist Name : "+""+playlist1.getName_0f_playlist());
                        }
                        System.out.println(" Enter the Playlist ID into which you view : ");
                        int playlist_id = sc.nextInt();
                        List<Playlist> playlist1 = PlaylistDAO.searchPlaylistByPlaylistId(playlist_id);
                        List<SongPlaylistData> listdata = SongPlaylistDataDAO.searchSongsIdFromPlaylistId(playlist1);
                        List<Song> list = SongDAO.showSongbySongId(listdata);
                        for (Song song : list) {
                            System.out.println(song);
                        }
                        break;
                    }
                    case 5: {
                        List <Playlist> playlist = PlaylistDAO.showAllExistingPlaylists();
                        for (Playlist playlist1 : playlist) {
                            System.out.println(" Playlist Id : "+""+playlist1.getPlaylist_id()+" Playlist Name : "+""+playlist1.getName_0f_playlist());
                        }
                        System.out.println("Enter the playlist_id from which you remove a song. ");
                        int playlist_id = sc.nextInt();
                        List<Playlist> playlist1 = PlaylistDAO.searchPlaylistByPlaylistId(playlist_id);
                        List<SongPlaylistData> listdata = SongPlaylistDataDAO.searchSongsIdFromPlaylistId(playlist1);
                        List<Song> list = SongDAO.showSongbySongId(listdata);
                        for (Song song : list) {
                            System.out.println(song);
                        }
                        System.out.println(" Enter the song_id which you want removed from the selected playlist : ");
                        int song_id = sc.nextInt();
                        SongPlaylistDataDAO.removeSongsFromPlaylist(song_id,playlist_id);
                        break;
                    }
                    case 6: {
                        List <Playlist> playlist = PlaylistDAO.showAllExistingPlaylists();
                        for (Playlist playlist1 : playlist) {
                            System.out.println(" Playlist Id : "+""+playlist1.getPlaylist_id()+" Playlist Name : "+""+playlist1.getName_0f_playlist());
                        }
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

        }

    }
}
