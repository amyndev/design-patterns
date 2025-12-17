package decorator.decorators;

import decorator.boissons.Boisson;

public class Caramel extends Decorator {
    public Caramel(Boisson boisson) { super(boisson); }
    public double cout() { return 0.22 +boisson.cout() ; }
    public String getDescription() {
        return boisson.getDescription()+", Caramel";
    }
}