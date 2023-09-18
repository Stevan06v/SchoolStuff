public interface NewsPushSubject {
    public void registerObserver(NewsPushObserver observer);
    public void unregisterObserver(NewsPushObserver observer);
}
