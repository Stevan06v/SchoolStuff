import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeTest {
    @Test
    void testInheritance() {
        Time time = new Time();
        assertEquals(true, time instanceof Comparable<Time>);
    }

    @Test
    void testDefaultConstructor() {
        Time time = new Time();
        assertEquals(23, time.getHours());
        assertEquals(59, time.getMinutes());
        assertEquals(59, time.getSeconds());
    }

    @Test
    void testSetters() {
        Time time = new Time();

        time.setHours(12);
        assertEquals(12, time.getHours());

        time.setMinutes(34);
        assertEquals(34, time.getMinutes());

        time.setSeconds(56);
        assertEquals(56, time.getSeconds());

        time.setHours(7);
        assertEquals(7, time.getHours());

        time.setMinutes(27);
        assertEquals(27, time.getMinutes());

        time.setSeconds(53);
        assertEquals(53, time.getSeconds());

        time.setHours(-1);
        assertEquals(23, time.getHours());

        time.setHours(123);
        assertEquals(23, time.getHours());

        time.setMinutes(-1);
        assertEquals(59, time.getMinutes());

        time.setMinutes(123);
        assertEquals(59, time.getMinutes());

        time.setSeconds(-1);
        assertEquals(59, time.getSeconds());

        time.setSeconds(123);
        assertEquals(59, time.getSeconds());
    }

    @Test
    void testTotalSeconds() {
        Time time = new Time();

        assertEquals(86399, time.getTotalSeconds());

        //This is the Ironman-WR. Impressive, right?
        time.setHours(7);
        time.setMinutes(27);
        time.setSeconds(53);

        assertEquals(26873, time.getTotalSeconds());

        time.setHours(0);
        time.setMinutes(17);
        time.setSeconds(3);

        assertEquals(1023, time.getTotalSeconds());
    }

    @Test
    void testToString() {
        Time time = new Time();

        assertEquals("23:59:59", time.toString());

        time.setHours(-1);
        time.setMinutes(123);
        time.setSeconds(45);

        assertEquals("23:59:45", time.toString());

        time.setHours(12);
        time.setMinutes(3);
        time.setSeconds(45);

        assertEquals("12:03:45", time.toString());

        time.setHours(7);
        time.setMinutes(27);
        time.setSeconds(53);

        assertEquals("07:27:53", time.toString());

        time.setHours(0);
        time.setMinutes(17);
        time.setSeconds(3);

        assertEquals("00:17:03", time.toString());
    }

    @Test
    void testParse() {
        Time time = Time.parse("1:26:12");
        assertEquals(1, time.getHours());
        assertEquals(26, time.getMinutes());
        assertEquals(12, time.getSeconds());
        assertEquals("01:26:12", time.toString());

        time = Time.parse("1234"); //not enough :
        assertEquals(23, time.getHours());
        assertEquals(59, time.getMinutes());
        assertEquals(59, time.getSeconds());

        time = Time.parse("12:34:56");
        assertEquals(12, time.getHours());
        assertEquals(34, time.getMinutes());
        assertEquals(56, time.getSeconds());
        assertEquals("12:34:56", time.toString());

        time = Time.parse("12:34:56:78"); //too many :
        assertEquals(23, time.getHours());
        assertEquals(59, time.getMinutes());
        assertEquals(59, time.getSeconds());


        time = Time.parse("17:03");
        assertEquals(0, time.getHours());
        assertEquals(17, time.getMinutes());
        assertEquals(3, time.getSeconds());
        assertEquals("00:17:03", time.toString());


        time = Time.parse("haxi:popaxi"); //definitely illegal values
        assertEquals(23, time.getHours());
        assertEquals(59, time.getMinutes());
        assertEquals(59, time.getSeconds());

        time = Time.parse("1:30");
        assertEquals(0, time.getHours());
        assertEquals(1, time.getMinutes());
        assertEquals(30, time.getSeconds());
        assertEquals("00:01:30", time.toString());

        time = Time.parse("Did not finish..."); //definitely illegal values
        assertEquals(23, time.getHours());
        assertEquals(59, time.getMinutes());
        assertEquals(59, time.getSeconds());
    }

    @Test
    void testCompare() {
        Time ironmanWr = new Time();
        ironmanWr.setHours(7);
        ironmanWr.setMinutes(27);
        ironmanWr.setSeconds(53);

        Time ironmanAustriaR = Time.parse("7:45:58");

        Time myOkayishSwimTime = Time.parse("17:03");

        assertEquals(true, 0 > ironmanWr.compareTo(ironmanAustriaR));
        assertEquals(true, 0 < ironmanWr.compareTo(myOkayishSwimTime));
        assertEquals(true, 0 == ironmanWr.compareTo(Time.parse("7:27:53")));

        assertEquals(true, 0 < ironmanAustriaR.compareTo(ironmanWr));
        assertEquals(true, 0 < ironmanAustriaR.compareTo(myOkayishSwimTime));
        assertEquals(true, 0 == ironmanAustriaR.compareTo(Time.parse("7:45:58")));

        assertEquals(true, 0 > myOkayishSwimTime.compareTo(ironmanWr));
        assertEquals(true, 0 > myOkayishSwimTime.compareTo(ironmanAustriaR));
        assertEquals(true, 0 == myOkayishSwimTime.compareTo(Time.parse("17:03")));
    }
}