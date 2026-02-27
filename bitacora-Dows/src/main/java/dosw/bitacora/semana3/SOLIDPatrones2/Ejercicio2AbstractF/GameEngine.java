package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio2AbstractF;

class GameEngine {
    private Controller controller;
    private Game game;
    private UI ui;

    public GameEngine(ConsoleFactory factory) {
        this.controller = factory.createController();
        this.game = factory.createGame();
        this.ui = factory.createUI();
    }

    public void run() {
        controller.connect();
        game.start();
        ui.render();
    }
}