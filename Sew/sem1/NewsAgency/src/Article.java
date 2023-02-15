import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Article implements Comparable<Article>{
    private String title;
    private String description;
    private LocalDateTime  date ;
    private String url;
    private NewsCategory category;

    public Article(String title, String description, LocalDateTime date, String url, NewsCategory category) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.url = url;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return String.format("(%s) %s - veroeffentlicht %s", this.category+"",this.title,"09.11.2019 17:52" );
    }

    public NewsCategory getCategory() {
        return category;
    }

    @Override
    public int compareTo(Article o) {
        if(this.date.compareTo(o.date) < 0){
            return -1;
        }else if(this.date.compareTo(o.date) > 0){
            return 1;
        }else{
            return 0;
        }
    }

    public String getPublishingDateTime() {

        int day = this.date.getDayOfMonth();
        int year = this.date.getYear();
        int month = this.date.getMonthValue();

        int hour = this.date.getHour();
        int minute = this.date.getMinute();
        int seconds = this.date.getSecond();

        // (condition) ? (what happens if true) : (what happens if false);
        String builder = String.format("%d-%s-%s/1-52-00",
                year, month > 10 ? month : "0"+month,
                day > 10 ? day : "0"+day,
                hour > 10 ? hour : "0"+hour,
                minute > 10 ? minute : "0"+minute,
                seconds > 10 ? seconds : "0"+seconds
                );

        return builder;
    }
}
