package main.java.dosw.bitacora.semana2.SOLIDPatrones.Ejercicio1;

public class NotificacionFactory {
    public static Notificacion crearNotificacion(String tipo) {
        if (tipo == null || tipo.isEmpty()) return null;

        return switch (tipo.toLowerCase()) {
            case "email" -> new NotificacionEmail();
            case "sms" -> new NotificacionSMS();
            case "push" -> new NotificacionPush();
            default -> throw new IllegalArgumentException("Tipo de notificación desconocido: " + tipo);
        };
    }
}
