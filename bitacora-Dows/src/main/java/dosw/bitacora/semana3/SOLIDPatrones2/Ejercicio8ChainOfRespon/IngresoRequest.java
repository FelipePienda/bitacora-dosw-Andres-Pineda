package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio8ChainOfRespon;


public class IngresoRequest {
    private boolean pasaporteValido;
    private boolean antecedentesLimpios;
    private boolean motivoValido;
    private boolean aprobado = false;

    public IngresoRequest(boolean pasaporteValido, boolean antecedentesLimpios, boolean motivoValido) {
        this.pasaporteValido = pasaporteValido;
        this.antecedentesLimpios = antecedentesLimpios;
        this.motivoValido = motivoValido;
    }

    // Getters y Setters
    public boolean isPasaporteValido() { return pasaporteValido; }
    public boolean isAntecedentesLimpios() { return antecedentesLimpios; }
    public boolean isMotivoValido() { return motivoValido; }
    public boolean isAprobado() { return aprobado; }
    public void setAprobado(boolean aprobado) { this.aprobado = aprobado; }
}
