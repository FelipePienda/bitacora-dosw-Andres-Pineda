package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio8ChainOfRespon;

public interface ControlMigratorio {
    void setSiguiente(ControlMigratorio siguiente);
    void processar(IngresoRequest request);
}
