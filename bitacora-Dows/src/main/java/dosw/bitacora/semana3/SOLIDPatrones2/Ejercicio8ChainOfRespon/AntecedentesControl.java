package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio8ChainOfRespon;

public class AntecedentesControl extends ControlMigratorioHandler {
    @Override
    public void processar(IngresoRequest request) {
        if (request.isAntecedentesLimpios()) {
            System.out.println("Paso 2: Antecedentes penales limpios.");
            pasarAlSiguiente(request);
        } else {
            System.out.println("RECHAZADO: El solicitante tiene antecedentes.");
        }
    }
}
