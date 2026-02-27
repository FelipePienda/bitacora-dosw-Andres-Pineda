package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio7Decorador;

public class MisilesDecorator extends BarcoBaseDecorator {
    public MisilesDecorator(Barco barco) { super(barco); }
    @Override
    public String getDescripcion() { return barco.getDescripcion() + ", Misiles"; }
    @Override
    public int poderAtaque() { return barco.poderAtaque() + 40; }
}