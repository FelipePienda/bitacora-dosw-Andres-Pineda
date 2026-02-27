package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio11Strategy;

public class CheapestRoute implements RouteStrategy {
    @Override
    public void calculateRoute() {
        System.out.println("Calculando la ruta más económica (evitando peajes)...");
    }
}

