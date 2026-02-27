package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio5Bridge;

public class Main {
    public static void main(String[] args) {
        // Combinamos Formas con Colores dinámicamente
        Forma circuloRojo = new Circulo(new Rojo());
        Forma cuadradoRojo = new Cuadrado(new Rojo());

        Forma circuloAzul = new Circulo(new Azul());
        Forma cuadradoAzul = new Cuadrado(new Azul());

        // Ejecución
        circuloRojo.dibujar();
        cuadradoRojo.dibujar();
        circuloAzul.dibujar();
        cuadradoAzul.dibujar();
    }
}
