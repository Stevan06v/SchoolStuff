public abstract class NewsReader {
    private int articlesReadCount;

    public int getArticlesReadCount() {
        return this.articlesReadCount;
    }

    protected void incrementArticlesReadCount() {
        this.articlesReadCount++;
    }
}
