
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.PriorityQueue;

public class NewsAgency {
    PriorityQueue <Article> articles = new PriorityQueue();


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

    public Article getLatestPublishesArticle(){
        try{
            Article latestPublished = articles.poll();
            return latestPublished;
        }catch (Exception err){
            System.out.println(err.getCause().getMessage());
            return null;
        }

    }
    public boolean hasMoreArticles(){
        return articles.size() > 0;
    }

    public void publishArticle(){
        try{
            articles.poll();
        }catch (Exception err){
            System.out.println(err.getCause().getMessage());
        }
    }

}
