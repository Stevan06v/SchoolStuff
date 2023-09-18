import jdk.jshell.spi.ExecutionControlProvider;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SportsEventTest {
    @Test
    void testConstructor() {
        SportsEvent cityNightRun = new SportsEvent("10. Linzer Sparkasse City Night Run");
        assertEquals("10. Linzer Sparkasse City Night Run", cityNightRun.getName());
        assertEquals(0, cityNightRun.getParticipantCount());
    }

    @Test
    void testAddAthlete() {
        SportsEvent cityNightRun = new SportsEvent("10. Linzer Sparkasse City Night Run");

        assertEquals(0, cityNightRun.getParticipantCount());

        Athlete athlete = AthleteFactory.createFromString("646,Kienberger Michael Mag.,FHOÖ Sportsteam,0:19:06");
        cityNightRun.addAthlete(athlete);

        assertEquals(1, cityNightRun.getParticipantCount());

        athlete = AthleteFactory.createFromString("1056,Herndler Sigrid,laufend-besser.at,0:19:02");
        cityNightRun.addAthlete(athlete);

        assertEquals(2, cityNightRun.getParticipantCount());

        try {
            athlete = AthleteFactory.createFromString("646,Kienberger Michael Mag.,FHOÖ Sportsteam,0:19:06");
            cityNightRun.addAthlete(athlete);
        }
        catch(Exception e) {
            //do nothing here - exceptions are covered in different test case
        }

        assertEquals(2, cityNightRun.getParticipantCount());

        athlete = AthleteFactory.createFromString("637,Jung Manuel,2radchaoten.com,0:18:35");
        cityNightRun.addAthlete(athlete);

        assertEquals(3, cityNightRun.getParticipantCount());

        try {
            athlete = AthleteFactory.createFromString("1056,Herndler Sigrid,laufend-besser.at,0:19:02");
            cityNightRun.addAthlete(athlete);
        }
        catch(Exception e) {
            //do nothing here - exceptions are covered in different test case
        }

        assertEquals(3, cityNightRun.getParticipantCount());

        athlete = AthleteFactory.createFromString("389,Exel Dominik,Ried In Traunkreis,0:17:51");
        cityNightRun.addAthlete(athlete);

        assertEquals(4, cityNightRun.getParticipantCount());
    }

    @Test
    void testAddDuplicateAthlete() {
        SportsEvent sportsEvent = new SportsEvent("Ironman Leonding");

        assertEquals(0, sportsEvent.getParticipantCount());

        Athlete athlete = AthleteFactory.createFromString("646,Kienberger Michael Mag.,FHOÖ Sportsteam,0:19:06");
        sportsEvent.addAthlete(athlete);

        assertEquals(1, sportsEvent.getParticipantCount());

        SportsEventException e = assertThrows(SportsEventException.class, () -> {
            Athlete duplicate = AthleteFactory.createFromString("646,Kienberger Michael Mag.,FHOÖ Sportsteam,0:19:06");
            sportsEvent.addAthlete(duplicate);
        });

        assertEquals("Athlete #646 already crossed the finish line!", e.getMessage());

        assertEquals(1, sportsEvent.getParticipantCount());

        Triathlete triaKiefer = new Triathlete("24S", "Chantal Kiefer", Time.parse("21:26"), TriathlonDiscipline.SWIM);
        sportsEvent.addAthlete(triaKiefer);

        assertEquals(2, sportsEvent.getParticipantCount());

        e = assertThrows(SportsEventException.class, () -> {
            Triathlete triaKieferMeasureError = new Triathlete("24S", "Kiefer Chantal", Time.parse("21:29"), TriathlonDiscipline.SWIM);
            sportsEvent.addAthlete(triaKieferMeasureError);
        });

        assertEquals("Athlete #24S already crossed the finish line!", e.getMessage());

        assertEquals(2, sportsEvent.getParticipantCount());
    }

    @Test
    void testReadFromFile() {
        SportsEvent cityNightRun = new SportsEvent("10. Linzer Sparkasse City Night Run");
        assertEquals(0, cityNightRun.getParticipantCount());
        cityNightRun.readFromFile("data/linz_night_run.csv");
        assertEquals(51, cityNightRun.getParticipantCount());

        SportsEvent linzTriathlon = new SportsEvent("12. Linz Triathlon");
        assertEquals(0, linzTriathlon.getParticipantCount());
        linzTriathlon.readFromFile("data/linz_tria_complete.csv");
        assertEquals(59, linzTriathlon.getParticipantCount());
    }

    @Test
    void testReadFromMissingFile() {
        SportsEventException e = assertThrows(SportsEventException.class, () -> {
            SportsEvent leondingIronman = new SportsEvent("Leondinger Ironman");
            leondingIronman.readFromFile("data/ironman_leonding.csv");
        });

        assertEquals("Exception occurred while reading the file!", e.getMessage());

    }

    @Test
    void testReadFromFileWithDuplicates() {
        SportsEventException e = assertThrows(SportsEventException.class, () -> {
            SportsEvent leondingIronman = new SportsEvent("12. Linz Triathlon");
            leondingIronman.readFromFile("data/linz_tria_complete_with_dupes.csv");
        });
    }


    @Test
    void testGetByRaceNumber() {
        SportsEvent cityNightRun = new SportsEvent("10. Linzer Sparkasse City Night Run");
        assertEquals(null, cityNightRun.getAthleteByRaceNumber("123"));
        cityNightRun.readFromFile("data/linz_night_run.csv");


        assertEquals("#659 00:17:52: Böhm Florian", cityNightRun.getAthleteByRaceNumber("659").toString());
        assertEquals(null, cityNightRun.getAthleteByRaceNumber("423"));
        assertEquals("#628 00:17:07: Graschitz Daniel LL.M.(WU)", cityNightRun.getAthleteByRaceNumber("628").toString());
        assertEquals(null, cityNightRun.getAthleteByRaceNumber("799"));
        assertEquals("#383 00:19:16: Dutzler Markus", cityNightRun.getAthleteByRaceNumber("383").toString());
        assertEquals(null, cityNightRun.getAthleteByRaceNumber("25R"));
        assertEquals("#759 00:18:24: Ahammer Daniel", cityNightRun.getAthleteByRaceNumber("759").toString());
        assertEquals(null, cityNightRun.getAthleteByRaceNumber("PROO"));
        assertEquals("#1039 00:17:55: Kaufmann Lukas", cityNightRun.getAthleteByRaceNumber("1039").toString());
        assertEquals(null, cityNightRun.getAthleteByRaceNumber("2344"));
        assertEquals("#1053 00:18:15: Schuster Bernadette", cityNightRun.getAthleteByRaceNumber("1053").toString());


    }
}