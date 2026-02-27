package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio2AbstractF;

interface ConsoleFactory {
    Controller createController();
    Game createGame();
    UI createUI();
}

class PlayStationFactory implements ConsoleFactory {
    public Controller createController() { return new PlayStationController(); }
    public Game createGame() { return new PlayStationGame(); }
    public UI createUI() { return new PlayStationUI(); }
}

class XboxFactory implements ConsoleFactory {
    public Controller createController() { return new XboxController(); }
    public Game createGame() { return new XboxGame(); }
    public UI createUI() { return new XboxUI(); }
}
