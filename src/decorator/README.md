# Pattern Decorator

## Description

Le pattern Decorator est un pattern structurel qui permet d'ajouter dynamiquement des responsabilités (comportements ou données) à un objet sans modifier sa classe. Il favorise la composition par rapport à l'héritage et permet d'empiler des comportements (décorateurs) autour d'un objet `Boisson`.

## Structure du Projet

### `Boisson` (abstract)

Classe abstraite représentant une boisson. Elle expose :

- `getDescription()` : description de la boisson
- `cout()` : prix (méthode abstraite)

### Boissons concrètes

- `Espresso` : boisson de base, prix = 12
- `Deca` : boisson de base, prix = 8
- `Sumatra` : boisson de base, prix = 6

### `Decorator` (abstract)

Classe abstraite dérivée de `Boisson` qui contient une référence vers une `Boisson` et délègue une partie du comportement.

### Décorateurs concrets

- `Chocolat` : ajoute `", Chocolat"` à la description et +0.60 au prix
- `Caramel` : ajoute `", Caramel"` à la description et +0.22 au prix
- `Noisette` : ajoute `", Noisette"` à la description et +0.40 au prix

> Remarque : `Noisette` avait précédemment une petite erreur de description (affichait `Caramel`) corrigée.

## Flux d'Utilisation

1. Créer une boisson de base (par ex. `new Espresso()`)
2. Envelopper la boisson avec des décorateurs (par ex. `new Chocolat(new Noisette(new Espresso()))`)
3. Appeler `getDescription()` et `cout()` sur l'objet final ; les appels sont délégués à travers la chaîne de décorateurs

## Exemple (fichier `Main.java`)

Le `Main` du projet montre plusieurs combinaisons :

- `Chocolat(Noisette(Espresso))`
- `Caramel(Deca)`
- `Noisette(Sumatra)`

Sortie attendue (extrait) :

````
Espresso, Noisette, Chocolat
# Pattern Decorator — Présentation

## Intention

Le pattern Decorator permet d'ajouter dynamiquement des responsabilités à un objet, sans modifier sa classe. Il encapsule un objet dans un autre objet (le décorateur) qui implémente la même interface et délègue les appels tout en ajoutant un comportement.

Ce pattern favorise la composition plutôt que l'héritage pour étendre le comportement d'objets concrets.

## Participants (dans ce projet)

- `Boisson` (abstrait) : rôle de composant (Component). Définit l'interface commune (`getDescription()`, `cout()`).
- Classes concrètes de `Boisson` : `Espresso`, `Deca`, `Sumatra` (ConcreteComponent) — objets de base fournissant un comportement initial.
- `Decorator` (abstrait) : rôle de décorateur abstrait. Hérite de `Boisson` et contient une référence vers une `Boisson`. Définit l'interface pour les décorateurs concrets.
- Décorateurs concrets : `Chocolat`, `Caramel`, `Noisette` (ConcreteDecorator) — ajoutent de la fonctionnalité (description et coût) puis délèguent aux composants encapsulés.

## Diagramme conceptuel (texte)

Component (Boisson)
  ├─ ConcreteComponent (Espresso, Deca, Sumatra)
  └─ Decorator (Decorator)
		  ├─ ConcreteDecorator (Chocolat)
		  ├─ ConcreteDecorator (Caramel)
		  └─ ConcreteDecorator (Noisette)

## Comment cela fonctionne (flux d'appels)

1. On crée d'abord un objet de base, par exemple `new Espresso()`.
2. On enveloppe cet objet dans un ou plusieurs décorateurs :
	`new Chocolat(new Noisette(new Espresso()))`.
3. Quand on appelle `getDescription()` ou `cout()` sur l'objet résultant, chaque décorateur peut :
	- ajouter sa logique (ex : ajouter une partie de description ou ajouter un montant au prix),
	- puis déléguer l'appel à l'objet encapsulé.
4. Le résultat final est l'accumulation des modifications appliquées par chaque décorateur dans la chaîne.

## Extrait d'exemple (mapping vers le code du projet)

- Construction :

```java
Boisson b = new Chocolat(new Noisette(new Espresso()));
````

- Appels :

```java
String desc = b.getDescription(); // "Espresso, Noisette, Chocolat"
double prix = b.cout(); // somme du prix de l'Espresso + 0.4 (Noisette) + 0.6 (Chocolat)
```

Dans le fichier `Main.java`, on compose plusieurs boissons pour montrer différents enchaînements de décorateurs.

## Quand utiliser le pattern Decorator

- Lorsque vous avez besoin d'ajouter des responsabilités à des objets individuels et dynamiquement, sans affecter les autres instances de la même classe.
- Quand une multiplication de sous-classes (héritage) pour combiner comportements devient impraticable.

## Remarques d'implémentation

- Le décorateur doit implémenter la même interface que le composant (ici `Boisson`) pour être transparent à l'appelant.
- L'ordre des décorateurs influe sur le résultat (par exemple, la description est concaténée dans l'ordre d'enveloppement).
- Les décorateurs peuvent conserver leur propre état (ex. `ObserverImpl2` conserve un historique dans l'autre pattern) mais il faut maîtriser la responsabilité de l'objet ainsi décoré.

## Référence aux classes du dépôt

- `src/decorator/boissons/Boisson.java` — interface/abstraction du composant
- `src/decorator/boissons/Espresso.java`, `Deca.java`, `Sumatra.java` — composants concrets
- `src/decorator/decorators/Decorator.java` — décorateur abstrait
- `src/decorator/decorators/Chocolat.java`, `Caramel.java`, `Noisette.java` — décorateurs concrets
