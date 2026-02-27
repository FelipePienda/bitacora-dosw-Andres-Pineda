package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio7Decorador;

public class AntiTorpedosDecorator extends BarcoBaseDecorator {
    public AntiTorpedosDecorator(Barco barco) { super(barco); }
    @Override
    public String getDescripcion() { return barco.getDescripcion() + ", Sistema antitorpedos"; }
    @Override
    public int poderAtaque() { return barco.poderAtaque() + 20; }
}
