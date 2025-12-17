package decorator;

import decorator.boissons.*;
import decorator.decorators.*;

public class Test {
    public static void main(String[] args){
        Boisson boisson = new Chocolat(new Noisette(new Espresso()));
        System.out.println(boisson.getDescription());
        System.out.println(boisson.cout());
    }
}