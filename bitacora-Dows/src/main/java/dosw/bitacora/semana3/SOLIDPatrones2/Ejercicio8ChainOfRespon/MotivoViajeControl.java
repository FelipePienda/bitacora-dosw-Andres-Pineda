package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio8ChainOfRespon;

public class MotivoViajeControl extends ControlMigratorioHandler {
    @Override
    public void processar(IngresoRequest request) {
        if (request.isMotivoValido()) {
            System.out.println("Paso 3: Motivo de viaje coherente.");
            pasarAlSiguiente(request);
        } else {
            System.out.println("RECHAZADO: Motivo de viaje no convincente.");
        }
    }
}
