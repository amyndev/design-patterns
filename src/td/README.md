# TD1 : Design Patterns Exercises

## Exercice 1 : Diagrammes de Classes

- **1.1 Figure** : Pattern **Composite** (Figures géométriques)
- **1.2 Plugin** : Pattern **Strategy** (Algorithmes variables)
- **1.3 Composant** : Pattern **Decorator** (Ajout de responsabilités)
- **1.4 Joueur** : Pattern **Observer** (Notification de score)

## Exercice 2 : Framework de Traitement d'Images


Ce framework implémente les patterns suivants conformément à l'énoncé :

1.  **Strategy Pattern** (Filtrage)
    -   Permet de changer l'algorithme de filtrage à l'exécution.
    -   Fichiers : `framework/filter/Filter.java`, `GrayscaleFilter.java`, `InvertFilter.java`.

2.  **Adapter Pattern** (Legacy)
    -   Adapte l'ancienne classe `ImplNonStandard` pour qu'elle soit compatible avec l'interface `Filter`.
    -   Fichiers : `framework/filter/FilterAdapter.java`, `legacy/ImplNonStandard.java`.

3.  **Strategy Pattern** (Compression)
    -   *Constraint respected*: Uses Strategy instead of Template Method.
    -   Defines the compression algorithm interface `Compressor`.
    -   Fichiers : `framework/compression/Compressor.java` (Interface), `RLECompressor.java`, `SimpleCompressor.java`.