package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio6Composite;

public class Producto implements ComponenteBodega {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public double calcularPrecio() {
        return this.precio;
    }
}
