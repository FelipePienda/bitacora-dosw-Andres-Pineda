package corte2.semana1.CombinacióndePatronesdeDiseño;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NotificationServiceTest {

    @Test
    void testSingletonInstance() {
        NotificationService s1 = NotificationService.getInstance();
        NotificationService s2 = NotificationService.getInstance();
        assertSame(s1, s2, "Ambas instancias deben ser la misma (Singleton)");
    }

    @Test
    void testEmailNotification() {
        NotificationService service = NotificationService.getInstance();
        NotificationStrategy email = NotificationFactory.getStrategy("EMAIL");
        service.setStrategy(email);

        assertDoesNotThrow(() -> service.notifyUser("Hola Equipo Dorado"));
    }

    @Test
    void testInvalidStrategy() {
        assertThrows(IllegalArgumentException.class, () -> {
            NotificationFactory.getStrategy("WHATSAPP");
        });
    }
}
