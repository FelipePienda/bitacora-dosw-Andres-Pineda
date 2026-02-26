package dosw.bitacora.semana1.streams.Bienvenida;

import java.util.List;

public class EjercicioRepaso {
    public static void main(String[] args) {
        //  Datos de Entrada
        List<String> words = List.of("java", "stream", "api", "functional", "code", "git");

        //  Procesamiento del Stream
        List<String> processed = words.stream()
                .filter(w -> w.length() > 4)      // Filtrar palabras con más de 4 caracteres
                .map(String::toUpperCase)         // Convertirlas a MAYÚSCULAS
                .sorted()                         // Ordenar alfabéticamente
                .toList();                        // Guardar en una nueva lista

        //  Obtener la cantidad total resultante
        long count = processed.stream().count();

        //  Imprimir resultados para la bitácora
        System.out.println("Palabras procesadas: " + processed);
        System.out.println("Cantidad total de palabras resultantes: " + count);
    }
}