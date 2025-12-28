package decorator.boissons;

public class Sumatra extends Boisson {
    public Sumatra() {
        description = "Sumatra";
    }

    @Override
    public double cout() {
        return 6;
    }
}
