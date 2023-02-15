public class PodcastTrack extends Track{

    private static int TRUNCATED_DESCRIPTION_LENGTH = 40;
    private static String ELLIPSIS_TEXT = "...";

    private String description;
    private int day;
    private int month;

    public PodcastTrack(String album, String artist, int duration, String title, int year, int month, int day, String description) {
        super(album, artist, duration, title, year);
        this.description = description;
        this.day = day;
        this.month = month;
    }

    @Override
    public String toString() {
        return getArtist() + " - " + getTitle() + " " + getLength() +" (" + getAlbum() + ") " + getYear() + "-" + getMonth() + "-" + getDay() + " Description: " + getTruncatedDescription();
    }

    public String getDescription() {
        return description;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    /**
     * Returns the truncated description with ellipsis (...), if it's longer than the constant maximum length.
     * @return The truncated description.
     */
    public String getTruncatedDescription() {
        if(this.description.length() > this.TRUNCATED_DESCRIPTION_LENGTH) return this.description.substring(0, 40-this.ELLIPSIS_TEXT.length()) + this.ELLIPSIS_TEXT;
        else return this.description;
    }


}
