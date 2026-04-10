package corte2.semana1.Ejercicio2SistemaProcesamientoPagos;

public class BankTransferAdapter implements PaymentProvider {
    private final BankTransferApi api = new BankTransferApi();

    @Override
    public boolean processPayment(PaymentRequest request) {
        return api.transfer(request.getPaymentDetails(), request.getAmount());
    }
}
