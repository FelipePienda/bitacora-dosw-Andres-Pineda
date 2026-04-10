package corte2.semana1.Ejercicio3SistemaReportes;

public interface ReportBuilder {
    ReportBuilder addGeneralInfo(String info);
    ReportBuilder addStatistics(String statistics);
    ReportBuilder addTransactionDetails(String details);
    ReportBuilder addSummary(String summary);
    Report build();
}
