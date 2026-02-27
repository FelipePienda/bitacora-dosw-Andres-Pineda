package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio7Decorador;

public abstract class BarcoBaseDecorator implements Barco {
    protected Barco barco; // Referencia al barco que estamos decorando

    public BarcoBaseDecorator(Barco barco) {
        this.barco = barco;
    }

    @Override
    public String getDescripcion() { return barco.getDescripcion(); }
    @Override
    public int poderAtaque() { return barco.poderAtaque(); }
    @Override
    public int defensa() { return barco.defensa(); }
}
