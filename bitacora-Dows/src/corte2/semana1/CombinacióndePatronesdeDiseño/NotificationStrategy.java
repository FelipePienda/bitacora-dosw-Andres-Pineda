package corte2.semana1.CombinacióndePatronesdeDiseño;

public interface NotificationStrategy {
    void send(String message);
}

public class EmailNotification implements NotificationStrategy {
    @Override
    public void send(String message) {
        System.out.println("Enviando Email: " + message);
    }
}

public class SMSNotification implements NotificationStrategy {
    @Override
    public void send(String message) {
        System.out.println("Enviando SMS: " + message);
    }
}
