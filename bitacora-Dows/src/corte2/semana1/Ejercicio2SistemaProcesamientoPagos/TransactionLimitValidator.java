package corte2.semana1.Ejercicio2SistemaProcesamientoPagos;

public class TransactionLimitValidator extends PaymentValidation {
    private final double transactionLimit;

    public TransactionLimitValidator(double transactionLimit) {
        this.transactionLimit = transactionLimit;
    }

    @Override
    public boolean validate(PaymentRequest request) {
        if (request.getAmount() > transactionLimit) {
            System.out.println("[Validación] El monto $" + request.getAmount() + " supera el límite de transacción de $" + transactionLimit);
            return false;
        }
        return checkNext(request);
    }
}
