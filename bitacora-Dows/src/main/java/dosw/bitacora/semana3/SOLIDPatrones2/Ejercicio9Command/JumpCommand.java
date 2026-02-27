package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio9Command;

public class JumpCommand implements Command {
    private GameCharacter character;
    public JumpCommand(GameCharacter character) { this.character = character; }
    @Override
    public void execute() { character.jump(); }
}

