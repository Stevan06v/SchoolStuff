import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriathleteTest {
    Triathlete triaOberhumer;
    Triathlete triaPrem;
    Triathlete triaDurstberger;
    Triathlete triaMadlmair;
    Triathlete triaFuereder;
    Triathlete triaTohati;
    Triathlete triaSchaffelhofer;
    Triathlete triaTomani;
    Triathlete triaKiefer;
    Triathlete triaKieferMeasureError;
    Triathlete triaSchmidsberger;
    Triathlete triaAnderl;
    Triathlete triaAnderlsTwin;
    Triathlete triaUllrich;

    @BeforeEach
    void setUp() {
        this.triaOberhumer = new Triathlete("40R", "Klara Oberhumer", Time.parse("0:58:26"), TriathlonDiscipline.RUN);
        this.triaPrem = new Triathlete("34S", "Christoph Prem", Time.parse("11:59"), TriathlonDiscipline.SWIM);
        this.triaDurstberger = new Triathlete("1B", "Markus Durstberger", Time.parse("1:39:09"), TriathlonDiscipline.BIKE);
        this.triaMadlmair = new Triathlete("2B", "Andreas Madlmair", Time.parse("1:12:39"), TriathlonDiscipline.BIKE);
        this.triaFuereder = new Triathlete("34R", "Stefan Füreder", Time.parse("0:40:03"), TriathlonDiscipline.RUN);
        this.triaTohati = new Triathlete("39B", "Alexander Tohati", Time.parse("1:24:23"), TriathlonDiscipline.BIKE);
        this.triaSchaffelhofer = new Triathlete("2S", "Julia Schaffelhofer", Time.parse("14:57"), TriathlonDiscipline.SWIM);
        this.triaTomani = new Triathlete("23R", "Bianca Tomani", Time.parse("0:55:48"), TriathlonDiscipline.RUN);
        this.triaKiefer = new Triathlete("24S", "Chantal Kiefer", Time.parse("21:26"), TriathlonDiscipline.SWIM);
        this.triaKieferMeasureError = new Triathlete("24S", "Kiefer Chantal", Time.parse("21:29"), TriathlonDiscipline.SWIM);
        this.triaSchmidsberger = new Triathlete("29S", "Judith Schmidsberger", Time.parse("14:53"), TriathlonDiscipline.SWIM);
        this.triaAnderl = new Triathlete("26R", "Conrad Anderl", Time.parse("0:47:09"), TriathlonDiscipline.RUN);
        this.triaAnderlsTwin = new Triathlete("29R", "Conrad Anderls Zwilling", Time.parse("0:47:09"), TriathlonDiscipline.RUN);
        this.triaUllrich = new Triathlete("12B", "Jan Ullrich", Time.parse("Doping!!!"), TriathlonDiscipline.BIKE);
    }

    @Test
    void testInheritance() {
        assertEquals(true, this.triaAnderl instanceof Athlete);
    }

    @Test
    void testTriathlonDisciplineOrdinalsAndComparison() {
        assertEquals(0, TriathlonDiscipline.SWIM.ordinal());
        assertEquals(1, TriathlonDiscipline.BIKE.ordinal());
        assertEquals(2, TriathlonDiscipline.RUN.ordinal());

        assertEquals(true, 0 > TriathlonDiscipline.SWIM.compareTo(TriathlonDiscipline.BIKE));
        assertEquals(true, 0 > TriathlonDiscipline.SWIM.compareTo(TriathlonDiscipline.RUN));

        assertEquals(true, 0 < TriathlonDiscipline.BIKE.compareTo(TriathlonDiscipline.SWIM));
        assertEquals(true, 0 > TriathlonDiscipline.BIKE.compareTo(TriathlonDiscipline.RUN));

        assertEquals(true, 0 < TriathlonDiscipline.RUN.compareTo(TriathlonDiscipline.SWIM));
        assertEquals(true, 0 < TriathlonDiscipline.RUN.compareTo(TriathlonDiscipline.BIKE));
    }

    @Test
    void testGetters() {
        assertEquals("29S", this.triaSchmidsberger.getRaceNumber());
        assertEquals("Judith Schmidsberger", this.triaSchmidsberger.getName());
        assertEquals("00:14:53", this.triaSchmidsberger.getTime().toString());
        assertEquals(TriathlonDiscipline.SWIM, this.triaSchmidsberger.getDiscipline());

        assertEquals("1B", this.triaDurstberger.getRaceNumber());
        assertEquals("Markus Durstberger", this.triaDurstberger.getName());
        assertEquals("01:39:09", this.triaDurstberger.getTime().toString());
        assertEquals(TriathlonDiscipline.BIKE, this.triaDurstberger.getDiscipline());

        assertEquals("26R", this.triaAnderl.getRaceNumber());
        assertEquals("Conrad Anderl", this.triaAnderl.getName());
        assertEquals("00:47:09", this.triaAnderl.getTime().toString());
        assertEquals(TriathlonDiscipline.RUN, this.triaAnderl.getDiscipline());

        assertEquals("12B", this.triaUllrich.getRaceNumber());
        assertEquals("Jan Ullrich", this.triaUllrich.getName());
        assertEquals("23:59:59", this.triaUllrich.getTime().toString());
        assertEquals(TriathlonDiscipline.BIKE, this.triaUllrich.getDiscipline());
    }

    @Test
    void testToString() {
        assertEquals("SWIM #2S 00:14:57: Julia Schaffelhofer", this.triaSchaffelhofer.toString());
        assertEquals("BIKE #2B 01:12:39: Andreas Madlmair", this.triaMadlmair.toString());
        assertEquals("RUN #23R 00:55:48: Bianca Tomani", this.triaTomani.toString());
        assertEquals("BIKE #12B 23:59:59: Jan Ullrich", this.triaUllrich.toString());
    }

    @Test
    void testEquals() {
        assertEquals(this.triaKiefer, this.triaKieferMeasureError); //same race number, same logic as in athlete!
        assertNotEquals(this.triaKiefer, this.triaSchmidsberger);
    }

    @Test
    void testCompareTo() {
        assertEquals(true, 0 == triaSchmidsberger.compareTo(triaSchmidsberger));
        assertEquals(true, 0 > triaSchmidsberger.compareTo(triaKiefer));
        assertEquals(true, 0 > triaSchmidsberger.compareTo(triaKieferMeasureError));
        assertEquals(true, 0 > triaSchmidsberger.compareTo(triaMadlmair));
        assertEquals(true, 0 > triaSchmidsberger.compareTo(triaTohati));
        assertEquals(true, 0 > triaSchmidsberger.compareTo(triaUllrich));
        assertEquals(true, 0 > triaSchmidsberger.compareTo(triaFuereder));
        assertEquals(true, 0 > triaSchmidsberger.compareTo(triaAnderl));
        assertEquals(true, 0 > triaSchmidsberger.compareTo(triaAnderlsTwin));

        assertEquals(true, 0 < triaKiefer.compareTo(triaSchmidsberger));
        assertEquals(true, 0 == triaKiefer.compareTo(triaKiefer));
        assertEquals(true, 0 == triaKiefer.compareTo(triaKieferMeasureError)); //same race number!
        assertEquals(true, 0 > triaKiefer.compareTo(triaMadlmair));
        assertEquals(true, 0 > triaKiefer.compareTo(triaTohati));
        assertEquals(true, 0 > triaKiefer.compareTo(triaUllrich));
        assertEquals(true, 0 > triaKiefer.compareTo(triaFuereder));
        assertEquals(true, 0 > triaKiefer.compareTo(triaAnderl));
        assertEquals(true, 0 > triaKiefer.compareTo(triaAnderlsTwin));

        assertEquals(true, 0 < triaKieferMeasureError.compareTo(triaSchmidsberger));
        assertEquals(true, 0 == triaKieferMeasureError.compareTo(triaKiefer)); //same race number!
        assertEquals(true, 0 == triaKieferMeasureError.compareTo(triaKieferMeasureError));
        assertEquals(true, 0 > triaKieferMeasureError.compareTo(triaMadlmair));
        assertEquals(true, 0 > triaKieferMeasureError.compareTo(triaTohati));
        assertEquals(true, 0 > triaKieferMeasureError.compareTo(triaUllrich));
        assertEquals(true, 0 > triaKieferMeasureError.compareTo(triaFuereder));
        assertEquals(true, 0 > triaKieferMeasureError.compareTo(triaAnderl));
        assertEquals(true, 0 > triaKieferMeasureError.compareTo(triaAnderlsTwin));

        assertEquals(true, 0 < triaMadlmair.compareTo(triaSchmidsberger));
        assertEquals(true, 0 < triaMadlmair.compareTo(triaKiefer));
        assertEquals(true, 0 < triaMadlmair.compareTo(triaKieferMeasureError));
        assertEquals(true, 0 == triaMadlmair.compareTo(triaMadlmair));
        assertEquals(true, 0 > triaMadlmair.compareTo(triaTohati));
        assertEquals(true, 0 > triaMadlmair.compareTo(triaUllrich));
        assertEquals(true, 0 > triaMadlmair.compareTo(triaFuereder));
        assertEquals(true, 0 > triaMadlmair.compareTo(triaAnderl));
        assertEquals(true, 0 > triaMadlmair.compareTo(triaAnderlsTwin));

        assertEquals(true, 0 < triaTohati.compareTo(triaSchmidsberger));
        assertEquals(true, 0 < triaTohati.compareTo(triaKiefer));
        assertEquals(true, 0 < triaTohati.compareTo(triaKieferMeasureError));
        assertEquals(true, 0 < triaTohati.compareTo(triaMadlmair));
        assertEquals(true, 0 == triaTohati.compareTo(triaTohati));
        assertEquals(true, 0 > triaTohati.compareTo(triaUllrich));
        assertEquals(true, 0 > triaTohati.compareTo(triaFuereder));
        assertEquals(true, 0 > triaTohati.compareTo(triaAnderl));
        assertEquals(true, 0 > triaTohati.compareTo(triaAnderlsTwin));

        assertEquals(true, 0 < triaUllrich.compareTo(triaSchmidsberger));
        assertEquals(true, 0 < triaUllrich.compareTo(triaKiefer));
        assertEquals(true, 0 < triaUllrich.compareTo(triaKieferMeasureError));
        assertEquals(true, 0 < triaUllrich.compareTo(triaMadlmair));
        assertEquals(true, 0 < triaUllrich.compareTo(triaTohati));
        assertEquals(true, 0 == triaUllrich.compareTo(triaUllrich));
        assertEquals(true, 0 > triaUllrich.compareTo(triaFuereder));
        assertEquals(true, 0 > triaUllrich.compareTo(triaAnderl));
        assertEquals(true, 0 > triaUllrich.compareTo(triaAnderlsTwin));

        assertEquals(true, 0 < triaFuereder.compareTo(triaSchmidsberger));
        assertEquals(true, 0 < triaFuereder.compareTo(triaKiefer));
        assertEquals(true, 0 < triaFuereder.compareTo(triaKieferMeasureError));
        assertEquals(true, 0 < triaFuereder.compareTo(triaMadlmair));
        assertEquals(true, 0 < triaFuereder.compareTo(triaTohati));
        assertEquals(true, 0 < triaFuereder.compareTo(triaUllrich));
        assertEquals(true, 0 == triaFuereder.compareTo(triaFuereder));
        assertEquals(true, 0 > triaFuereder.compareTo(triaAnderl));
        assertEquals(true, 0 > triaFuereder.compareTo(triaAnderlsTwin));

        assertEquals(true, 0 < triaAnderl.compareTo(triaSchmidsberger));
        assertEquals(true, 0 < triaAnderl.compareTo(triaKiefer));
        assertEquals(true, 0 < triaAnderl.compareTo(triaKieferMeasureError));
        assertEquals(true, 0 < triaAnderl.compareTo(triaMadlmair));
        assertEquals(true, 0 < triaAnderl.compareTo(triaTohati));
        assertEquals(true, 0 < triaAnderl.compareTo(triaUllrich));
        assertEquals(true, 0 < triaAnderl.compareTo(triaFuereder));
        assertEquals(true, 0 == triaAnderl.compareTo(triaAnderl));
        assertEquals(true, 0 > triaAnderl.compareTo(triaAnderlsTwin));

        assertEquals(true, 0 < triaAnderlsTwin.compareTo(triaSchmidsberger));
        assertEquals(true, 0 < triaAnderlsTwin.compareTo(triaKiefer));
        assertEquals(true, 0 < triaAnderlsTwin.compareTo(triaKieferMeasureError));
        assertEquals(true, 0 < triaAnderlsTwin.compareTo(triaMadlmair));
        assertEquals(true, 0 < triaAnderlsTwin.compareTo(triaTohati));
        assertEquals(true, 0 < triaAnderlsTwin.compareTo(triaUllrich));
        assertEquals(true, 0 < triaAnderlsTwin.compareTo(triaFuereder));
        assertEquals(true, 0 < triaAnderlsTwin.compareTo(triaAnderl));
        assertEquals(true, 0 == triaAnderlsTwin.compareTo(triaAnderlsTwin));
    }
}