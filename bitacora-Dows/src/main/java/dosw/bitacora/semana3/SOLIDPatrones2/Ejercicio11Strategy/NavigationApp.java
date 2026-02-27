package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio11Strategy;

public class NavigationApp {
    private RouteStrategy routeStrategy;

    public NavigationApp(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    // Permite cambiar la estrategia en tiempo de ejecución
    public void setRouteStrategy(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public void startNavigation() {
        routeStrategy.calculateRoute();
    }
}
