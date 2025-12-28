# TD1 : Design Patterns Exercises

## Exercice 1 : Diagrammes de Classes

- **1.1 Figure** : Pattern **Composite** (Figures géométriques)
<img width="1127" height="369" alt="image" src="https://github.com/user-attachments/assets/5f284b25-585e-46c2-ac09-ce93356b6ff3" />

- **1.2 Plugin** : Pattern **Strategy** (Algorithmes variables)
<img width="858" height="677" alt="image" src="https://github.com/user-attachments/assets/e1eff8f5-90f6-417f-a6aa-8d94964eff2c" />

- **1.3 Composant** : Pattern **Decorator** (Ajout de responsabilités)
<img width="1069" height="494" alt="image" src="https://github.com/user-attachments/assets/2ebd95b4-fb0c-4ff1-b016-626fd16b5a2a" />

- **1.4 Joueur** : Pattern **Observer** (Notification de score)
<img width="876" height="576" alt="image" src="https://github.com/user-attachments/assets/4a96c80a-fc7b-4082-b3d0-9622694b0476" />

## Exercice 2 : Framework de Traitement d'Images


Ce framework implémente les patterns suivants conformément à l'énoncé :
<img width="1498" height="1090" alt="image" src="https://github.com/user-attachments/assets/4295742c-9638-4540-af90-f439c8c20974" />

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
