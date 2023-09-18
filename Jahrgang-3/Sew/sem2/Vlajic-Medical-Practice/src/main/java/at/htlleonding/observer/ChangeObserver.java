package at.htlleonding.observer;

@FunctionalInterface
public interface ChangeObserver<T> {
    public void update(T subject);
}