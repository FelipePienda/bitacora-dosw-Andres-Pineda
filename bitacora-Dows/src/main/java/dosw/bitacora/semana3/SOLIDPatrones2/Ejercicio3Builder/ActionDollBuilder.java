package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio3Builder;

public class ActionDollBuilder implements ToyDollBuilder {
    private ToyDoll doll;

    public ActionDollBuilder() {
        this.doll = new ToyDoll();
    }

    @Override
    public void buildHead() { doll.setHead("Cabeza con casco de combate"); }
    @Override
    public void buildBody() { doll.setBody("Cuerpo musculoso con armadura"); }
    @Override
    public void buildArms() { doll.setArms("Brazos articulados fuertes"); }
    @Override
    public void buildLegs() { doll.setLegs("Piernas con botas militares"); }
    @Override
    public void addAccessories() { doll.setHasAccessories(true); } // Trae armas o escudo

    public ToyDoll getResult() {
        return this.doll;
    }
}
