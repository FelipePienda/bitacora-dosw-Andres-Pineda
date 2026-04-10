package corte2.semana1.Ejercicio2SistemaProcesamientoPagos;

public class PayPalApi {
    public boolean sendPayment(String email, double amount) {
        System.out.println("[PayPal API] Pago procesado para " + email + " por $" + amount);
        return true;
    }
}
