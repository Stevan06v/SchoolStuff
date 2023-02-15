
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewsPortalTest {
    @Test
    void testInheritance() {
        NewsPortal presseOnline = new NewsPortal();
        assertEquals(true, presseOnline instanceof NewsPullSubject);
        assertEquals(true, presseOnline instanceof NewsAgency);

        Nerd nerd = new Nerd();
        assertEquals(true, nerd instanceof NewsPullObserver);
        assertEquals(true, nerd instanceof NewsReader);

        SoccerFan soccerFan = new SoccerFan();
        assertEquals(true, soccerFan instanceof NewsPullObserver);
        assertEquals(true, soccerFan instanceof NewsReader);

        StockInvestor stockInvestor = new StockInvestor();
        assertEquals(true, stockInvestor instanceof NewsPullObserver);
        assertEquals(true, stockInvestor instanceof NewsReader);
    }

    @Test
    void testPortalWithoutObservers() {
        Nerd nerd = new Nerd();
        SoccerFan soccerFan = new SoccerFan();
        StockInvestor stockInvestor = new StockInvestor();

        NewsPortal presseOnline = new NewsPortal();

        presseOnline.readFromFile("data/presse.csv");

        int totalArticleCount = 0;
        while(presseOnline.hasMoreArticles()) {
            presseOnline.publishArticle();
            totalArticleCount++;
        }

        assertEquals(100, totalArticleCount);

        assertEquals(0, nerd.getArticlesReadCount());
        assertEquals(0, soccerFan.getArticlesReadCount());
        assertEquals(0, stockInvestor.getArticlesReadCount());
    }

    @Test
    void testPortalWithObservers() {
        Nerd nerd = new Nerd();
        SoccerFan soccerFan = new SoccerFan();
        StockInvestor stockInvestor = new StockInvestor();

        NewsPortal presseOnline = new NewsPortal();

        presseOnline.readFromFile("data/presse.csv");

        presseOnline.registerObserver(nerd);
        presseOnline.registerObserver(soccerFan);
        presseOnline.registerObserver(stockInvestor);

        int totalArticleCount = 0;
        while(presseOnline.hasMoreArticles()) {
            presseOnline.publishArticle();
            totalArticleCount++;
        }

        assertEquals(100, totalArticleCount);

        assertEquals(20, nerd.getArticlesReadCount());
        assertEquals(2, soccerFan.getArticlesReadCount());
        assertEquals(40, stockInvestor.getArticlesReadCount());
    }

    @Test
    void testMailOrderWithDuplicateObservers() {
        Nerd nerd = new Nerd();
        SoccerFan soccerFan = new SoccerFan();
        StockInvestor stockInvestor = new StockInvestor();

        NewsPortal presseOnline = new NewsPortal();

        presseOnline.readFromFile("data/presse.csv");

        presseOnline.registerObserver(nerd);
        presseOnline.registerObserver(nerd);
        presseOnline.registerObserver(nerd);
        presseOnline.registerObserver(soccerFan);
        presseOnline.registerObserver(soccerFan);
        presseOnline.registerObserver(stockInvestor);
        presseOnline.registerObserver(stockInvestor);
        presseOnline.registerObserver(stockInvestor);
        presseOnline.registerObserver(stockInvestor);

        int totalArticleCount = 0;
        while(presseOnline.hasMoreArticles()) {
            presseOnline.publishArticle();
            totalArticleCount++;
        }

        assertEquals(100, totalArticleCount);

        assertEquals(20, nerd.getArticlesReadCount());
        assertEquals(2, soccerFan.getArticlesReadCount());
        assertEquals(40, stockInvestor.getArticlesReadCount());
    }

    @Test
    void testMailOrderRegisterUnregister() {
        Nerd nerd = new Nerd();
        SoccerFan soccerFan = new SoccerFan();
        StockInvestor stockInvestor = new StockInvestor();

        NewsPortal presseOnline = new NewsPortal();

        presseOnline.readFromFile("data/presse.csv");

        presseOnline.registerObserver(nerd);
        presseOnline.registerObserver(stockInvestor);

        for(int i = 0; i < 50; i++) {
            presseOnline.publishArticle();
        }

        assertEquals(19, nerd.getArticlesReadCount());
        assertEquals(0, soccerFan.getArticlesReadCount());
        assertEquals(5, stockInvestor.getArticlesReadCount());

        presseOnline.unregisterObserver(stockInvestor);
        presseOnline.registerObserver(soccerFan);

        while(presseOnline.hasMoreArticles()) {
            presseOnline.publishArticle();
        }

        assertEquals(20, nerd.getArticlesReadCount());
        assertEquals(1, soccerFan.getArticlesReadCount());
        assertEquals(5, stockInvestor.getArticlesReadCount());
    }
}