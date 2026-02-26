package dosw.bitacora.semana1.streams.Bienvenida;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RetoBienvenida {
    public static void main(String[] args) {
        // 1. Crear la estructura de datos List
        List<Estudiante> pareja = Arrays.asList(
                new Estudiante("Andres Pineda", 25, "andres.pineda-g@mail.escueling.edu.co", 8));

        // 2. Usar Stream, Map (Lambda) y Collect para generar la descripción
        String descripcionPareja = pareja.stream()
                .map(e -> e.nombre + ", estudiante de la escuela de " + e.semestre + ".° semestre de " + e.edad + " años")
                .collect(Collectors.joining(", y "));

        // 3. Extraer correos
        String correos = pareja.stream()
                .map(e -> e.correo)
                .collect(Collectors.joining(" y "));

        // 4. Imprimir el Mensaje de Bienvenida final
        System.out.println("¡Hola, bienvenidos! soy el integrante " +
                descripcionPareja + ". Nuestros correos institucionales son " + correos + ".");
    }
}
