package corte2.semana1.Ejercicio3SistemaReportes;

public class Report {
    private final String format;
    private final String content;

    public Report(String format, String content) {
        this.format = format;
        this.content = content;
    }

    public String getFormat() {
        return format;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "---- Reporte (" + format + ") ----\n" + content + "\n--------------------------";
    }
}
