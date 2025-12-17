package decorator.boissons;

public class Espresso extends Boisson {
    public Espresso(){
        description="Espresso";
    }
    public double cout() {
        return 1.99;
    }
}