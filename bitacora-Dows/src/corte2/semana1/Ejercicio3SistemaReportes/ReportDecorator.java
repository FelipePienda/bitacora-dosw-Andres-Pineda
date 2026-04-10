package corte2.semana1.Ejercicio3SistemaReportes;

public abstract class ReportDecorator implements ReportGenerator {
    protected final ReportGenerator wrapped;

    protected ReportDecorator(ReportGenerator wrapped) {
        this.wrapped = wrapped;
    }
}
