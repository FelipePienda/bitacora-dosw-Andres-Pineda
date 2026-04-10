package corte2.semana1.Ejercicio2SistemaProcesamientoPagos;

public class PayPalAdapter implements PaymentProvider {
    private final PayPalApi api = new PayPalApi();

    @Override
    public boolean processPayment(PaymentRequest request) {
        return api.sendPayment(request.getPayerId(), request.getAmount());
    }
}
