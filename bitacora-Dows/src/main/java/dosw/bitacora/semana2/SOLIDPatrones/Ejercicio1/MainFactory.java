package main.java.dosw.bitacora.semana2.SOLIDPatrones.Ejercicio1;

public class MainFactory {
    public static void main(String[] args) {
        // Obtenemos una notificación por SMS a través de la fábrica
        Notificacion miAviso = NotificacionFactory.crearNotificacion("sms");
        miAviso.enviar();

        // Obtenemos una notificación por Email
        Notificacion miCorreo = NotificacionFactory.crearNotificacion("email");
        miCorreo.enviar();
    }
}
