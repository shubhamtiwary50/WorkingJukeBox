package Data;

public class Playlist {
    private String name_0f_playlist;

    private int playlist_id;

    public Playlist(int playlist_id,String name_0f_playlist) {
        this.playlist_id = playlist_id;
        this.name_0f_playlist = name_0f_playlist;
    }

    public String getName_0f_playlist() {
        return name_0f_playlist;
    }

    public void setName_0f_playlist(String name_0f_playlist) {
        this.name_0f_playlist = name_0f_playlist;
    }

    public int getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(int playlist_id) {
        this.playlist_id = playlist_id;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                " playlist_id=" + playlist_id +
                ", name_0f_playlist='" + name_0f_playlist  +
                '}';
    }
}
