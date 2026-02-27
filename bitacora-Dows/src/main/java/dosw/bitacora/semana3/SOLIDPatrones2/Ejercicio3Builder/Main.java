package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio3Builder;

public class Main {
    public static void main(String[] args) {
        //  Creamos al director de la fábrica
        ToyFactory factory = new ToyFactory();

        System.out.println("--- Fabricando Muñeco de Acción ---");
        ActionDollBuilder actionBuilder = new ActionDollBuilder();
        factory.constructDoll(actionBuilder);
        ToyDoll actionDoll = actionBuilder.getResult();

        System.out.println("--- Fabricando Muñeca Clásica ---");
        ClassicDollBuilder classicBuilder = new ClassicDollBuilder();
        factory.constructDoll(classicBuilder);
        ToyDoll classicDoll = classicBuilder.getResult();

        // Mostramos los resultados
        actionDoll.showInfo();
        classicDoll.showInfo();
    }
}
