package dosw.bitacora.semana1.streams.Ejercicio3;

import java.util.List;
//  Definición de la clase Transaction
class Transaction {
    String id;
    double amount;
    boolean approved;

    public Transaction(String id, double amount, boolean approved) {
        this.id = id;
        this.amount = amount;
        this.approved = approved;
    }

    @Override
    public String toString() {
        return "Transaction{id='" + id + "', amount=" + amount + ", approved=" + approved + "}";
    }

    public boolean isApproved() {
        return approved;
    }
}

public class EjercicioTres {
    public static void main(String[] args) {

        // Crear la lista de transacciones
        List<Transaction> transactions = List.of(
                new Transaction("T1", 100.0, true),
                new Transaction("T2", 250.5, false), // Esta no está aprobada
                new Transaction("T3", 50.0, true)
        );

        // Procesamiento con Stream
        // El objetivo es verificar si hay alguna NO aprobada y retornar si el lote es válido.

        boolean isBatchValid = transactions.stream()
                .peek(t -> System.out.println("Procesando: " + t)) // Ver cada transacción
                .allMatch(Transaction::isApproved); // Retorna true solo si TODAS están aprobadas

        //  Resultado
        System.out.println("------------------------------------");
        System.out.println("¿Es el lote de transacciones válido? " + isBatchValid);


        boolean existsUnapproved = transactions.stream()
                .anyMatch(t -> !t.isApproved());

        System.out.println("¿Existe alguna transacción no aprobada? " + existsUnapproved);
    }
}
