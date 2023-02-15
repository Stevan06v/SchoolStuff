import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.PriorityQueue;

public class NewsAgency {
    private PriorityQueue<Article> articles;
    private Article latestPublishedArticle;

    public NewsAgency() {
        this.articles = new PriorityQueue<>();
    }

    public void readFromFile(String s) {
        List<String> list = null;
        try {
            Path path = Paths.get(s);
            list = Files.readAllLines(path);
            for (String iterator : list) {
                Article article = ArticleFactory.createFromString(iterator);
                if(article != null){
                    articles.add(article);
                }

                SimpleLogger.getInstance().logTrace("Article added successfully!");
            }
        } catch (Exception err) {
            // get Error cause
            SimpleLogger.getInstance().logError(err.getMessage());
        }
    }
    public boolean hasMoreArticles() {
        return articles.size() > 0;
    }

    public void publishArticle() {
        try{
            this.latestPublishedArticle = articles.poll();
            articles.remove(this.latestPublishedArticle);
        }catch (Exception err){
            SimpleLogger.getInstance().logError("Error occurred while publishing Article!");
        }
    }

    public Article getLatestPublishedArticle(){
        return this.latestPublishedArticle;
    }

    public PriorityQueue<Article> getArticles() {
        return articles;
    }

    public void setArticles(PriorityQueue<Article> articles) {
        this.articles = articles;
    }
}
