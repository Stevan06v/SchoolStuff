public class NewsMailOrder extends NewsAgency implements NewsPushSubject {



    public void readFromFile(String path){

    }

    @Override
    public void registerObserver(NewsPushObserver observer) {

    }
    @Override
    public void unregisterObserver(NewsPushObserver observer) {

    }

    public boolean hasMoreArticles() {
        return true;
    }

    public void publishArticle() {
    }
}
