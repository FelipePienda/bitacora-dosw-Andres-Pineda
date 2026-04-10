package corte2.semana1.Ejercicio2SistemaProcesamientoPagos;

public class CreditCardAdapter implements PaymentProvider {
    private final CreditCardApi api = new CreditCardApi();

    @Override
    public boolean processPayment(PaymentRequest request) {
        return api.chargeCard(request.getPaymentDetails(), "12/28", request.getAmount());
    }
}
