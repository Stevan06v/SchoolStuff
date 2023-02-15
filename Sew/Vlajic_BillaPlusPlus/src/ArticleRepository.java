import com.sun.tools.jconsole.JConsoleContext;

import java.awt.geom.PathIterator;
import java.util.*;

public class ArticleRepository {
    private Map<Integer,Article> articles = new HashMap<>();
    //werte der map werden mit sets ausgelesen

    public boolean addArticle(Article tofu) {
        if (articles.containsKey(tofu.getBarcode()) || !Article.checkBarcode(tofu.getBarcode())) {
            return false;
        }
        articles.put(tofu.getBarcode(), tofu);
        return true;
    }

    public List<Article> getSortedArticles() {
         List<Article> allArticles= new LinkedList<>();
       // Set<Integer> keyset = articles.keySet();

        for (Article iterator:
             articles.values()) {
            allArticles.add(iterator);
        }

       Collections.sort(allArticles, new ArticleQuantityComperator());

        return allArticles;
    }

    public Article getArticleByBarcode(int barcode) {
        if (articles.containsKey(barcode)){
            return articles.get(barcode);
        }else{
            throw new RuntimeException("Error");
        }
    }

    public List<Article> getArticlesWithQuantityBelow(int i) {
        List<Article> articleList = new LinkedList<>();
        for (Article iterator : articles.values()) {
            if(iterator.getQuantity() < i){
                articleList.add(iterator);
            }
        }
        return articleList;
    }

    public List<FoodArticle> getFoodWithoutAllergens(AllergenType[] allergenTypes) {
        List<FoodArticle> withoutAny = new LinkedList<>();
        for (Article iterator : articles.values()) {
            if(iterator instanceof FoodArticle){
                FoodArticle article = (FoodArticle) iterator;
                if(!article.containsAnyAllergen(allergenTypes)){
                    withoutAny.add(article);
                }
            }
        }
        return withoutAny;
    }
}
