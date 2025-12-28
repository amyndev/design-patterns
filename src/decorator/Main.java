package decorator;

import decorator.boissons.*;
import decorator.decorators.*;

public class Main {
    public static void main(String[] args){
        Boisson b1 = new Chocolat(new Noisette(new Espresso()));
        Boisson b2 = new Caramel(new Deca());
        Boisson b3 = new Noisette(new Sumatra());

        printBoisson(b1);
        printBoisson(b2);
        printBoisson(b3);
    }

    private static void printBoisson(Boisson b) {
        System.out.println(b.getDescription());
        System.out.printf("Prix : %.2f%n", b.cout());
        System.out.println();
    }
}