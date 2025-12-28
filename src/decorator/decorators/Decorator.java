package decorator.decorators;

import decorator.boissons.Boisson;

public abstract class Decorator extends Boisson {
    protected Boisson boisson;

    public Decorator(Boisson boisson) {
        this.boisson = boisson;
    }

    public abstract String getDescription();
}