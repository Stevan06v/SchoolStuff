import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

import static org.junit.jupiter.api.Assertions.*;

class MusicLibraryTest {

    @Test
    void testAddTracksFromNotExistingFile() {
        MusicLibrary musicLibrary = new MusicLibrary(31);
        MusicLibraryException ex = assertThrows(MusicLibraryException.class, () -> {
            musicLibrary.addTracksFromFile("doesnotexist.csv");
        });
        assertEquals(MusicLibraryException.IO_EXCEPTION_MESSAGE, ex.getMessage());
        assertEquals(NoSuchFileException.class, ex.getCause().getClass());
    }

    @Test
    void testAddTracksFromFiles() {
        MusicLibrary musicLibrary = new MusicLibrary(31);
        musicLibrary.addTracksFromFile("data/podcasts.csv");
        musicLibrary.addTracksFromFile("data/songs.csv");

        assertEquals(175, musicLibrary.getTrackCount());
        assertEquals(5.6451, musicLibrary.getAverageBucketSize(), 0.001);

        TrackNode node = musicLibrary.getTrackByArtistAndTitle("Texta", "Neinsager");
        assertNotNull(node);
        node = musicLibrary.getTrackByArtistAndTitle("Helene Fischer", "Atemlos");
        assertNull(node);
    }

    @Test
    void testAddDuplicateTracks() {
        Track trackA = new Track("Single Release", "Tyler, The Creator", 182, "Potato Salad", 2018);
        Track trackB = new Track("Radio Release", "Tyler, The Creator", 184, "Potato Salad", 2019);

        MusicLibrary musicLibrary = new MusicLibrary(31);

        TrackNode node = musicLibrary.addTrack(trackA);
        assertNotNull(node);

        node = musicLibrary.addTrack(trackB);
        assertNull(node);
    }

    @Test
    void testAddTrackCorrectBucketAndListIndex() {
        Track trackA = new Track("not important", "ABC", 123, "jkl", 1974);
        Track trackB = new Track("also not important", "DEF", 456, "ghi", 1997);
        Track trackC = new Track("really not important", "abc", 456, "xyz", 2011);

        assertEquals(519, trackA.hashCode());
        assertEquals(519, trackB.hashCode());
        assertEquals(657, trackC.hashCode());

        MusicLibrary musicLibrary = new MusicLibrary(17);

        //adding

        TrackNode node = musicLibrary.addTrack(trackA);
        assertEquals(9, node.getBucketIndex()); //519 % 17 = 9
        assertEquals(0, node.getListIndex());

        node = musicLibrary.addTrack(trackB);
        assertEquals(9, node.getBucketIndex());

        assertEquals(1, node.getListIndex());

        node = musicLibrary.addTrack(trackC);
        assertEquals(11, node.getBucketIndex()); //657 % 11 = 11
        assertEquals(0, node.getListIndex());

        //retrieving

        node = musicLibrary.getTrackByArtistAndTitle("ABC", "jkl");
        assertEquals(9, node.getBucketIndex());
        assertEquals(0, node.getListIndex());

        node = musicLibrary.getTrackByArtistAndTitle("DEF", "ghi");
        assertEquals(9, node.getBucketIndex());
        assertEquals(1, node.getListIndex());

        node = musicLibrary.getTrackByArtistAndTitle("abc", "xyz");
        assertEquals(11, node.getBucketIndex());
        assertEquals(0, node.getListIndex());

        //statistics
        assertEquals(3, musicLibrary.getTrackCount());
        assertEquals(0.1764, musicLibrary.getAverageBucketSize(), 0.001);
        assertEquals(2, musicLibrary.getLargestBucketSize());
    }
}