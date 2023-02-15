import java.awt.font.MultipleMaster;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Locale;

public class TrackFactory {


    //Potato Salad;Tyler The Creator;182;PotatoSalad;
    //Walkmania;gediegen;Texta;1997;291;Test;Und;Noch;Einer;123;456

    private static TrackFactory instance = new TrackFactory();


    private TrackFactory(){}

    public static Track createFromString(String trackRaw) {
        String[] strValues = trackRaw.split(";");

        // halo;198;hey;ok
        // str[0]=halo
        // str[1]=196
        // str[2]=ok


        if (strValues.length < 5 || strValues.length > 8) throw new MusicLibraryException("Exception occurred while parsing line!", new RuntimeException()); // check if size is correct

        // "      hallo      "
        for (String iterator : strValues) {
            iterator.strip();
        }

        try {

            for (String iterator : strValues) {// check if all params contain values
                if (iterator == "") {
                    throw new MusicLibraryException("Exception occurred while parsing line!", new RuntimeException());
                }
            }
            if (strValues.length == 5) {
                //create and init
                String title = strValues[0];
                String album = strValues[1];
                String arist = strValues[2];

                int year=0;
                try {
                    year = Integer.parseInt(strValues[3]);
                }catch (NumberFormatException ex){
                    throw new MusicLibraryException("Exception occurred while parsing line!",ex);
                }



                int duration = Integer.parseInt(strValues[4]);

                return new Track(album, arist, duration, title, year);

            } else if (strValues.length == 8) {
                String album = strValues[6];
                String artist = strValues[7];
                int duration = Integer.parseInt(strValues[5]);
                String description = strValues[4];
                String title = strValues[0];


                LocalDate date;
                int year;
                int month;
                int day;

                try{
                     DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("EEE, d MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
                     date = LocalDate.parse(strValues[3], dateTimeFormatter);
                     year = date.getYear();
                     month = date.getMonth().getValue();
                     day = date.getDayOfMonth();
                }catch (DateTimeParseException ex ){
                    throw new MusicLibraryException("error occured", ex);
                }

                return new PodcastTrack(album, artist, duration, title, year, month, day, description);
            }
        } catch (DateTimeParseException err) {
            throw new MusicLibraryException(":(", err);
        }

        return null;
    }
}
