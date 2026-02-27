package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio5Bridge;

public class Circulo extends Forma {
    public Circulo(Color color) {
        super(color);
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando Círculo de color " + color.aplicarColor());
    }
}
