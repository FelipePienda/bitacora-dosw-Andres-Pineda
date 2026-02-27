package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio9Command;

public class DefendCommand implements Command {
    private GameCharacter character;
    public DefendCommand(GameCharacter character) { this.character = character; }
    @Override
    public void execute() { character.defend(); }
}

