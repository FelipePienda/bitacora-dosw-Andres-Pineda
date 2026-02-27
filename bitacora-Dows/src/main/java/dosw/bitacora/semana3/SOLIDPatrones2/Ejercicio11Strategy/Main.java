package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio11Strategy;


public class Main {
    public static void main(String[] args) {
        // Iniciamos con la ruta más rápida
        NavigationApp app = new NavigationApp(new FastestRoute());
        app.startNavigation();

        // El usuario prefiere ver paisajes
        app.setRouteStrategy(new ScenicRoute());
        app.startNavigation();

        // El usuario quiere ahorrar dinero
        app.setRouteStrategy(new CheapestRoute());
        app.startNavigation();
    }
}
