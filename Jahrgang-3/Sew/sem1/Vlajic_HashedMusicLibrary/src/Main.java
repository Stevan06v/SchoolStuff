import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException{

        MusicLibrary lib = new MusicLibrary(17);
        Track trackA = new Track("not important", "ABC", 123, "jkl", 1974);
        Track trackB = new Track("also not important", "DEF", 456, "ghi", 1997);
        Track trackC = new Track("really not important", "abc", 456, "xyz", 2011);

        lib.addTrack(trackA);
        lib.addTrack(trackB);
        lib.addTrack(trackC);


        System.out.println(lib.getTrackCount());

        /*
        Date date = new Date();

        MusicLibrary musicLibrary = new MusicLibrary(31);

        musicLibrary.addTracksFromFile("data/podcasts.csv");
        musicLibrary.addTracksFromFile("data/songs.csv");

        musicLibrary.printAllTracks();

        System.out.format("Largest bucket size: %d %n", musicLibrary.getLargestBucketSize());
        System.out.format("Average bucket size: %.2f %n", musicLibrary.getAverageBucketSize());

        TrackNode nodeMeinBaby = musicLibrary.getTrackByArtistAndTitle("Texta", "Mein Baby");
        System.out.format("Found song \"%s\" in bucket %d at position %d.%n", nodeMeinBaby.getTrack().getTitle(), nodeMeinBaby.getBucketIndex(), nodeMeinBaby.getListIndex());

        TrackNode nodeGeschichteBgld = musicLibrary.getTrackByArtistAndTitle("ORF Ö1", "Geschiche des Burgenlandes - Teil 3");
        System.out.format("Found episode \"%s\" in bucket %d at position %d.%n", nodeGeschichteBgld.getTrack().getTitle(), nodeGeschichteBgld.getBucketIndex(), nodeGeschichteBgld.getListIndex());
   */
    }
}
