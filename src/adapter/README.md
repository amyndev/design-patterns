# Pattern Adapter — Présentation

## Intention

Le pattern Adapter (ou « adaptateur ») permet de faire collaborer des interfaces incompatibles. Il transforme l'interface d'une classe (le service existant) en une interface que le client attend, sans modifier les classes existantes.

Dans ce projet, l'adaptateur permet à l'`UniteCentral` (qui utilise une interface `VGA`) d'envoyer des données vers des périphériques qui attendent une interface `HDMI`.

## Participants (mapping vers le projet)

- Client : `UniteCentral` — code qui attend une interface `VGA` et appelle `print(String message)`.
- Target (interface attendue) : `VGA` — définit `void print(String message)`.
- Adaptee (service existant) : classes qui implémentent `HDMI` (ex. `TV`, `SuperVP`) — définissent `void view(byte[] data)`.
- Adapter (implémentations) :
  - `HdmiVgaAdapterComposition` — adaptateur par composition (contient une référence `HDMI`) et implémente `VGA`.
  - `HdmiVgaAdapterHeritage` — adaptateur par héritage (hérite de `TV` et implémente `VGA`).

## Principe de fonctionnement

- Avec un adaptateur par composition, l'adaptateur implémente l'interface attendue (`VGA`) et contient une référence au service réel (`HDMI`). Lorsqu'il reçoit un appel `print(String)`, il convertit le message en `byte[]` et délègue l'appel à la méthode `view(byte[])` de l'objet `HDMI` encapsulé.

- Avec un adaptateur par héritage (ou « classe adaptatrice »), l'adaptateur hérite directement de la classe existante (ici `TV`) et expose l'interface `VGA` en redéfinissant `print(String)` pour appeler `super.view(...)`.

## Exemple d'utilisation (extrait du dépôt)

Construction et usage (composition) :

```java
HdmiVgaAdapterComposition adapter = new HdmiVgaAdapterComposition();
adapter.setHdmi(new TV()); // on fournit l'adaptee
uniteCentral.setVGA(adapter);
uniteCentral.print("Bonjour");
```

Construction et usage (héritage) :

```java
HdmiVgaAdapterHeritage adapterHer = new HdmiVgaAdapterHeritage();
uniteCentral.setVGA(adapterHer);
uniteCentral.print("Bonjour via adapter par héritage");
```

Remarque : le projet montre aussi un composant `SuperVP` qui implémente à la fois `VGA` et `HDMI`. Dans ce cas l'`UniteCentral` peut directement utiliser `SuperVP` ou le passer au `HdmiVgaAdapterComposition`.

## Points importants

- L'adaptateur effectue la conversion de protocoles/types (ici `String` -> `byte[]`) et déléguera au service réel.
- Le choix composition vs héritage dépend des contraintes :
  - Composition (préférée) : plus flexible, permet d'adapter des classes qui ne peuvent pas être héritées ou quand on veut adapter plusieurs instances différentes à runtime.
  - Héritage : simple si on contrôle la classe à adapter et qu'on peut hériter d'elle, mais moins flexible.

## Référence des classes (dossier)

- `src/adapter/Main.java` — démonstration et scénarios d'utilisation
- `src/adapter/adapter/HdmiVgaAdapterComposition.java` — adaptateur par composition
- `src/adapter/adapter/HdmiVgaAdapterHeritage.java` — adaptateur par héritage
- `src/adapter/computer/VGA.java` — interface target
- `src/adapter/computer/HDMI.java` — interface adaptee
- `src/adapter/computer/UniteCentral.java` — client qui attend `VGA`
- `src/adapter/computer/TV.java`, `Ecran.java`, `VideoProjecteur.java`, `SuperVP.java` — implémentations concrètes
