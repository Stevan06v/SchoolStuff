

public class MainNewsAgency {

    public static void main(String[] args) {
	    SimpleLogger.getInstance().logTrace("Starting program.");

        SimpleLogger.getInstance().logTrace("Creating news agency \"DiePresse\" and loading articles.");
        NewsAgency diePresse = new NewsAgency();
        diePresse.readFromFile("data/kresse.csv");
        diePresse.readFromFile("data/presse.csv");

        SimpleLogger.getInstance().logTrace("Starting to publish articles.");
        while(diePresse.hasMoreArticles()) {
            diePresse.publishArticle();
            Article article = diePresse.getLatestPublishedArticle();

            SimpleLogger.getInstance().logTrace("Published article: " + article);
        }
        SimpleLogger.getInstance().logTrace("No articles left.");

        SimpleLogger.getInstance().logTrace("Finished program.");
    }
}
