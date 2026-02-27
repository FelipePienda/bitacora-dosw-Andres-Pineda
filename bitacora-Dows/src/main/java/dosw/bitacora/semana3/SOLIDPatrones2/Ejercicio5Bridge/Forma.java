package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio5Bridge;

public abstract class Forma {
    // El "Puente" hacia la jerarquía de colores
    protected Color color;

    protected Forma(Color color) {
        this.color = color;
    }

    public abstract void dibujar();
}
