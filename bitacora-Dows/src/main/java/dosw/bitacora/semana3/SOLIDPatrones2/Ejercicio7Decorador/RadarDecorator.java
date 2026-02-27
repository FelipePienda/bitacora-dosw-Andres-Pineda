package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio7Decorador;

public class RadarDecorator extends BarcoBaseDecorator {
    public RadarDecorator(Barco barco) { super(barco); }
    @Override
    public String getDescripcion() { return barco.getDescripcion() + ", Radar avanzado"; }
    @Override
    public int poderAtaque() { return barco.poderAtaque() + 10; }
}