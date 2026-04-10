package corte2.semana1.Ejercicio3SistemaReportes;

public class BasicReportGenerator implements ReportGenerator {
    private final Report report;

    public BasicReportGenerator(Report report) {
        this.report = report;
    }

    @Override
    public Report generate() {
        return report;
    }
}
