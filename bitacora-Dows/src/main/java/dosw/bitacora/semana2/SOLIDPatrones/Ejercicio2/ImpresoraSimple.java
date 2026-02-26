package main.java.dosw.bitacora.semana2.SOLIDPatrones.Ejercicio2;

public class ImpresoraSimple implements Impresora {
    @Override
    public void imprimir(String contenido) {
        System.out.println("Imprimiendo mensaje simple: " + contenido);
    }
}