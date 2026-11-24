# Implémentation du pattern Observer — Logger

## Principe
`Site` est le sujet observé. Les loggers sont des observateurs inscrits auprès du site.
Lorsqu'une page est ajoutée ou supprimée, `Site` notifie tous les observateurs inscrits.

## Classes
- `observer.LoggerObserver` : contrat commun des observateurs (`update`).
- `observer.SubjectObserved` : contrat du sujet (`attach`, `detach`, `notifyObservers`).
- `observer.ConsoleLoggerObserver` : écrit dans la console.
- `observer.FileLoggerObserver` : ajoute une ligne dans un fichier.
- `observer.ApiLoggerObserver` : envoie un POST JSON à une URL d'API.
- `ensisa.Site` : sujet observé. Il conserve aussi `proxy.Siteable` pour ne pas casser le pattern Proxy.

## Démonstration
Lancer `ensisa.ObserverDemo`.
La démonstration inscrit les loggers console et fichier, puis ajoute et supprime une page.
Le fichier `observer-log.txt` est créé dans le répertoire de travail au lancement.

Pour activer le logger API, décommenter la ligne dans `ObserverDemo` et remplacer l'URL par celle du webhook/API de test.

## Remarque Java
Le diagramme du cours nomme l'opération `notify()`. En Java, `Object` possède déjà une méthode `notify()` finale.
L'implémentation utilise donc `notifyObservers(...)`, qui exprime le même rôle sans conflit avec `Object.notify()`.

## Différence avec Proxy
- Proxy : l'objet logger enveloppe le site et intercepte les appels.
- Observer : le site conserve sa responsabilité et notifie les loggers abonnés après un changement.
