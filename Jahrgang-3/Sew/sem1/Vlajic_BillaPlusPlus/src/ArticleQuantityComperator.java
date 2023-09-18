import java.util.Comparator;

public class ArticleQuantityComperator implements Comparator<Article> {


    @Override
    public int compare(Article o1, Article o2) {
        return Integer.compare(o1.getQuantity(), o2.getQuantity());
    }
}
