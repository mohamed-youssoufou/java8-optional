# java8-optional

Pouvez vous me faire cet exercice svp et le pusher sur votre github


Plan de la Session de Live Coding
1. Introduction à Optional (5 minutes)
   But et utilisation de Optional :
   Pourquoi Optional a été introduit en Java.
   Comment Optional aide à éviter les NullPointerExceptions.
2. Création et Utilisation de Base (10 minutes)
   Créer des instances de Optional :
   Optional.empty()
   Optional.of(value)
   Optional.ofNullable(value)
   Méthodes de base pour extraire et manipuler les valeurs :
   isPresent()
   ifPresent(Consumer)
   get()
   orElse(defaultValue)
   orElseGet(Supplier)
   orElseThrow()
3. Exercices Pratiques (15 minutes)
   Exercice 1 : Valeurs Par Défaut :

   Créer une méthode qui prend une String pouvant être null 
   et la retourne en majuscules ou "UNKNOWN" si elle est null, en utilisant Optional.

   Exercice 2 : Transformation de Valeurs :
   Utiliser map() et flatMap() pour transformer des Optional contenant des types 
   complexes (ex : Optional<Person> où Person peut avoir un Optional<Address>).
   
   Exercice 3 : Chaînage de Méthodes et Exceptions :
   Écrire une fonction qui utilise orElseThrow() pour lancer une exception personnalisée si l'Optional est vide.

   Exercice 4 : Composition avec filter() :
   Créer une méthode qui utilise filter() pour vérifier une condition sur la valeur encapsulée 
   et retourne un message approprié.

4. Bonnes Pratiques et Pièges à Éviter (5 minutes)
   Quand utiliser et ne pas utiliser Optional.
   Pourquoi ne pas utiliser Optional pour les collections vides.
   Ne pas utiliser get() sans isPresent() ou sans s'assurer que la valeur est présente.


Merci
