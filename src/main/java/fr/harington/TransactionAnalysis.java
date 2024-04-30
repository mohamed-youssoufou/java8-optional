package fr.harington;

import java.util.*;
import java.util.stream.Collectors;

public class TransactionAnalysis {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(1, 250.0, "CREDIT", "Alimentation"),
                new Transaction(2, 100.0, "DEBIT", "Transport"),
                new Transaction(3, 30.0, "DEBIT", "Alimentation"),
                new Transaction(4, 200.0, "CREDIT", "Santé"),
                new Transaction(5, 300.0, "DEBIT", "Transport"),
                new Transaction(5, 400.0, "DEBIT", "max")
        );

        // Insérez votre code ici pour les tâches spécifiées

        // Filtrez toutes les transactions de type "DEBIT" et calculez la somme totale de ces transactions.
        double sumTransactions = transactions.stream()
                .filter(transaction -> transaction.type.equalsIgnoreCase("DEBIT"))
                .mapToDouble(transaction -> transaction.amount)
                .sum();

        System.out.println("total sum by transaction: "+ sumTransactions);

        //Utilisez Collectors.groupingBy pour grouper toutes les transactions par leur catégorie et calculez la somme des montants pour chaque catégorie.
        Map<String, Double> sumByCategory = transactions.stream()
                .collect(Collectors.groupingBy(transaction -> transaction.category, Collectors.summingDouble(transaction -> transaction.amount)));
        System.out.println("sum transaction by category : "+ sumByCategory);

        // Calculez les statistiques de montants des transactions (moyenne, max, min) en utilisant Collectors.summarizingDouble.
        DoubleSummaryStatistics transactionsAmountStatistics = transactions.stream()
                .map(transaction -> transaction.amount)
                .collect(Collectors.summarizingDouble(Double::doubleValue));

        double transactionsAmountAverage = transactionsAmountStatistics.getAverage();
        double transactionsAmountMax = transactionsAmountStatistics.getMax();
        double transactionsAmountMin = transactionsAmountStatistics.getMin();

        System.out.println("transactions amount average is: "+ transactionsAmountAverage);
        System.out.println("transactions amount max is: "+ transactionsAmountMax);
        System.out.println("transactions amount min is: "+ transactionsAmountMin);

        // Trouvez la transaction avec le montant le plus élevé et affichez ses détails.
        Transaction transactionMaxAmountDetails = transactions.stream()
                .max(Comparator.comparingDouble(t -> t.amount))
                .get();
        System.out.println("transaction detail with max amount: "+transactionMaxAmountDetails);

        // Produisez une liste des transactions "CREDIT", triées par montant décroissant.
        List<Transaction> transactionOrderedByAmountant = transactions.stream()
                .filter(transaction -> transaction.type.equalsIgnoreCase("CREDIT"))
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        System.out.println("transaction ordered by descending amount for type 'CREDIT' :"+transactionOrderedByAmountant);

        // Utilisez Collectors.toMap pour créer une map où chaque clé est l'ID de la transaction et la valeur est le montant de la transaction.
        // Assurez-vous de gérer les collisions de clés en choisissant de garder le montant le plus élevé.
        Map<Integer, Double> transactionMappingAsIdAmount = transactions.stream().collect(Collectors.toMap(
                transaction -> transaction.id,
                transaction -> transaction.amount,
                Math::max
        ));

        System.out.println("Mapping of transactions "+transactionMappingAsIdAmount);
    }




    public static class Transaction {
        int id;
        double amount;
        String type;
        String category;

        public Transaction(int id, double amount, String type, String category) {
            this.id = id;
            this.amount = amount;
            this.type = type;
            this.category = category;
        }

        public double getAmount() {
            return amount;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "id=" + id +
                    ", amount=" + amount +
                    ", type='" + type + '\'' +
                    ", category='" + category + '\'' +
                    '}';
        }
    }
}
