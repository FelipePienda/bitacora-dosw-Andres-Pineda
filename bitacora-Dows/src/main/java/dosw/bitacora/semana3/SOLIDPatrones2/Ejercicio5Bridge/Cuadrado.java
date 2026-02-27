package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio5Bridge;

public class Cuadrado extends Forma {
    public Cuadrado(Color color) {
        super(color);
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando Cuadrado de color " + color.aplicarColor());
    }
}
