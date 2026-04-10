package corte2.semana1.CombinacióndePatronesdeDiseño;




public class PushNotification implements NotificationStrategy {
    @Override
    public void send(String message) {
        System.out.println("[PUSH] Enviando: " + message);
    }
}