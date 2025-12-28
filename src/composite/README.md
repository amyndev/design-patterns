# Pattern Composite — Présentation

## Intention

Le pattern Composite permet de traiter de manière uniforme des objets individuels (feuilles) et des compositions d'objets (composites) qui contiennent d'autres objets. Il facilite la représentation d'une structure arborescente et permet au client d'utiliser la même interface pour manipuler des objets simples et composés.

## Participants (mapping vers le projet)

- Component : `Composant` (abstrait) — définit l'interface commune (`operation()`) et contient des informations partagées (`nom`, `level`).
- Leaf (feuille) : `Element` — implémentation concrète de `Composant` qui représente un objet final sans enfants.
- Composite : `Composite` — implémentation de `Composant` qui contient une collection de `Composant` et gère les opérations sur ses enfants (`add`, `remove`, `getChilds`).
- Client : `Main` — construit la structure arborescente et invoque `operation()` sur la racine.

## Principe de fonctionnement

1. Le client construit une hiérarchie d'objets en combinant `Composite` et `Element`.
2. Les appels sur un `Composite` sont propagés à ses enfants : chaque enfant exécute sa propre `operation()`.
3. Le client traite `Element` et `Composite` via l'interface commune `Composant`, sans besoin de distinction à l'appel.

## Extrait d'exemple (mapping vers le code)

Construction :

```java
Composite racine = new Composite("Composite 1");
Composite composite2 = new Composite("Composite 2");
racine.add(composite2);
racine.add(new Element("Elément 11"));
// ...
```

Appel :

```java
racine.operation();
```

Sortie attendue : l'opération est affichée pour le composite racine, puis récursivement pour chacun de ses enfants avec un niveau d'indentation (`level`) visible via des préfixes `----`.

## Remarques d'implémentation

- La classe `Composite` gère l'indentation en utilisant le champ `level` : quand un enfant est ajouté (`add`), son `level` est positionné à `this.level + 1`.
- La méthode `operation()` est implémentée différemment selon le type : `Element` affiche une opération sur la feuille, `Composite` affiche et délègue aux enfants.
- `getChilds()` retourne la liste des enfants — utile pour itération ou opérations personnalisées.

## Quand utiliser le pattern Composite

- Pour représenter des hiérarchies arborescentes (système de fichiers, UI, organisation, DOM, etc.).
- Quand le client doit traiter objets simples et groupes d'objets de manière identique.
