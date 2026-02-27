package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio9Command;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GameCharacter character = new GameCharacter();
        GameController controller = new GameController();

        // Creamos una lista de comandos (acciones)
        List<Command> actions = List.of(
                new WalkCommand(character),
                new JumpCommand(character),
                new AttackCommand(character),
                new DefendCommand(character)
        );

        // El controlador ejecuta cada acción sin conocer su contenido
        System.out.println("--- Iniciando secuencia de acciones ---");
        actions.forEach(controller::pressButton);
    }
}
