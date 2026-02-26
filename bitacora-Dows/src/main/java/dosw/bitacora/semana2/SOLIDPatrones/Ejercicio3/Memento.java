package main.java.dosw.bitacora.semana2.SOLIDPatrones.Ejercicio3;

public class Memento {
    private final String contenido;

    public Memento(String contenido) {
        this.contenido = contenido;
    }

    public String getEstadoGuardado() {
        return contenido;
    }
}
