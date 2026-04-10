package corte2.semana1.Ejercicio2SistemaProcesamientoPagos;

public class BalanceValidator extends PaymentValidation {
    private final double availableBalance;

    public BalanceValidator(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    @Override
    public boolean validate(PaymentRequest request) {
        if (request.getAmount() > availableBalance) {
            System.out.println("[Validación] Saldo insuficiente para el pago de $" + request.getAmount());
            return false;
        }
        return checkNext(request);
    }
}
