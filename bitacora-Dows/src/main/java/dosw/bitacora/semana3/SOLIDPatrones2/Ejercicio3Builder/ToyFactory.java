package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio3Builder;

public class ToyFactory {
    // El director ejecuta los pasos de construcción en el orden correcto
    public void constructDoll(ToyDollBuilder builder) {
        builder.buildHead();
        builder.buildBody();
        builder.buildArms();
        builder.buildLegs();
        builder.addAccessories();
    }
}
