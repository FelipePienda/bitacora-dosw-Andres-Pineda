package corte2.semana1.Ejercicio2SistemaProcesamientoPagos;

public class PaymentRequest {
    private final String payerId;
    private final double amount;
    private final String currency;
    private final String paymentMethod;
    private final String paymentDetails;

    public PaymentRequest(String payerId, double amount, String currency, String paymentMethod, String paymentDetails) {
        this.payerId = payerId;
        this.amount = amount;
        this.currency = currency;
        this.paymentMethod = paymentMethod;
        this.paymentDetails = paymentDetails;
    }

    public String getPayerId() {
        return payerId;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }
}
