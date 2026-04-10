package corte2.semana1.CombinacióndePatronesdeDiseño;


public class Main {
    public static void main(String[] args) {
        // 1. Obtener la instancia única del servicio (Singleton)
        NotificationService service = NotificationService.getInstance();

        // 2. Probar envío por Email (Strategy dinámico vía Factory)
        service.setStrategy(NotificationFactory.getStrategy("EMAIL"));
        service.notifyUser("Bienvenido al Equipo Dorado");

        // 3. Cambiar dinámicamente a SMS
        service.setStrategy(NotificationFactory.getStrategy("SMS"));
        service.notifyUser("Tu código de acceso es 1234");
    }
}
