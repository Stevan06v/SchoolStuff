import java.time.LocalDateTime;

public class Article {
    private String title;
    private String description;
    private LocalDateTime publishingDate;
    private String url;
    private NewsCategory category;

    public Article(String title, String description, LocalDateTime publishingDate, String url, NewsCategory category) {
        this.title = title;
        this.description = description;
        this.publishingDate = publishingDate;
        this.url = url;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(LocalDateTime publishingDate) {
        this.publishingDate = publishingDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public NewsCategory getCategory() {
        return category;
    }

    public void setCategory(NewsCategory category) {
        this.category = category;
    }
}
