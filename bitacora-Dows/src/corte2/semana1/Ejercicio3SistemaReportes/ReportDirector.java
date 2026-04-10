package corte2.semana1.Ejercicio3SistemaReportes;

public class ReportDirector {
    private final ReportBuilder builder;

    public ReportDirector(ReportBuilder builder) {
        this.builder = builder;
    }

    public Report buildReport(String generalInfo, String statistics, String transactionDetails, String summary) {
        return builder
                .addGeneralInfo(generalInfo)
                .addStatistics(statistics)
                .addTransactionDetails(transactionDetails)
                .addSummary(summary)
                .build();
    }
}
