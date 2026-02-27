package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio4Adapter;

public class GasPump implements FuelService {
    @Override
    public void supply(int liters) {
        System.out.println("Suministrando " + liters + " litros de gasolina.");
    }
}
