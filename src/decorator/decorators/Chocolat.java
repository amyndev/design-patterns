package decorator.decorators;

import decorator.boissons.Boisson;

public class Chocolat extends Decorator {
    public Chocolat(Boisson boisson) { super(boisson); }
    public double cout() { return 0.6 +boisson.cout() ; }
    public String getDescription() {
        return boisson.getDescription()+", Chocolat";
    }
}