package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio11Strategy;

public class FastestRoute implements RouteStrategy {
    @Override
    public void calculateRoute() {
        System.out.println("Calculando la ruta más rápida basada en el tráfico actual...");
    }
}

