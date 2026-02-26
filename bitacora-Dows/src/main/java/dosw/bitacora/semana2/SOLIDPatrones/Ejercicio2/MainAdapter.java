package main.java.dosw.bitacora.semana2.SOLIDPatrones.Ejercicio2;

public class MainAdapter {
    public static void main(String[] args) {
        //  Uso normal de la impresora simple
        Impresora impresora1 = new ImpresoraSimple();
        impresora1.imprimir("Hola Mundo!");

        // Uso de la detallada mediante el ADAPTADOR
        ImpresoraDetallada detallada = new ImpresoraDetallada();
        Impresora impresora2 = new ImpresoraAdapter(detallada, "Andres Pineda");

        // El sistema llama a .imprimir() sin saber que por dentro hay una detallada
        impresora2.imprimir("Este es un mensaje adaptado.");
    }
}
