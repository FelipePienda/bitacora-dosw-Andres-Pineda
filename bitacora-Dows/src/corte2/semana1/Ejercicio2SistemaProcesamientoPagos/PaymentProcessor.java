package corte2.semana1.Ejercicio2SistemaProcesamientoPagos;

public class PaymentProcessor {
    private final PaymentProvider provider;
    private final PaymentValidation validationChain;

    public PaymentProcessor(PaymentProvider provider, PaymentValidation validationChain) {
        this.provider = provider;
        this.validationChain = validationChain;
    }

    public boolean process(PaymentRequest request) {
        if (validationChain != null && !validationChain.validate(request)) {
            System.out.println("[Processor] El pago fue detenido por una validación.");
            return false;
        }

        boolean result = provider.processPayment(request);
        System.out.println(result ? "[Processor] Pago completado." : "[Processor] Falló el pago.");
        return result;
    }
}
