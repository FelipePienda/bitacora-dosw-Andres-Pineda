package corte2.semana1.Ejercicio2SistemaProcesamientoPagos;

public class CreditCardApi {
    public boolean chargeCard(String cardNumber, String expiryDate, double amount) {
        System.out.println("[Credit Card API] Tarjeta " + cardNumber + " cargada por $" + amount);
        return true;
    }
}
