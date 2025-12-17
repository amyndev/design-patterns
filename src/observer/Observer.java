package observer;
@FunctionalInterface
public interface Observer {
    void update(Observable o);
}
