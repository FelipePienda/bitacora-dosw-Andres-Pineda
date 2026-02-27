package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio2AbstractF;

public class Main {
    public static void main(String[] args) {
        ConsoleFactory factory;

        // Ejecución para PlayStation
        factory = new PlayStationFactory();
        GameEngine psEngine = new GameEngine(factory);
        psEngine.run();

        System.out.println("-----");

        // Ejecución para Xbox
        factory = new XboxFactory();
        GameEngine xboxEngine = new GameEngine(factory);
        xboxEngine.run();
    }
}
