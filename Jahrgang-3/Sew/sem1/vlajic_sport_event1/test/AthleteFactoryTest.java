import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AthleteFactoryTest {
    @Test
    void testValidAthletes() {
        Athlete athlete = AthleteFactory.createFromString("1053,Schuster Bernadette,SK VÖEST,0:18:15");
        assertEquals("1053",  athlete.getRaceNumber());
        assertEquals("Schuster Bernadette",  athlete.getName());
        assertEquals("00:18:15",  athlete.getTime().toString());
        assertEquals(Athlete.class, athlete.getClass());

        athlete = AthleteFactory.createFromString("529,Michal Lewandowski MSc,Linz,0:18:53");
        assertEquals("529",  athlete.getRaceNumber());
        assertEquals("Michal Lewandowski MSc",  athlete.getName());
        assertEquals("00:18:53",  athlete.getTime().toString());
        assertEquals(Athlete.class, athlete.getClass());

        athlete = AthleteFactory.createFromString("1940,The Flash,DC Comics,Too fast to measure!");
        assertEquals("1940",  athlete.getRaceNumber());
        assertEquals("The Flash",  athlete.getName());
        assertEquals("23:59:59",  athlete.getTime().toString());
        assertEquals(Athlete.class, athlete.getClass());
    }

    @Test
    void testValidTriathletes() {
        Athlete athlete = AthleteFactory.createFromString("1S,Jakob Durstberger,Dursti MP,18:34,SWIM");
        Triathlete triathlete = (Triathlete)athlete;
        assertEquals("1S",  triathlete.getRaceNumber());
        assertEquals("Jakob Durstberger",  triathlete.getName());
        assertEquals("00:18:34",  triathlete.getTime().toString());
        assertEquals(TriathlonDiscipline.SWIM,  triathlete.getDiscipline());
        assertEquals(Triathlete.class, triathlete.getClass());

        athlete = AthleteFactory.createFromString("25B,Harald Kindermann,FH Oberösterreich / Campus Steyr,1:26:12,BIKE");
        triathlete = (Triathlete)athlete;
        assertEquals("25B",  triathlete.getRaceNumber());
        assertEquals("Harald Kindermann",  triathlete.getName());
        assertEquals("01:26:12",  triathlete.getTime().toString());
        assertEquals(TriathlonDiscipline.BIKE,  triathlete.getDiscipline());
        assertEquals(Triathlete.class, triathlete.getClass());

        athlete = AthleteFactory.createFromString("25R,Werner Wetzlinger,FH Oberösterreich / Campus Steyr,0:47:50,RUN");
        triathlete = (Triathlete)athlete;
        assertEquals("25R",  triathlete.getRaceNumber());
        assertEquals("Werner Wetzlinger",  triathlete.getName());
        assertEquals("00:47:50",  triathlete.getTime().toString());
        assertEquals(TriathlonDiscipline.RUN,  triathlete.getDiscipline());
        assertEquals(Triathlete.class, triathlete.getClass());

        athlete = AthleteFactory.createFromString("13S,Carlo Pedersoli,Bud Spencer & Terence Hill,DNF,SWIM");
        triathlete = (Triathlete)athlete;
        assertEquals("13S",  triathlete.getRaceNumber());
        assertEquals("Carlo Pedersoli",  triathlete.getName());
        assertEquals("23:59:59",  triathlete.getTime().toString());
        assertEquals(TriathlonDiscipline.SWIM,  triathlete.getDiscipline());
        assertEquals(Triathlete.class, triathlete.getClass());
    }

    @Test
    void testNull() {
        SportsEventException e = assertThrows(SportsEventException.class, () -> {
            Athlete athlete = AthleteFactory.createFromString(null);
        });

        assertEquals("Exception occured while parsing line!", e.getMessage());
    }

    @Test
    void testEmpty() {
        SportsEventException e = assertThrows(SportsEventException.class, () -> {
            Athlete athlete = AthleteFactory.createFromString("");
        });

        assertEquals("Exception occured while parsing line!", e.getMessage());
    }

    @Test
    void testTooShort() {
        SportsEventException e = assertThrows(SportsEventException.class, () -> {
            Athlete athlete = AthleteFactory.createFromString("25R,Werner Wetzlinger,0:47:50");
        });

        assertEquals("Exception occured while parsing line!", e.getMessage());
    }

    @Test
    void testTooLong() {
        SportsEventException e = assertThrows(SportsEventException.class, () -> {
            Athlete athlete = AthleteFactory.createFromString("25B,MALE,Harald Kindermann,FH Oberösterreich / Campus Steyr,1:26:12,BIKE");
        });

        assertEquals("Exception occured while parsing line!", e.getMessage());
    }
}