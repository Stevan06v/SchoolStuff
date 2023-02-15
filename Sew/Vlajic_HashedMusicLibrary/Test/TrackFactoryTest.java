import org.junit.jupiter.api.Test;

import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

public class TrackFactoryTest {
    @Test
    void testCreateFromEmptyString() {
        MusicLibraryException ex = assertThrows(MusicLibraryException.class, () -> {
            Track track = TrackFactory.createFromString("");
        });

        assertEquals(MusicLibraryException.PARSING_EXCEPTION_MESSAGE, ex.getMessage());
    }

    @Test
    void testCreateWithTooShortString() {
        MusicLibraryException ex = assertThrows(MusicLibraryException.class, () -> {
            Track track = TrackFactory.createFromString("Walkmania;gediegen;Texta;1997");
        });

        assertEquals(MusicLibraryException.PARSING_EXCEPTION_MESSAGE, ex.getMessage());
    }

    @Test
    void testCreateWithTooLongString() {
        MusicLibraryException ex = assertThrows(MusicLibraryException.class, () -> {
            Track track = TrackFactory.createFromString("Walkmania;gediegen;Texta;1997;291;Test;Und;Noch;Einer;123;456");
        });

        assertEquals(MusicLibraryException.PARSING_EXCEPTION_MESSAGE, ex.getMessage());
    }

    @Test
    void testCreateWithNonIntegerString() {
        MusicLibraryException ex = assertThrows(MusicLibraryException.class, () -> {
            Track track = TrackFactory.createFromString("Walkmania;gediegen;Texta;Siebenundneunzig;291");
        });

        assertEquals(MusicLibraryException.PARSING_EXCEPTION_MESSAGE, ex.getMessage());
        assertEquals(NumberFormatException.class, ex.getCause().getClass());
    }

    @Test
    void testCreateWithFalseDateFormat() {
        MusicLibraryException ex = assertThrows(MusicLibraryException.class, () -> {
            Track track = TrackFactory.createFromString("Frauenwohnungslosigkeit ++ Hans Zollner ++ Klimaallianz;https://podcast.orf.at/podcast/oe1/oe1_religionaktuell/items/di_oe1_religionaktuell_cdk_3cc8d8cad5834bd78611e7a8323fd7b6.mp3;di_oe1_religionaktuell_cdk_3cc8d8cad5834bd78611e7a8323fd7b6;Dienstag, 32 Oct 2021 15:63:12 +0200;;288;Ö1 Religion aktuell;ORF Ö1");
        });

        assertEquals(MusicLibraryException.PARSING_EXCEPTION_MESSAGE, ex.getMessage());
        assertEquals(DateTimeParseException.class, ex.getCause().getClass());
    }

    @Test
    void testCreateValidTrack() {
        Track track = TrackFactory.createFromString("(So schnö kaust gor net) schaun! ft. Attwenger;Paroli;Texta;2007;258");
        assertEquals("Paroli", track.getAlbum());
        assertEquals("Texta", track.getArtist());
        assertEquals(258, track.getDuration());
        assertEquals("4:18", track.getLength());
        assertEquals("(So schnö kaust gor net) schaun! ft. Attwenger", track.getTitle());
        assertEquals(2007, track.getYear());
        assertEquals("Texta - (So schnö kaust gor net) schaun! ft. Attwenger 4:18 (Paroli) 2007", track.toString());
    }

    @Test
    void testCreateValidPodcast() {
        PodcastTrack podcastTrack = (PodcastTrack) TrackFactory.createFromString("Covid bei Kindern, Debatte um belastete Namen;https://podcast.orf.at/podcast/oe1/oe1_wissen/items/di_oe1_wissen_cwi_0d0a7cb90e1e40a3bfb3c4c62bb09817.mp3;di_oe1_wissen_cwi_0d0a7cb90e1e40a3bfb3c4c62bb09817;Wed, 20 Oct 2021 12:12:01 +0200;Warum Kinder meist weniger stark an Covid erkranken +++ Grazer Volkskundemuseum sucht neuen Namen   +++ Klimaerwärmung verschärft Hunger in Afrika;287;Ö1 Wissen aktuell;ORF Ö1");
        assertEquals("Ö1 Wissen aktuell", podcastTrack.getAlbum());
        assertEquals("ORF Ö1", podcastTrack.getArtist());
        assertEquals(287, podcastTrack.getDuration());
        assertEquals("4:47", podcastTrack.getLength());
        assertEquals("Covid bei Kindern, Debatte um belastete Namen", podcastTrack.getTitle());
        assertEquals(2021, podcastTrack.getYear());
        assertEquals(10, podcastTrack.getMonth());
        assertEquals(20, podcastTrack.getDay());
        assertEquals("Warum Kinder meist weniger stark an Covid erkranken +++ Grazer Volkskundemuseum sucht neuen Namen   +++ Klimaerwärmung verschärft Hunger in Afrika", podcastTrack.getDescription());
        assertEquals("Warum Kinder meist weniger stark an C...", podcastTrack.getTruncatedDescription());
        assertEquals("ORF Ö1 - Covid bei Kindern, Debatte um belastete Namen 4:47 (Ö1 Wissen aktuell) 2021-10-20 Description: Warum Kinder meist weniger stark an C...", podcastTrack.toString());
    }
}