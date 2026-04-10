package corte2.semana1.CombinacióndePatronesdeDiseño;


public class NotificationService {
    private static NotificationService instance;
    private NotificationStrategy strategy;

    // Constructor privado para Singleton
    private NotificationService() {}

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    public void setStrategy(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public void sendNotification(String message) {
        if (this.strategy == null) {
            throw new IllegalStateException("Primero debes configurar una estrategia (canal)");
        }
        this.strategy.send(message);
    }

    public void notifyUser(String message) {
        sendNotification(message);
    }
}
