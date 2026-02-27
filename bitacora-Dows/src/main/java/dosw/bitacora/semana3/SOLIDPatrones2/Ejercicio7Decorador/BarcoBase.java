package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio7Decorador;

public class BarcoBase implements Barco {
    @Override
    public String getDescripcion() { return "Barco Básico"; }
    @Override
    public int poderAtaque() { return 10; }
    @Override
    public int defensa() { return 10; }
}
