package corte2.semana1.Ejercicio3SistemaReportes;

public class CompressionDecorator extends ReportDecorator {
    public CompressionDecorator(ReportGenerator wrapped) {
        super(wrapped);
    }

    @Override
    public Report generate() {
        Report report = wrapped.generate();
        String compressed = report.getContent().replaceAll("\\s+", " ");
        return new Report(report.getFormat() + " (comprimido)", compressed);
    }
}
