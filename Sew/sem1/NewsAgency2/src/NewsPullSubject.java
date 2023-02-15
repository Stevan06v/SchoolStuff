

public interface NewsPullSubject {
    public Article getLatestPublishedArticle();
    public void registerObserver(NewsPullObserver observer);
    public void unregisterObserver(NewsPullObserver observer);
}
