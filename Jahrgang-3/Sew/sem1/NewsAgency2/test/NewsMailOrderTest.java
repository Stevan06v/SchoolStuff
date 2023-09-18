import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NewsMailOrderTest {
    @Test
    void testInheritance() {
        NewsMailOrder mailOrder = new NewsMailOrder();
        assertEquals(true, mailOrder instanceof NewsPushSubject);
        assertEquals(true, mailOrder instanceof NewsAgency);


        CarLover carLover = new CarLover();
        assertEquals(true, carLover instanceof NewsPushObserver);
        assertEquals(true, carLover instanceof NewsReader);

        OctoberSubscriber octoberSubscriber = new OctoberSubscriber();
        assertEquals(true, octoberSubscriber instanceof NewsPushObserver);
        assertEquals(true, octoberSubscriber instanceof NewsReader);

        YogaMom yogaMom = new YogaMom();
        assertEquals(true, yogaMom instanceof NewsPushObserver);
        assertEquals(true, yogaMom instanceof NewsReader);
    }

    @Test
    void testObservers() {
        CarLover carLover = new CarLover();
        OctoberSubscriber octoberSubscriber = new OctoberSubscriber();
        YogaMom yogaMom = new YogaMom();


        Article article = ArticleFactory.createFromString("Wunsch nach einem normalen Land [premium];https://www.diepresse.com/5718543/Rumaenien_Wunsch-nach-einem-normalen-Land?from=rss;Bei der Präsidentenwahl am Sonntag gilt der eher trocken wirkende Amtsinhaber, Klaus Johannis, als deutlicher Favorit: Er ist für viele Rumänen der einzige Garant für Stabilität.;2019-11-09T13:34:00;POLITICS");

        carLover.update(article);
        octoberSubscriber.update(article);
        yogaMom.update(article);

        assertEquals(0, carLover.getArticlesReadCount());
        assertEquals(0, octoberSubscriber.getArticlesReadCount());
        assertEquals(0, yogaMom.getArticlesReadCount());

        article = ArticleFactory.createFromString("Was wir von Japan lernen können [premium];https://www.diepresse.com/5715875/Automarkt_Was-wir-von-Japan-lernen-koennen?from=rss;Inmitten des europäischen (und österreichischen) SUV-Booms nach US-Vorbild lohnt sich ein Blick ins Autoland Japan. Dort hat die Gesellschaft mit ihrem Fuhrpark ein vielleicht besseres Arrangement getroffen  mit traditionell kleinen, leichten, leisen und sparsamen Autos.;2019-11-06T11:07:00;LIFESTYLE");

        carLover.update(article);
        octoberSubscriber.update(article);
        yogaMom.update(article);

        assertEquals(1, carLover.getArticlesReadCount());
        assertEquals(0, octoberSubscriber.getArticlesReadCount());
        assertEquals(1, yogaMom.getArticlesReadCount());

        article = ArticleFactory.createFromString("E-Auto-Absatz: Besorgniserregende Unterschiede in Europa;https://www.diepresse.com/5713827/EAutoAbsatz_Besorgniserregende-Unterschiede-in-Europa?from=rss;Die Einführung von E-Fahrzeugen hänge eindeutig mit dem Lebensstandard in einem Land zusammen, ortet der europäische Fachverband.;2019-10-29T10:50:00;LIFESTYLE");

        carLover.update(article);
        octoberSubscriber.update(article);
        yogaMom.update(article);

        assertEquals(2, carLover.getArticlesReadCount());
        assertEquals(1, octoberSubscriber.getArticlesReadCount());
        assertEquals(2, yogaMom.getArticlesReadCount());

        article = ArticleFactory.createFromString("Hans Niessl ist neuer BSO-Präsident   ;https://www.diepresse.com/5718998/HundstorferNachfolge_Hans-Niessl-ist-neuer-BSOPraesident?from=rss;Burgenlands ehemaliger Landeshauptmann wurde zum Präsidenten der Bundessportorganisation gewählt.;2019-11-08T14:05:00;SPORTS");

        carLover.update(article);
        octoberSubscriber.update(article);
        yogaMom.update(article);

        assertEquals(2, carLover.getArticlesReadCount());
        assertEquals(1, octoberSubscriber.getArticlesReadCount());
        assertEquals(3, yogaMom.getArticlesReadCount());

        article = ArticleFactory.createFromString("Twitter stoppt Werbung mit politischen Inhalten;https://www.diepresse.com/5714764/Praesidentenwahl_Twitter-stoppt-Werbung-mit-politischen-Inhalten?from=rss;Twitter verbreitet weltweit keine politischen Inhalte mehr als Werbung. Wir glauben, dass Reichweite für politische Botschaften verdient werden muss, statt erkauft zu werden.;2019-10-30T21:08:00;TECH");

        carLover.update(article);
        octoberSubscriber.update(article);
        yogaMom.update(article);

        assertEquals(2, carLover.getArticlesReadCount());
        assertEquals(2, octoberSubscriber.getArticlesReadCount());
        assertEquals(3, yogaMom.getArticlesReadCount());
    }

    @Test
    void testMailOrderWithoutObservers() {
        CarLover carLover = new CarLover();
        OctoberSubscriber octoberSubscriber = new OctoberSubscriber();
        YogaMom yogaMom = new YogaMom();

        NewsMailOrder presseVersand = new NewsMailOrder();

        presseVersand.readFromFile("data/presse.csv");

        int totalArticleCount = 0;
        while(presseVersand.hasMoreArticles()) {
            presseVersand.publishArticle();
            totalArticleCount++;
        }

        assertEquals(100, totalArticleCount);

        assertEquals(0, carLover.getArticlesReadCount());
        assertEquals(0, octoberSubscriber.getArticlesReadCount());
        assertEquals(0, yogaMom.getArticlesReadCount());
    }

    @Test
    void testMailOrderWithObservers() {
        CarLover carLover = new CarLover();
        OctoberSubscriber octoberSubscriber = new OctoberSubscriber();
        YogaMom yogaMom = new YogaMom();

        NewsMailOrder presseVersand = new NewsMailOrder();

        presseVersand.readFromFile("data/presse.csv");

        presseVersand.registerObserver(carLover);
        presseVersand.registerObserver(octoberSubscriber);
        presseVersand.registerObserver(yogaMom);

        int totalArticleCount = 0;
        while(presseVersand.hasMoreArticles()) {
            presseVersand.publishArticle();
            totalArticleCount++;
        }

        assertEquals(100, totalArticleCount);

        assertEquals(12, carLover.getArticlesReadCount());
        assertEquals(16, octoberSubscriber.getArticlesReadCount());
        assertEquals(40, yogaMom.getArticlesReadCount());
    }

    @Test
    void testMailOrderWithDuplicateObservers() {
        CarLover carLover = new CarLover();
        OctoberSubscriber octoberSubscriber = new OctoberSubscriber();
        YogaMom yogaMom = new YogaMom();

        NewsMailOrder presseVersand = new NewsMailOrder();

        presseVersand.readFromFile("data/presse.csv");

        presseVersand.registerObserver(carLover);
        presseVersand.registerObserver(carLover);
        presseVersand.registerObserver(octoberSubscriber);
        presseVersand.registerObserver(yogaMom);
        presseVersand.registerObserver(yogaMom);
        presseVersand.registerObserver(yogaMom);

        int totalArticleCount = 0;
        while(presseVersand.hasMoreArticles()) {
            presseVersand.publishArticle();
            totalArticleCount++;
        }

        assertEquals(100, totalArticleCount);

        assertEquals(12, carLover.getArticlesReadCount());
        assertEquals(16, octoberSubscriber.getArticlesReadCount());
        assertEquals(40, yogaMom.getArticlesReadCount());
    }

    @Test
    void testMailOrderRegisterUnregister() {
        CarLover carLover = new CarLover();
        OctoberSubscriber octoberSubscriber = new OctoberSubscriber();
        YogaMom yogaMom = new YogaMom();

        NewsMailOrder presseVersand = new NewsMailOrder();

        presseVersand.readFromFile("data/presse.csv");

        presseVersand.registerObserver(carLover);
        presseVersand.registerObserver(octoberSubscriber);

        for(int i = 0; i < 20; i++) {
            presseVersand.publishArticle();
        }

        assertEquals(4, carLover.getArticlesReadCount());
        assertEquals(11, octoberSubscriber.getArticlesReadCount());
        assertEquals(0, yogaMom.getArticlesReadCount());

        presseVersand.unregisterObserver(carLover);
        presseVersand.registerObserver(yogaMom);

        while(presseVersand.hasMoreArticles()) {
            presseVersand.publishArticle();
        }

        assertEquals(4, carLover.getArticlesReadCount());
        assertEquals(16, octoberSubscriber.getArticlesReadCount());
        assertEquals(25, yogaMom.getArticlesReadCount());
    }
}