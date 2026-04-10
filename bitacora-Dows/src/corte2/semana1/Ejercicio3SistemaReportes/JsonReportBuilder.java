package corte2.semana1.Ejercicio3SistemaReportes;

public class JsonReportBuilder implements ReportBuilder {
    private final StringBuilder content = new StringBuilder();
    private boolean firstSection = true;

    public JsonReportBuilder() {
        content.append("{\n");
    }

    private void addProperty(String key, String value) {
        if (!firstSection) {
            content.append(",\n");
        }
        content.append("  \"").append(key).append("\": \"").append(value).append("\"");
        firstSection = false;
    }

    @Override
    public ReportBuilder addGeneralInfo(String info) {
        addProperty("generalInfo", info);
        return this;
    }

    @Override
    public ReportBuilder addStatistics(String statistics) {
        addProperty("statistics", statistics);
        return this;
    }

    @Override
    public ReportBuilder addTransactionDetails(String details) {
        addProperty("transactionDetails", details);
        return this;
    }

    @Override
    public ReportBuilder addSummary(String summary) {
        addProperty("summary", summary);
        return this;
    }

    @Override
    public Report build() {
        content.append("\n}");
        return new Report("JSON", content.toString());
    }
}
