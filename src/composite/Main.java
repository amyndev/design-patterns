package composite;

public class Main {
    public static void main(String[] args) {
        // Construction d'un arbre composite démonstratif
        Composite root = new Composite("Racine");
        Composite branchA = new Composite("Branch A");
        Composite branchB = new Composite("Branch B");

        Element leafA1 = new Element("Feuille A1");
        Element leafA2 = new Element("Feuille A2");
        Element leafB1 = new Element("Feuille B1");

        root.add(branchA);
        root.add(leafA1);
        root.add(leafA2);

        branchA.add(leafB1);
        branchA.add(new Element("Feuille B2"));

        // Affichage initial
        printTree("Structure initiale", root);

        // Suppression d'une feuille puis affichage
        System.out.println("Suppression de Feuille A2...\n");
        root.remove(leafA2);
        printTree("Après suppression de Feuille A2", root);

        // Ajout dynamique d'un composite
        System.out.println("Ajout d'un nouveau composite 'Branch C' avec une feuille...\n");
        Composite branchC = new Composite("Branch C");
        branchC.add(new Element("Feuille C1"));
        root.add(branchC);
        printTree("Après ajout de Branch C", root);
    }

    private static void printTree(String title, Composite root) {
        System.out.println("=== " + title + " ===");
        root.operation();
        System.out.println();
    }
}