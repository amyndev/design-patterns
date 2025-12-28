# Pattern Observer

## Description

Le pattern Observer est un pattern comportemental qui définit une dépendance un-à-plusieurs entre des objets de sorte que, lorsqu'un objet change d'état, tous ses dépendants en sont notifiés automatiquement et se mettent à jour.

Ce pattern est également connu sous le nom de "Publish-Subscribe" et permet une communication faiblement couplée entre les composants.

## Structure du Projet

### Interface Observer

Interface fonctionnelle représentant un observateur. Elle définit la méthode `update()` qui sera appelée quand l'observable change d'état.

```java
@FunctionalInterface
public interface Observer {
    void update(Observable o);
}
```

### Interface Observable

Définit les méthodes pour gérer les observateurs :

- `subscribe(Observer o)` : Ajoute un observateur
- `unsubscribe(Observer o)` : Supprime un observateur
- `notifyObservers()` : Notifie tous les observateurs

### ObservableImpl

Implémentation de l'observable qui :

- Maintient une liste d'observateurs
- Gère l'état interne
- Notifie automatiquement les observateurs quand l'état change

### Implémentations d'Observer

- **ObserverImpl1** : Affiche simplement le nouvel état
- **ObserverImpl2** : Maintient un historique et calcule la moyenne des états
- **ObserverImpl3** (Anonyme) : Observer créé avec une lambda, calcule le résultat d'une fonction trigonométrique

## Flux d'Exécution

1. Création d'un Observable
2. Création et inscription d'observateurs
3. Modification de l'état de l'observable
4. Notification automatique de tous les observateurs
5. Désinscription optionnelle d'observateurs

## Exemple d'Exécution

```
observable.setState(60);

*** OBS Impl 1 ***
New State = 60
******************

--- OBS Impl 2 ---
Moyenne = 60.0
------------------

### OBS Impl 3 ###
Res = -51.58
##################

observable.setState(50);

*** OBS Impl 1 ***
New State = 50
******************

--- OBS Impl 2 ---
Moyenne = 55.0
------------------

### OBS Impl 3 ###
Res = -32.04
##################

observable.unsubscribe(o2);  // O2 se désabonne

observable.setState(40);

*** OBS Impl 1 ***
New State = 40
******************

### OBS Impl 3 ###
Res = -39.20
##################
```

## Avantages

- ✅ **Couplage faible** : L'observable ne connaît pas les détails des observateurs
- ✅ **Dynamique** : Peut ajouter/retirer des observateurs à l'exécution
- ✅ **Réutilisable** : Un même observable peut notifier différents types d'observateurs
- ✅ **Broadcast automatique** : Tous les observateurs sont notifiés en même temps
- ✅ **Support des Lambdas** : Grâce à @FunctionalInterface, permet la création d'observateurs anonymes

## Inconvénients

- ❌ La notification est non-ordonnée (dépend de l'ordre d'inscription)
- ❌ Les observateurs reçoivent toujours la notification même s'ils n'en ont pas besoin
- ❌ Peut causer des fuites mémoire si les observateurs ne sont pas désinscrits
- ❌ Peut diminuer les performances avec de nombreux observateurs

## Cas d'Usage

- Systèmes de notification
- MVC (Model-View-Controller)
- Systèmes d'événements
- Mise en cache avec invalidation
- Systèmes réactifs
