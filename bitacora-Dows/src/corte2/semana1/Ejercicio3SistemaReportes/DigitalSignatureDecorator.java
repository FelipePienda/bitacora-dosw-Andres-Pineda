package corte2.semana1.Ejercicio3SistemaReportes;

public class DigitalSignatureDecorator extends ReportDecorator {
    public DigitalSignatureDecorator(ReportGenerator wrapped) {
        super(wrapped);
    }

    @Override
    public Report generate() {
        Report report = wrapped.generate();
        String signedContent = report.getContent() + "\n[Firma digital aplicada]";
        return new Report(report.getFormat(), signedContent);
    }
}
