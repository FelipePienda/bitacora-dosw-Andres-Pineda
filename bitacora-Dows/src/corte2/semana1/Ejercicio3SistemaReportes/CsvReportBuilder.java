package corte2.semana1.Ejercicio3SistemaReportes;

public class CsvReportBuilder implements ReportBuilder {
    private final StringBuilder content = new StringBuilder();

    @Override
    public ReportBuilder addGeneralInfo(String info) {
        content.append("info,\"").append(info).append("\"\n");
        return this;
    }

    @Override
    public ReportBuilder addStatistics(String statistics) {
        content.append("statistics,\"").append(statistics).append("\"\n");
        return this;
    }

    @Override
    public ReportBuilder addTransactionDetails(String details) {
        content.append("transactions,\"").append(details).append("\"\n");
        return this;
    }

    @Override
    public ReportBuilder addSummary(String summary) {
        content.append("summary,\"").append(summary).append("\"\n");
        return this;
    }

    @Override
    public Report build() {
        return new Report("CSV", content.toString());
    }
}
