package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio4Adapter;

public class SmartGasStation {
    public static void main(String[] args) {
        // Todo se maneja a través de la interfaz FuelService
        FuelService gasolinePump = new GasPump();

        FuelService fastElectricPump =
                new FastChargerAdapter(new FastElectricCharger());

        FuelService slowElectricPump =
                new SlowChargerAdapter(new SlowElectricCharger());

        // El sistema central usa la misma llamada para todos
        System.out.println("--- Iniciando Suministro General ---");
        gasolinePump.supply(30);
        fastElectricPump.supply(30);
        slowElectricPump.supply(30);
    }
}
