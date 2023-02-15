import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArticleRepositoryTest {
    @Test
    public void testAddArticleBarcode() {
        ArticleRepository billaPlusPlus = new ArticleRepository();
        FoodArticle tofu = new FoodArticle("Tofu", 12345679, 100, new AllergenType[] {AllergenType.F,AllergenType.L});

        assertEquals(false, billaPlusPlus.addArticle(tofu));

        tofu = new FoodArticle("Tofu", 12345678, 100, new AllergenType[] {AllergenType.F,AllergenType.L});
        assertEquals(true, billaPlusPlus.addArticle(tofu));
    }

    @Test
    public void testAddArticle() {
        ArticleRepository billaPlusPlus = new ArticleRepository();
        FoodArticle tofu = new FoodArticle("Tofu", 12345678, 100, new AllergenType[] {AllergenType.F,AllergenType.L});

        assertEquals(true, billaPlusPlus.addArticle(tofu));
        assertEquals(true, billaPlusPlus.addArticle(new NonFoodArticle("USB Charger", 38571246, 20, 12)));
        assertEquals(true, billaPlusPlus.addArticle(new FoodArticle("Peas", 29582143, 150, new AllergenType[] {AllergenType.P})));
        assertEquals(true, billaPlusPlus.addArticle(new NonFoodArticle("Raspberry Pi", 45342323, 20, 24)));
        assertEquals(true, billaPlusPlus.addArticle(new FoodArticle("Pasta", 19359218, 200, new AllergenType[] {AllergenType.A})));

        assertEquals(false, billaPlusPlus.addArticle(new FoodArticle("Mustard", 12345678, 50, new AllergenType[] {AllergenType.M})));
        assertEquals(false, billaPlusPlus.addArticle(new FoodArticle("Burger Buns", 19359218, 25, new AllergenType[] {AllergenType.A})));
    }

    @Test
    public void testGetSortedArticles() {
        ArticleRepository billaPlusPlus = new ArticleRepository();
        FoodArticle tofu = new FoodArticle("Tofu", 12345678, 100, new AllergenType[] {AllergenType.F,AllergenType.L});
        FoodArticle pils = new FoodArticle("Grieskirchner Pils", 47104718, 96, new AllergenType[] {AllergenType.A, AllergenType.O});

        assertEquals(true, billaPlusPlus.addArticle(tofu));
        assertEquals(true, billaPlusPlus.addArticle(new NonFoodArticle("USB Charger", 38571246, 20, 12)));
        assertEquals(true, billaPlusPlus.addArticle(new FoodArticle("Peas", 29582143, 150, new AllergenType[] {AllergenType.P})));
        assertEquals(true, billaPlusPlus.addArticle(new NonFoodArticle("Raspberry Pi", 45342323, 20, 24)));
        assertEquals(true, billaPlusPlus.addArticle(new FoodArticle("Pasta", 19359218, 200, new AllergenType[] {AllergenType.A})));
        assertEquals(true, billaPlusPlus.addArticle(pils));

        List<Article> articles = billaPlusPlus.getSortedArticles();
        assertEquals(pils, articles.get(0));
        assertEquals("Pasta", articles.get(1).getArticleName());
        assertEquals("Peas", articles.get(2).getArticleName());
        assertEquals("Raspberry Pi", articles.get(3).getArticleName());
        assertEquals(tofu, articles.get(4));
        assertEquals("USB Charger", articles.get(5).getArticleName());
    }

    @Test
    public void testGetArticleByBarcode() {
        ArticleRepository billaPlusPlus = new ArticleRepository();
        FoodArticle tofu = new FoodArticle("Tofu", 12345678, 100, new AllergenType[] {AllergenType.F,AllergenType.L});

        assertEquals(true, billaPlusPlus.addArticle(tofu));
        assertEquals(true, billaPlusPlus.addArticle(new NonFoodArticle("USB Charger", 38571246, 20, 12)));
        assertEquals(true, billaPlusPlus.addArticle(new FoodArticle("Peas", 29582143, 150, new AllergenType[] {AllergenType.P})));
        assertEquals(true, billaPlusPlus.addArticle(new NonFoodArticle("Raspberry Pi", 45342323, 20, 24)));
        assertEquals(true, billaPlusPlus.addArticle(new FoodArticle("Pasta", 19359218, 200, new AllergenType[] {AllergenType.A})));

        assertEquals("Pasta", billaPlusPlus.getArticleByBarcode(19359218).getArticleName());
        assertEquals("Peas", billaPlusPlus.getArticleByBarcode(29582143).getArticleName());
        assertEquals("Raspberry Pi", billaPlusPlus.getArticleByBarcode(45342323).getArticleName());
        assertEquals(tofu, billaPlusPlus.getArticleByBarcode(12345678));
        assertEquals("USB Charger", billaPlusPlus.getArticleByBarcode(38571246).getArticleName());

    }

    @Test
    public void testGetArticleByBarcodeWithDuplicates() {
        ArticleRepository billaPlusPlus = new ArticleRepository();
        FoodArticle tofu = new FoodArticle("Tofu", 12345678, 100, new AllergenType[] {AllergenType.F,AllergenType.L});

        assertEquals(true, billaPlusPlus.addArticle(tofu));
        assertEquals(true, billaPlusPlus.addArticle(new NonFoodArticle("USB Charger", 38571246, 20, 12)));
        assertEquals(true, billaPlusPlus.addArticle(new FoodArticle("Peas", 29582143, 150, new AllergenType[] {AllergenType.P})));
        assertEquals(true, billaPlusPlus.addArticle(new NonFoodArticle("Raspberry Pi", 45342323, 20, 24)));
        assertEquals(true, billaPlusPlus.addArticle(new FoodArticle("Pasta", 19359218, 200, new AllergenType[] {AllergenType.A})));

        assertEquals(false, billaPlusPlus.addArticle(new FoodArticle("Mustard", 12345678, 50, new AllergenType[] {AllergenType.M})));
        assertEquals(false, billaPlusPlus.addArticle(new FoodArticle("Burger Buns", 19359218, 25, new AllergenType[] {AllergenType.A})));

        assertEquals(tofu, billaPlusPlus.getArticleByBarcode(12345678));
        assertEquals("Pasta", billaPlusPlus.getArticleByBarcode(19359218).getArticleName());
    }

    @Test
    public void testGetFoodWithoutAllergen() {
        ArticleRepository billaPlusPlus = new ArticleRepository();
        FoodArticle tofu = new FoodArticle("Tofu", 12345678, 100, new AllergenType[] {AllergenType.F,AllergenType.L});
        FoodArticle peas = new FoodArticle("Peas", 29582143, 150, new AllergenType[] {AllergenType.P});
        FoodArticle pasta = new FoodArticle("Pasta", 19359218, 200, new AllergenType[] {AllergenType.A});
        FoodArticle pils = new FoodArticle("Grieskirchner Pils", 47104718, 96, new AllergenType[] {AllergenType.A, AllergenType.O});

        assertEquals(true, billaPlusPlus.addArticle(tofu));
        assertEquals(true, billaPlusPlus.addArticle(new NonFoodArticle("USB Charger", 38571246, 20, 12)));
        assertEquals(true, billaPlusPlus.addArticle(peas));
        assertEquals(true, billaPlusPlus.addArticle(new NonFoodArticle("Raspberry Pi", 45342323, 20, 24)));
        assertEquals(true, billaPlusPlus.addArticle(pasta));
        assertEquals(true, billaPlusPlus.addArticle(pils));

        List<FoodArticle> foodArticles = billaPlusPlus.getFoodWithoutAllergens(new AllergenType[] {AllergenType.A, AllergenType.P});
        assertEquals(1,foodArticles.size());
        assertEquals(tofu,foodArticles.get(0));

        foodArticles = billaPlusPlus.getFoodWithoutAllergens(new AllergenType[] {AllergenType.A});
        assertEquals(2,foodArticles.size());
        assertEquals(true,foodArticles.contains(tofu));
        assertEquals(true, foodArticles.contains(peas));

        foodArticles = billaPlusPlus.getFoodWithoutAllergens(new AllergenType[] {AllergenType.F, AllergenType.L,  AllergenType.M, AllergenType.N});
        assertEquals(3,foodArticles.size());
        assertEquals(true,foodArticles.contains(pasta));
        assertEquals(true, foodArticles.contains(peas));
        assertEquals(true,foodArticles.contains(pils));
    }

    @Test
    public void testGetProductsWithQuantityBelow() {
        ArticleRepository billaPlusPlus = new ArticleRepository();
        FoodArticle tofu = new FoodArticle("Tofu", 12345678, 100, new AllergenType[] {AllergenType.F,AllergenType.L});
        FoodArticle peas = new FoodArticle("Peas", 29582143, 150, new AllergenType[] {AllergenType.P});
        FoodArticle pasta = new FoodArticle("Pasta", 19359218, 200, new AllergenType[] {AllergenType.A});
        FoodArticle pils = new FoodArticle("Grieskirchner Pils", 47104718, 96, new AllergenType[] {AllergenType.A, AllergenType.O});
        Article usbCharger = new NonFoodArticle("USB Charger", 38571246, 21, 12);
        Article raspberry = new NonFoodArticle("Raspberry Pi", 45342323, 20, 24);

        assertEquals(true, billaPlusPlus.addArticle(tofu));
        assertEquals(true, billaPlusPlus.addArticle(usbCharger));
        assertEquals(true, billaPlusPlus.addArticle(peas));
        assertEquals(true, billaPlusPlus.addArticle(raspberry));
        assertEquals(true, billaPlusPlus.addArticle(pasta));
        assertEquals(true, billaPlusPlus.addArticle(pils));

        List<Article> articles = billaPlusPlus.getArticlesWithQuantityBelow(300);
        assertEquals(6,articles.size());
        assertEquals(raspberry, articles.get(0));
        assertEquals(usbCharger, articles.get(1));
        assertEquals(pils, articles.get(2));
        assertEquals(tofu, articles.get(3));
        assertEquals(peas, articles.get(4));
        assertEquals(pasta, articles.get(5));

        articles = billaPlusPlus.getArticlesWithQuantityBelow(25);
        assertEquals(2,articles.size());
        assertEquals(raspberry, articles.get(0));
        assertEquals(usbCharger, articles.get(1));

        articles = billaPlusPlus.getArticlesWithQuantityBelow(115);
        assertEquals(4,articles.size());
        assertEquals(raspberry, articles.get(0));
        assertEquals(usbCharger, articles.get(1));
        assertEquals(pils, articles.get(2));
        assertEquals(tofu, articles.get(3));

        articles = billaPlusPlus.getArticlesWithQuantityBelow(199);
        assertEquals(5,articles.size());
        assertEquals(raspberry, articles.get(0));
        assertEquals(usbCharger, articles.get(1));
        assertEquals(pils, articles.get(2));
        assertEquals(tofu, articles.get(3));
        assertEquals(peas, articles.get(4));
    }
}