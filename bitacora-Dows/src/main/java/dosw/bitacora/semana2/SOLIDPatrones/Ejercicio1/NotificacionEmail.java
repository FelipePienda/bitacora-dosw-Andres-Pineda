package main.java.dosw.bitacora.semana2.SOLIDPatrones.Ejercicio1;

public class NotificacionEmail implements Notificacion {
    @Override
    public void enviar() {
        System.out.println("Enviando notificación por Correo Electrónico...");
    }
}
