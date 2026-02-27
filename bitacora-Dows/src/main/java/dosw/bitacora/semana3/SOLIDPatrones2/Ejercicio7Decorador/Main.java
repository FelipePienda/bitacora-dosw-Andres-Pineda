package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio7Decorador;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Barco barcoBase = new BarcoBase();

        // Mapeo de nombres a constructores de decoradores
        Map<String, Function<Barco, Barco>> mejoras = Map.of(
                "BLINDAJE", BlindajeDecorator::new,
                "RADAR", RadarDecorator::new,
                "MISILES", MisilesDecorator::new,
                "ANTITORPEDOS", AntiTorpedosDecorator::new
        );

        // Configuración deseada
        List<String> configuracion = List.of("BLINDAJE", "RADAR", "MISILES");

        // Aplicamos las mejoras dinámicamente usando reduce
        Barco barcoFinal = configuracion.stream()
                .map(mejoras::get)
                .reduce(barcoBase, (barco, decorador) -> decorador.apply(barco), (b1, b2) -> b1);

        // Resultados
        System.out.println("Configuración: " + barcoFinal.getDescripcion());
        System.out.println("Ataque: " + barcoFinal.poderAtaque());
        System.out.println("Defensa: " + barcoFinal.defensa());
    }
}
