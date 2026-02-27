package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio6Composite;

public class Main {
    public static void main(String[] args) {
        // Productos simples
        Producto celular = new Producto("iPhone 15", 1000.0);
        Producto cargador = new Producto("Cargador USB-C", 50.0);
        Producto audifonos = new Producto("AirPods", 200.0);

        // Caja pequeña (Solo accesorios)
        Caja cajaAccesorios = new Caja("Caja de Accesorios");
        cajaAccesorios.agregar(cargador);
        cajaAccesorios.agregar(audifonos);

        // Caja grande (Celular + Caja de Accesorios)
        Caja cajaMaster = new Caja("Caja Master de Pedido");
        cajaMaster.agregar(celular);
        cajaMaster.agregar(cajaAccesorios); // Una caja dentro de otra

        // Cálculo total
        System.out.println("Precio total del celular solo: $" + celular.calcularPrecio());
        System.out.println("Precio total de la caja de accesorios: $" + cajaAccesorios.calcularPrecio());
        System.out.println("Precio total de todo el pedido (Caja Master): $" + cajaMaster.calcularPrecio());
    }
}
