package corte2.semana1.Ejercicio2SistemaProcesamientoPagos;

public class StripeApi {
    public boolean charge(String token, double amount) {
        System.out.println("[Stripe API] Cargo realizado con token " + token + " por $" + amount);
        return true;
    }
}
