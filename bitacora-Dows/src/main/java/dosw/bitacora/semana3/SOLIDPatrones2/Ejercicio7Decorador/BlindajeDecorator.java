package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio7Decorador;

public class BlindajeDecorator extends BarcoBaseDecorator {
    public BlindajeDecorator(Barco barco) { super(barco); }
    @Override
    public String getDescripcion() { return barco.getDescripcion() + ", Blindaje reforzado"; }
    @Override
    public int defensa() { return barco.defensa() + 30; }
}
