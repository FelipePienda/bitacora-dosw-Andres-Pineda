package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio1FactoryM;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor;

        // Procesar con Tarjeta
        processor = new CreditCardProcessor();
        processor.processPayment(100.0);

        // Procesar con PayPal
        processor = new PaypalProcessor();
        processor.processPayment(250.0);

        // Procesar con Transferencia
        processor = new BankTransferProcessor();
        processor.processPayment(500.0);
    }
}
