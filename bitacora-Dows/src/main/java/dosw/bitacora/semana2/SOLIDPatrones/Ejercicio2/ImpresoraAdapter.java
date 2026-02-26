package main.java.dosw.bitacora.semana2.SOLIDPatrones.Ejercicio2;

import java.time.LocalDate;

public class ImpresoraAdapter implements Impresora {
    private ImpresoraDetallada detallada;
    private String autorDefault;

    public ImpresoraAdapter(ImpresoraDetallada detallada, String autor) {
        this.detallada = detallada;
        this.autorDefault = autor;
    }

    @Override
    public void imprimir(String contenido) {
        // El adaptador transforma la llamada simple en una detallada
        String fechaActual = LocalDate.now().toString();
        detallada.imprimirConDetalles(contenido, autorDefault, fechaActual);
    }
}