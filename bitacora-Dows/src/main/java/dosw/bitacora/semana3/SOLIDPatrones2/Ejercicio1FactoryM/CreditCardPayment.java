package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio1FactoryM;

// Tarjeta de Crédito
class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Pago con Tarjeta de Crédito por $" + amount);
    }
}

// PayPal
class PaypalPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Pago con PayPal por $" + amount);
    }
}

// Transferencia Bancaria
class BankTransferPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Pago con Transferencia Bancaria por $" + amount);
    }
}
