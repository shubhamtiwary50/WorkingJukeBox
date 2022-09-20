package operations;
import Data.Playlist;
import Data.Song;
import Main.Impl;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SongOperation {

    List<Song> songslist;
    int songIndex;

    public void PlaySong(List<Song> songslist) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        Scanner scanner = new Scanner(System.in);
        this.songslist = songslist;
        for (int i = 0; i < songslist.size(); i++) {
            songIndex = i;
            PlaySong(songslist.get(i).getSong_path());
        }
    }

    public void PlaySong(String songPath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        Scanner scanner = new Scanner(System.in);
        try {
            String path = songPath;
            File file = new File(path);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            String response = "";

            while (!response.equals("Q")) {
                System.out.println("P = Play, T= Pause, S=Stop, L=Loop, R = Reset, Q = Quit,N = NextSong,O = previousSong,M = MAIN MENU");
                System.out.print("Enter your choice: ");

                response = scanner.next();
                response = response.toUpperCase();


                switch (response) {
                    case ("P"): {
                        clip.start();
                        break;
                    }
                    case ("T"): {
                        clip.stop();
                        break;
                    }
                    case ("S"): {
                        clip.setMicrosecondPosition(0);
                        clip.stop();
                        break;
                    }
                    case ("L"): {
                        clip.start();
                        clip.loop(Clip.LOOP_CONTINUOUSLY);
                    }

                    case ("R"):
                        clip.setMicrosecondPosition(0);
                        break;

                    case ("Q"):
                        clip.close();
                        break;
                    case ("N"):
                        songIndex =songIndex + 1;
                        clip.close();
                        PlaySong(songslist.get(songIndex).getSong_path());
                        break;
                    case ("O"):
                        songIndex =songIndex- 1;
                        clip.close();
                        PlaySong(songslist.get(songIndex).getSong_path());
                        break;
                    case("M"):
                        String[] arg = new String[0];
                        Impl.main(arg);
                        break;

                    default:
                        System.err.println("PLEASE SELECT THE CORRECT OPTION");

                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
