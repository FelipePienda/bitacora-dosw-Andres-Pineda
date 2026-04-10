package corte2.semana1.Ejercicio2SistemaProcesamientoPagos;

public class BankTransferApi {
    public boolean transfer(String accountNumber, double amount) {
        System.out.println("[Bank Transfer API] Transferencia realizada a la cuenta " + accountNumber + " por $" + amount);
        return true;
    }
}
