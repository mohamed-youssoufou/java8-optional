package fr.harington;

import lombok.Getter;

import java.util.Optional;

public class HomeworkOptionalFeature {
    public static void main(String[] args) {

        // 1. Introduction à Optional (5 minutes)
        //    - But et utilisation de Optional :
        //      Pourquoi Optional a été introduit en Java.
        //      → Dans le but était de fournir un type de retour qui peut représenter l'absence pour la presence d'une valeur
        //      Comment Optional aide à éviter les NullPointerExceptions.
        //      → Il nous aide dans le sens où il nous founi des class permettant d'envelopper les objets susceptible d'etre null
        //      exemple = Optional.ofNullable(objectCanBeNull).orElse(...) and Optional.ofNullable(objectCanBeNull).orElseThrow(...);

        // 2. Création et Utilisation de Base (10 minutes)
        //    - Créer des instances de Optional :
        //      Optional.empty()
        final Optional<Object> optionalInstance = Optional.empty();

        //    - Optional.of(value)
        final Optional<String> stringOptional = Optional.of("hello world");

        //    - Optional.ofNullable(value)
        Object myNullObject = null;
        final Optional<Object> myNullableObjectOptional = Optional.ofNullable(myNullObject);
    }

    // 3. Méthodes de base pour extraire et manipuler les valeurs :

    //    - Exercices Pratiques (15 minutes)
    //      Exercice 1 : Valeurs Par Défaut :
    //          Créer une méthode qui prend une String pouvant être null
    //          et la retourne en majuscules ou "UNKNOWN" si elle est null, en utilisant Optional.
    public String toUpperCaseParamOrGetUnknown(String param){
        return Optional.ofNullable(param).map(String::toUpperCase).orElse("UNKNOWN");
    }

    //     - Exercice 2 : Transformation de Valeurs :
    //       Utiliser map() et flatMap() pour transformer des Optional contenant des types
    //       complexes (ex : Optional<Person> où Person peut avoir un Optional<Address>).
    @Getter
    class Person { private Optional<Address> address;}
    @Getter
    class Address { private String name; }


    public String getPersonAddressNameOrGetUnknown(Person person){
        return Optional.ofNullable(person)
                .flatMap(Person::getAddress)
                .map(Address::getName)
                .orElse("UNKNOWN");
    }

    //     - Exercice 3 : Chaînage de Méthodes et Exceptions :
    //       Écrire une fonction qui utilise orElseThrow() pour lancer une exception personnalisée si l'Optional est vide.
    public String toUpperCaseParamOrThrowIllegalArgumentException(String param){
        return Optional.ofNullable(param)
                .map(String::toUpperCase)
                .orElseThrow(() -> new IllegalArgumentException("parameter value is null"));
    }

    //      - Exercice 4 : Composition avec filter() :
    //        Créer une méthode qui utilise filter() pour vérifier une condition sur la valeur encapsulée
    //        et retourne un message approprié.
    public static String filterAndGetMessageOrGetDefaultMessage(Optional<Double> optionalValue) {
        return optionalValue.filter(value -> value > 0)
                .map(value -> "Valid value: " + value)
                .orElse("Invalid value given");
    }

    // 4. Bonnes Pratiques et Pièges à Éviter (5 minutes)

    //    Quand utiliser et ne pas utiliser Optional.
    //    → Les Optionals sont utilisés lorsque nous savons qu'une variable est susceptible d'être <<null>>.
    //      Elles ne sont pas utiles dans les cas où la variable peut avoir toute valeur sauf <<null>>.

    //    Pourquoi ne pas utiliser Optional pour les collections vides.
    //    → une variable qui reçoit une collection vide n'étant pas une variable avec une valeur <<null>>, il n'est donc pas recommandé ici.

    //    Ne pas utiliser get() sans isPresent() ou sans s'assurer que la valeur est présente.
    //    → des methods comme orElse(Object) et orElseGet(Supplier) assurent également que la valeur soit présente
}
