package corte2.semana1.Ejercicio2SistemaProcesamientoPagos;

public interface PaymentProvider {
    boolean processPayment(PaymentRequest request);
}
