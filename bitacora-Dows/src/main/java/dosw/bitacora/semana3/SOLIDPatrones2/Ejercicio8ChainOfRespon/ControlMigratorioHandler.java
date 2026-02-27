package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio8ChainOfRespon;


public abstract class ControlMigratorioHandler implements ControlMigratorio {
    protected ControlMigratorio siguiente;

    @Override
    public void setSiguiente(ControlMigratorio siguiente) {
        this.siguiente = siguiente;
    }

    protected void pasarAlSiguiente(IngresoRequest request) {
        if (siguiente != null) {
            siguiente.processar(request);
        }
    }
}
