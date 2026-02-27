package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio8ChainOfRespon;

public class Main {
    public static void main(String[] args) {
        // Creamos los eslabones
        ControlMigratorio pasaporte = new PasaporteControl();
        ControlMigratorio antecedentes = new AntecedentesControl();
        ControlMigratorio motivo = new MotivoViajeControl();
        ControlMigratorio aprobacion = new AprobacionFinalControl();

        // Construimos la cadena
        pasaporte.setSiguiente(antecedentes);
        antecedentes.setSiguiente(motivo);
        motivo.setSiguiente(aprobacion);

        // Caso 1: Persona con datos incompletos (motivo falso)
        System.out.println("--- Intento de Ingreso 1 ---");
        IngresoRequest persona1 = new IngresoRequest(true, true, false);
        pasaporte.processar(persona1);

        // Caso 2: Persona con todo en regla
        System.out.println("\n--- Intento de Ingreso 2 ---");
        IngresoRequest persona2 = new IngresoRequest(true, true, true);
        pasaporte.processar(persona2);
    }
}
