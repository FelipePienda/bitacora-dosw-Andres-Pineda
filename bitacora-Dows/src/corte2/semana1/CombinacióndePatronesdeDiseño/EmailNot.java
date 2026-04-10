package corte2.semana1.CombinacióndePatronesdeDiseño;

public class EmailNot implements NotificationStrategy {
    @Override
    public void send(String message) {
        System.out.println("[EMAIL] Enviando: " + message);
    }
}
