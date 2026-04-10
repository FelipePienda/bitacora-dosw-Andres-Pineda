package corte2.semana1.Ejercicio3SistemaReportes;

public class PdfReportBuilder implements ReportBuilder {
    private final StringBuilder content = new StringBuilder();

    @Override
    public ReportBuilder addGeneralInfo(String info) {
        content.append("[PDF] Información general:\n").append(info).append("\n\n");
        return this;
    }

    @Override
    public ReportBuilder addStatistics(String statistics) {
        content.append("[PDF] Estadísticas:\n").append(statistics).append("\n\n");
        return this;
    }

    @Override
    public ReportBuilder addTransactionDetails(String details) {
        content.append("[PDF] Detalle de transacciones:\n").append(details).append("\n\n");
        return this;
    }

    @Override
    public ReportBuilder addSummary(String summary) {
        content.append("[PDF] Resumen final:\n").append(summary).append("\n");
        return this;
    }

    @Override
    public Report build() {
        return new Report("PDF", content.toString());
    }
}
