package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio6Composite;

import java.util.ArrayList;
import java.util.List;

public class Caja implements ComponenteBodega {
    private String nombre;
    private List<ComponenteBodega> elementos = new ArrayList<>();

    public Caja(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(ComponenteBodega elemento) {
        elementos.add(elemento);
    }

    @Override
    public double calcularPrecio() {
        double total = 0;
        for (ComponenteBodega elemento : elementos) {
            total += elemento.calcularPrecio();
        }
        return total;
    }
}
