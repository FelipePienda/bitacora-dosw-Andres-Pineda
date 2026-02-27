package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio8ChainOfRespon;

public class AprobacionFinalControl extends ControlMigratorioHandler {
    @Override
    public void processar(IngresoRequest request) {
        request.setAprobado(true);
        System.out.println("Paso 4: ¡Aprobación final concedida! Bienvenido.");
    }
}
