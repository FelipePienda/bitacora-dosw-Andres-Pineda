package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio9Command;

public class GameController {
    public void pressButton(Command command) {
        command.execute();
    }
}

