package Data;


public class Song {
    private String song_name;
    private int song_id;

    public Song(int song_id,String song_name, Double song_duration,String song_path, String genre_id, String artist_id) {
        this.song_name = song_name;
        this.song_id = song_id;
        this.song_path = song_path;
        this.song_duration = song_duration;
        this.genre_id = genre_id;
        this.artist_id = artist_id;
    }

    private  String song_path;
    private Double song_duration;

//    private  Genre genre_id;
//    private  Artist artist_id;

    private String genre_id;
    private String artist_id;


//    public Song(int song_id, String song_name, Double song_duration, String song_path;String genre_id, String artist_id,)
//    {
//        this.song_name = song_name;
//        this.song_id = song_id;
//        this.song_duration = song_duration;
//        this.song_path= song_path;
//        this.genre_id = genre_id;
//        this.artist_id = artist_id;
//
//    }

    public  String getSong_path(){return song_path;}

    public  void setSong_path(){
        this.song_path=song_path;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }

    public Double getSong_duration() {
        return song_duration;
    }

    public void setSong_duration(Double song_duration) {
        this.song_duration = song_duration;
    }

    public String getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(String genre_id) {
        this.genre_id = genre_id;
    }

    public String getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(String artist_id) {
        this.artist_id = artist_id;
    }
    @Override
    public String toString() {
        return "Song{" +
                "song_name='" + song_name + '\'' +
                ", song_id=" + song_id +
                ", song_duration=" + song_duration +
                ", genre_id='" + genre_id + '\'' +
                ", artist_id='" + artist_id + '\'' +
                '}';
    }
}
