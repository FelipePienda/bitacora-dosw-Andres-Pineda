package dosw.bitacora.semana1.streams.Bienvenida;

import java.util.List;
import java.util.stream.Collectors;

public class RetoFiltro {
    public static void main(String[] args) {
        // 1. Datos de Entrada
        List<Integer> numbers = List.of(3, 8, 10, 12, 15, 18, 20);

        // 2. Procesamiento con Stream
        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 == 0) // Condición 1: Que sea par
                .filter(n -> n > 10)     // Condición 2: Que sea mayor a 10
                .collect(Collectors.toList());

        // 3. Imprimir Resultado
        System.out.println("Lista original: " + numbers);
        System.out.println("Números pares mayores a 10: " + result);
    }
}