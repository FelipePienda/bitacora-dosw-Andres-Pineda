package corte2.semana1.CombinacióndePatronesdeDiseño;


public class SMSNotification implements NotificationStrategy {
    @Override
    public void send(String message) {
        System.out.println("[SMS] Enviando: " + message);
    }
}
