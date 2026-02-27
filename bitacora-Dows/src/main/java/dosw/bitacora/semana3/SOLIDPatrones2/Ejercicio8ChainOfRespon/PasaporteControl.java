package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio8ChainOfRespon;

public class PasaporteControl extends ControlMigratorioHandler {
    @Override
    public void processar(IngresoRequest request) {
        if (request.isPasaporteValido()) {
            System.out.println("Paso 1: Pasaporte y visa verificados.");
            pasarAlSiguiente(request);
        } else {
            System.out.println("RECHAZADO: Pasaporte o visa inválidos.");
        }
    }
}
