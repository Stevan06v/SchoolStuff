import java.util.Objects;

public class Track {

    private String album;
    private String artist;
    private int duration;
    private String title;
    private int year;

    public Track(String album, String artist, int duration, String title, int year) {
        this.album = album;
        this.artist = artist;
        this.duration = duration;
        this.title = title;
        this.year = year;
    }

    public String getAlbum() {
        return album;
    }

    public String getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    /**
     * Returns the song's duration in readable format (i.e. mm:ss).
     * @return A String containing the song's length.
     */
    public String getLength() {
        if(this.duration %60 < 10) return String.format("%d:0%d",(int)(this.duration / 60), this.duration %60 );
        else return String.format("%d:%d",(int)(this.duration / 60), this.duration %60 );
    }


    @Override
    public String toString() {
        //MF DOOM - Rap Snitch Knishes 2:52 (MM...FOOD) 2004
        return getArtist() + " - " + getTitle() + " " + getLength() +" (" + getAlbum() + ") " + getYear();
    }

    @Override
    public boolean equals(Object o) {
        Track track = (Track) o;
        if(track.getTitle() == this.getTitle() && track.getArtist() == this.getArtist()) return true;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return duration == track.duration && year == track.year && Objects.equals(album, track.album) && Objects.equals(artist, track.artist) && Objects.equals(title, track.title);
    }

    @Override
    public int hashCode() {
        String s = artist + title;
        int hashCode = 0;
        for (char c : s.toCharArray()) hashCode += c;
        return hashCode;
    }
}
