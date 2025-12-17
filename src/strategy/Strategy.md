# Pattern Strategy

## Description

Le pattern Strategy est un pattern comportemental qui permet de définir une famille d'algorithmes, de les encapsuler et de les rendre interchangeables. Ce pattern permet à l'algorithme de varier indépendamment des clients qui l'utilisent.

## Structure du Projet

### Interface Strategy

Définit l'interface commune pour toutes les stratégies concrètes.

### Implémentations

- **DefaultStrategyImpl** : Stratégie par défaut utilisée si aucune stratégie n'est spécifiée ou si la stratégie demandée n'existe pas
- **StrategyImpl1** : Première implémentation de stratégie
- **StrategyImpl2** : Deuxième implémentation de stratégie
- **StrategyImpl3** : Troisième implémentation de stratégie

### Context

La classe Context maintient une référence vers un objet Strategy et délègue le travail à la stratégie courante. Elle peut changer de stratégie dynamiquement via la méthode `setStrategy()`.

## Utilisation

1. Lancer le programme `Main.java`
2. Entrer un numéro de stratégie (1, 2, 3)
3. Si la stratégie existe, elle sera créée et mise en cache
4. Si la stratégie n'existe pas, la stratégie par défaut sera utilisée
5. L'opération sera exécutée avec la stratégie sélectionnée

## Avantages

- ✅ Élimination des instructions conditionnelles multiples
- ✅ Encapsulation des algorithmes dans des classes séparées
- ✅ Changement dynamique de comportement au runtime
- ✅ Facilite l'ajout de nouvelles stratégies sans modifier le code existant (Open/Closed Principle)

## Exemple d'Exécution

```
Tapez le numero d'une strategie : 1
Creation d'un nouvel objet de StrategyImpl1
$$$
+++ Strategy 1 +++
$$$

Tapez le numero d'une strategie : 5
Creation d'un nouvel objet de StrategyImpl5
Strategie 5 n'existe pas, utilisation de la strategie par defaut
$$$
*** Default Strategy ***
$$$
```
