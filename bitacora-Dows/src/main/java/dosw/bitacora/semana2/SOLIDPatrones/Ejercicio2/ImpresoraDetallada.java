package main.java.dosw.bitacora.semana2.SOLIDPatrones.Ejercicio2;

public class ImpresoraDetallada {
    public void imprimirConDetalles(String texto, String autor, String fecha) {
        System.out.println("--- Reporte Detallado ---");
        System.out.println("Autor: " + autor);
        System.out.println("Fecha: " + fecha);
        System.out.println("Mensaje: " + texto);
        System.out.println("-------------------------");
    }
}
