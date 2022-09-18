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
        System.out.println(" 2: I want to create a playlist first and add songs into it");
        System.out.println(" -1 : Exit ");


        int choice = sc.nextInt();
        sc.nextLine();


        switch (choice) {
            case 1: {

                System.out.println(" 1 : Display list of all songs");
                System.out.println(" 2 : Display by song name");
                System.out.println(" 3 : Display by Artist name");
                System.out.println(" 4 : Display by Genre type");
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
                        //  System.out.println(songlist);
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
                }
                break;
            }


            case 2: {
                System.out.println(" 1 : Create your own playlist");
                System.out.println(" 2 : Show all existing playlists");
                System.out.println(" 3 : Add songs to an exiting playlist");
                System.out.println(" 4 : Show all songs in an existing playlist");
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
                        List<SongPlaylistData> listdata = SongPlaylistDataDAO.searchSongsIdFromPlaylistId(playlist);
                        List<Song> list = SongDAO.showSongbySongId(listdata);
                        for (Song song : list) {
                            System.out.println(song);
                        }
                        break;
                    }

                }
                break;
            }
        }

    }
}
