package main.java.dosw.bitacora.semana2.SOLIDPatrones.Ejercicio3;

import java.util.Stack;

public class Historial {
    // Usamos un Stack (Pila) porque el último en entrar es el primero en salir (Undo)
    private Stack<Memento> mementos = new Stack<>();

    public void guardarEstado(Memento m) {
        mementos.push(m);
    }

    public Memento deshacer() {
        if (!mementos.isEmpty()) {
            return mementos.pop();
        }
        return null;
    }
}