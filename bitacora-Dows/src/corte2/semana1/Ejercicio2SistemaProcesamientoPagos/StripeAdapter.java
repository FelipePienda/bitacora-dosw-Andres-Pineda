package corte2.semana1.Ejercicio2SistemaProcesamientoPagos;

public class StripeAdapter implements PaymentProvider {
    private final StripeApi api = new StripeApi();

    @Override
    public boolean processPayment(PaymentRequest request) {
        return api.charge(request.getPaymentDetails(), request.getAmount());
    }
}
