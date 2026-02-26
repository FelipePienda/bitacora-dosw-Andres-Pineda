package main.java.dosw.bitacora.semana2.SOLIDPatrones.Ejercicio3;

public class EditorTexto {
    private String contenido;

    public void escribir(String nuevoTexto) {
        this.contenido = nuevoTexto;
    }

    public String getContenido() {
        return contenido;
    }

    // Crea la "foto" actual
    public Memento guardar() {
        return new Memento(contenido);
    }

    // Restaura a partir de una "foto"
    public void restaurar(Memento memento) {
        this.contenido = memento.getEstadoGuardado();
    }
}
