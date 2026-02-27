package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio1FactoryM;

class PaypalProcessor extends PaymentProcessor {
    @Override
    protected Payment createPayment() { return new PaypalPayment(); }
}
