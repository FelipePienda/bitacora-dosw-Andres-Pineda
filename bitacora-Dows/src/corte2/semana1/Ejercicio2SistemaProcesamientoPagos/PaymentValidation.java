package corte2.semana1.Ejercicio2SistemaProcesamientoPagos;

public abstract class PaymentValidation {
    protected PaymentValidation next;

    public PaymentValidation linkWith(PaymentValidation next) {
        this.next = next;
        return next;
    }

    public abstract boolean validate(PaymentRequest request);

    protected boolean checkNext(PaymentRequest request) {
        if (next == null) {
            return true;
        }
        return next.validate(request);
    }
}
