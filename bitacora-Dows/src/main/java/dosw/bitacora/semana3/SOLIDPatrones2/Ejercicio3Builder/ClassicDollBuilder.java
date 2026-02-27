package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio3Builder;

public class ClassicDollBuilder implements ToyDollBuilder {
    private ToyDoll doll;

    public ClassicDollBuilder() {
        this.doll = new ToyDoll();
    }

    @Override
    public void buildHead() { doll.setHead("Cabeza con cabello largo y lazo"); }
    @Override
    public void buildBody() { doll.setBody("Cuerpo con vestido de tela"); }
    @Override
    public void buildArms() { doll.setArms("Brazos de plástico suave"); }
    @Override
    public void buildLegs() { doll.setLegs("Piernas con zapatos de tacón bajo"); }
    @Override
    public void addAccessories() { doll.setHasAccessories(false); } // Sin accesorios extra

    public ToyDoll getResult() {
        return this.doll;
    }
}
