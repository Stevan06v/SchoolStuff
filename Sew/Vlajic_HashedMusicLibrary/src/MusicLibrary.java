import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MusicLibrary {
    private TrackNode[] buckets;

    /**
     * Creates an empty music library.
     * @param bucketCount The number of hash buckets to create.
     */
    public MusicLibrary(int bucketCount) {
        buckets = new TrackNode[bucketCount];
    }

    /**
     * Adds a track to the music library's hash table - but only if it's not already in the library!
     * @param track The track to add.
     * @return The node of the added track for checking its correctness. Returns null if duplicate.
     */
    public TrackNode addTrack(Track track) {
        if(this.getTrackByArtistAndTitle(track.getArtist(), track.getTitle()) != null) return null;

        int bucketIndex = track.hashCode() % buckets.length;

        if(buckets[bucketIndex] == null) {
            buckets[bucketIndex] = new TrackNode(track, bucketIndex, 0);
            return buckets[bucketIndex];
        }

        while(buckets[bucketIndex].hasNext()){
            buckets[bucketIndex] = buckets[bucketIndex].getNext();
        }
        buckets[bucketIndex].setNext(new TrackNode(track, bucketIndex, buckets[bucketIndex].getListIndex()+1));
        return buckets[bucketIndex].getNext();
    }

    /**
     * Reads lines from a file (while ignoring the first header row) adds them to the library.
     * Throws a MusicLibraryException when something goes wrong.
     * @param filePath The path to the .csv file containing the tracks.
     */

    public void addTracksFromFile(String filePath) {
        try {
            Path file = Paths.get(filePath);
            List<String> lines = Files.readAllLines(file);

            for (String iterator : lines) {
                this.addTrack(TrackFactory.createFromString(iterator));
            }

        }catch (IOException ex){
            throw new MusicLibraryException("file not found", ex );
        }

    }
    /**
     * Prints all the tracks in the library grouped by their hash buckets.
     */
    public void printAllTracks() {
        for (TrackNode iterator : buckets) {
            if(iterator != null){
               while(iterator.hasNext()){
                   System.out.println(iterator.toString());
               }
            }else {
                continue;
            }
        }
    }

    /**
     * Get the total number of stored tracks.
     * @return The total number of tracks in the library.
     */
    public int getTrackCount() {
        int trackCount = 0;
        for (TrackNode node:buckets) {
            if(node == null) continue;
            trackCount++;
            while(node.getNext() != null){
                trackCount++;
                node = node.getNext();
            }
        }
        return trackCount-1;
    }

    /**
     * Determines the largest hash bucket's item count.
     * @return The number of tracks in the largest bucket.
     */
    public int getLargestBucketSize() {
        int trackCount = 0;
        int largest = 0;

        for (TrackNode iterator : buckets) {
            if(iterator == null) continue;
            trackCount++;
            while(iterator.hasNext()){
                trackCount++;
                iterator = iterator.getNext();
            }
            if(trackCount > largest) largest = trackCount;
        }
        return largest-1;
    }

    /**
     * Determines the average item count per hash bucket.
     * @return The average item count per hash bucket.
     */
    public double getAverageBucketSize() {
        DecimalFormat df = new DecimalFormat("#.###");
        return  Double.parseDouble(df.format(this.getTrackCount() / (double) buckets.length));
    }

    /**
     * Searches for the track with the specified artist and title.
     * @param artist The artist we're looking for.
     * @param title The track title we're looking for.
     * @return The node containing the track - or null if not found.
     */
    public TrackNode getTrackByArtistAndTitle(String artist, String title) {
        Track track = new Track("", artist, 0, title, 000);

        int bucketIndex = track.hashCode() % buckets.length;


        if(buckets[bucketIndex] == null) return null;

        if(buckets[bucketIndex].getTrack().equals(track)) return buckets[bucketIndex];

        while(buckets[bucketIndex].getNext() != null){
            if(buckets[bucketIndex].hasNext()) return buckets[bucketIndex].getNext();
            buckets[bucketIndex] = buckets[bucketIndex].getNext();
        }

        return null;
    }
}
