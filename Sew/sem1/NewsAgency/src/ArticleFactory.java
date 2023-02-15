import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class ArticleFactory {
    public static Article createFromString(String input) {
        //WAC bezahlt teures Lehrgeld;https://www.diepresse.com/5718741/Europa-League_WAC-bezahlt-teures-Lehrgeld?from=rss;Die Wolfsberger wollen die Hoffnungen aber auch nach dem 0:3 gegen Istanbul Basaksehir nicht aufgeben. Coach Struber: Wir wissen, was wir bewerkstelligen können.;2019-11-08T08:45:00;SPORTS
        /*
        *     private String title;
        *     private String description;
        *     private LocalDateTime date;
        *     private String url;
        *     private NewsCategory category;
        *
        * */

        String title="";
        String description="";

        String url="";
        NewsCategory category;

        try {
            String[] attributes = input.split(";");
            if (attributes.length != 5) return null;
            System.out.println(attributes);


            for (int i = 0; i < attributes.length; i++) {
                attributes[i] = attributes[i].strip();
            }

            System.out.println(attributes.length);

            title = attributes[0];
            url = attributes[1];
            description = attributes[2];

            LocalDateTime publishingDateTime = LocalDateTime.parse(attributes[3], DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));

            category = NewsCategory.valueOf(attributes[4]);


            SimpleLogger.getInstance().logTrace("Article creation successfull!");
            return new Article(title, description, publishingDateTime, url, category);

        }catch (Exception e){
            SimpleLogger.getInstance().logError("Error occured while parsing String");
        }
        return null;
    }

}
