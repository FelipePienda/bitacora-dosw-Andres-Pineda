package corte2.semana1.Ejercicio2SistemaProcesamientoPagos;

public class FraudValidator extends PaymentValidation {
    @Override
    public boolean validate(PaymentRequest request) {
        if (request.getAmount() > 3000 || "sospechoso@fraude.com".equalsIgnoreCase(request.getPayerId())) {
            System.out.println("[Validación] Pago marcado como sospechoso: " + request.getPayerId());
            return false;
        }
        return checkNext(request);
    }
}
