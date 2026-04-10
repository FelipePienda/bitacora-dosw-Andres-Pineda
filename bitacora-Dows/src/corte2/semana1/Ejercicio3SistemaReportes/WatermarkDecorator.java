package corte2.semana1.Ejercicio3SistemaReportes;

public class WatermarkDecorator extends ReportDecorator {
    public WatermarkDecorator(ReportGenerator wrapped) {
        super(wrapped);
    }

    @Override
    public Report generate() {
        Report report = wrapped.generate();
        String watermarked = "[Marca de agua: Plataforma Segura]\n" + report.getContent();
        return new Report(report.getFormat(), watermarked);
    }
}
