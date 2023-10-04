import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrackTest {
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void testTrackConstructorAndLength() {
        Track track = new Track("Madvillainy", "MF DOOM", 130, "All Caps", 2004);
        assertEquals("Madvillainy", track.getAlbum());
        assertEquals("MF DOOM", track.getArtist());
        assertEquals(130, track.getDuration());
        assertEquals("2:10", track.getLength());
        assertEquals("All Caps", track.getTitle());
        assertEquals(2004, track.getYear());

        track = new Track("Potato Salad", "Tyler, The Creator", 182, "Potato Salad", 2018);
        assertEquals("Potato Salad", track.getAlbum());
        assertEquals("Tyler, The Creator", track.getArtist());
        assertEquals(182, track.getDuration());
        assertEquals("3:02", track.getLength());
        assertEquals("Potato Salad", track.getTitle());
        assertEquals(2018, track.getYear());
    }

    @Test
    void testTrackToString() {
        Track track = new Track("MM...FOOD", "MF DOOM", 172, "Rap Snitch Knishes", 2004);
        assertEquals("MF DOOM - Rap Snitch Knishes 2:52 (MM...FOOD) 2004", track.toString());

        track = new Track("Vollendete Tatsachen", "Markante Handlungen", 277, "Höhere Gewalt", 2005);
        assertEquals("Markante Handlungen - Höhere Gewalt 4:37 (Vollendete Tatsachen) 2005", track.toString());
    }

    @Test
    void testPodcastConstructorAndLength() {
        PodcastTrack podcastTrack = new PodcastTrack("Ö1 Betrifft: Geschichte", "ORF Ö1", 292, "Aufklärung Habsburger, Teil 5", 2021, 9, 17, "Aufklärung Habsburger, Teil 5Der Weg der Habsburgischen Länder in die Moderne. Erzählt von dem Historiker Franz Fillafer.");
        assertEquals("Ö1 Betrifft: Geschichte", podcastTrack.getAlbum());
        assertEquals("ORF Ö1", podcastTrack.getArtist());
        assertEquals(292, podcastTrack.getDuration());
        assertEquals("4:52", podcastTrack.getLength());
        assertEquals("Aufklärung Habsburger, Teil 5", podcastTrack.getTitle());
        assertEquals(2021, podcastTrack.getYear());
        assertEquals(9, podcastTrack.getMonth());
        assertEquals(17, podcastTrack.getDay());
        assertEquals("Aufklärung Habsburger, Teil 5Der Weg der Habsburgischen Länder in die Moderne. Erzählt von dem Historiker Franz Fillafer.", podcastTrack.getDescription());
        assertEquals("Aufklärung Habsburger, Teil 5Der Weg ...", podcastTrack.getTruncatedDescription());

        podcastTrack = new PodcastTrack("Schwammerltalk", "HTL Leonding", 1260, "Folge 6 - Unsere SchülerInnenvertretung - \"Worte statt Taten\"", 2021, 10, 15, "Was unsere SchülerInnenvertretung für das kommende Schuljahr geplant hat und wie sie ihre Vorhaben umsetzen will, erfahr ihr in der heutigen Episode.");
        assertEquals("Schwammerltalk", podcastTrack.getAlbum());
        assertEquals("HTL Leonding", podcastTrack.getArtist());
        assertEquals(1260, podcastTrack.getDuration());
        assertEquals("21:00", podcastTrack.getLength());
        assertEquals("Folge 6 - Unsere SchülerInnenvertretung - \"Worte statt Taten\"", podcastTrack.getTitle());
        assertEquals(2021, podcastTrack.getYear());
        assertEquals(10, podcastTrack.getMonth());
        assertEquals(15, podcastTrack.getDay());
        assertEquals("Was unsere SchülerInnenvertretung für das kommende Schuljahr geplant hat und wie sie ihre Vorhaben umsetzen will, erfahr ihr in der heutigen Episode.", podcastTrack.getDescription());
        assertEquals("Was unsere SchülerInnenvertretung für...", podcastTrack.getTruncatedDescription());
    }

    @Test
    void testPodcastTruncateDescription() {
        PodcastTrack podcastTrack = new PodcastTrack("Schwammerltalk", "HTL Leonding", 1260, "Folge 7 - Nur ein Test", 2021, 10, 21, "aaaaabbbbbcccccdddddeeeeefffffggggghhhhhiiiii");
        assertEquals("aaaaabbbbbcccccdddddeeeeefffffggggghhhhhiiiii", podcastTrack.getDescription());
        assertEquals("aaaaabbbbbcccccdddddeeeeefffffggggghh...", podcastTrack.getTruncatedDescription());

        podcastTrack = new PodcastTrack("Schwammerltalk", "HTL Leonding", 1260, "Folge 8 - Noch ein Test", 2021, 10, 21, "Kurze Beschreibung ohne Schnitt.");
        assertEquals("Kurze Beschreibung ohne Schnitt.", podcastTrack.getDescription());
        assertEquals("Kurze Beschreibung ohne Schnitt.", podcastTrack.getTruncatedDescription());
    }

    @Test
    void testPodcastToString() {
        PodcastTrack podcastTrack = new PodcastTrack("Ö1 Betrifft: Geschichte", "ORF Ö1", 292, "Aufklärung Habsburger, Teil 5", 2021, 9, 17, "Aufklärung Habsburger, Teil 5Der Weg der Habsburgischen Länder in die Moderne. Erzählt von dem Historiker Franz Fillafer.");
        assertEquals("ORF Ö1 - Aufklärung Habsburger, Teil 5 4:52 (Ö1 Betrifft: Geschichte) 2021-9-17 Description: Aufklärung Habsburger, Teil 5Der Weg ...", podcastTrack.toString());

        podcastTrack = new PodcastTrack("Schwammerltalk", "HTL Leonding", 1260, "Folge 6 - Unsere SchülerInnenvertretung - \"Worte statt Taten\"", 2021, 10, 15, "Was unsere SchülerInnenvertretung für das kommende Schuljahr geplant hat und wie sie ihre Vorhaben umsetzen will, erfahr ihr in der heutigen Episode.");
        assertEquals("HTL Leonding - Folge 6 - Unsere SchülerInnenvertretung - \"Worte statt Taten\" 21:00 (Schwammerltalk) 2021-10-15 Description: Was unsere SchülerInnenvertretung für...", podcastTrack.toString());
    }

    @Test
    void testHashCodes() {
        Track track = new Track("not important", "ABC", 123, "def", 1997);
        assertEquals((65+66+67+100+101+102), track.hashCode());

        track = new Track("Labor Days", "Aesop Rock", 246, "Daylight", 2001);
        assertEquals(1757, track.hashCode());

        track = new PodcastTrack("Schwammerltalk", "HTL Leonding", 1260, "Folge 8 - Noch ein Test", 2021, 10, 21, "Kurze Beschreibung ohne Schnitt.");
        assertEquals(2958, track.hashCode());
    }

    @Test
    void testEquals() {
        Track trackA = new Track("Single Release", "Tyler, The Creator", 182, "Potato Salad", 2018);
        Track trackB = new Track("Radio Release", "Tyler, The Creator", 184, "Potato Salad", 2019);

        assertEquals(trackA, trackB);
    }
}