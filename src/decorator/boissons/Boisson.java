package decorator.boissons;

public abstract class Boisson {
    String description;
    public String getDescription() {
        return description;
    }
    public abstract double cout();
}