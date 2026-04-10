package corte2.semana1.CombinacióndePatronesdeDiseño;



public class NotificationFactory {
    public static NotificationStrategy getStrategy(String type) {
        if (type == null) return null;

        return switch (type.toUpperCase()) {
            case "EMAIL" -> new EmailNot();
            case "SMS" -> new SMSNotification();
            case "PUSH" -> new PushNotification();
            default -> throw new IllegalArgumentException("Tipo de notificación no soportado: " + type);
        };
    }
}
