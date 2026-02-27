package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio1FactoryM;

public abstract class PaymentProcessor {
    // Método de fábrica (Factory Method)
    protected abstract Payment createPayment();

    // Lógica de negocio que usa el producto creado
    public void processPayment(double amount) {
        Payment payment = createPayment();
        payment.pay(amount);
    }
}
