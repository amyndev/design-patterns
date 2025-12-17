package decorator.decorators;

import decorator.boissons.Boisson;

public class Noisette extends Decorator{

    public Noisette(Boisson boisson){
        super(boisson);
    }
    public double cout() { return 0.4 +boisson.cout() ; }
    public String getDescription() {
        return boisson.getDescription()+", Caramel";
    }
}
