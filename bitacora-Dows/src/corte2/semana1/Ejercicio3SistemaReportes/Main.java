package corte2.semana1.Ejercicio3SistemaReportes;

public class Main {
    public static void main(String[] args) {
        String generalInfo = "Reporte del sistema de comercio electrónico";
        String statistics = "Ventas totales: 1200, Usuarios activos: 350";
        String transactionDetails = "ID1234: $100, ID1235: $250, ID1236: $300";
        String summary = "El sistema se encuentra estable, con crecimiento mensual del 8%.";

        ReportDirector pdfDirector = new ReportDirector(new PdfReportBuilder());
        Report pdfReport = pdfDirector.buildReport(generalInfo, statistics, transactionDetails, summary);
        ReportGenerator signedPdf = new DigitalSignatureDecorator(new BasicReportGenerator(pdfReport));
        System.out.println(signedPdf.generate());

        ReportDirector csvDirector = new ReportDirector(new CsvReportBuilder());
        Report csvReport = csvDirector.buildReport(generalInfo, statistics, transactionDetails, summary);
        ReportGenerator watermarkedCsv = new WatermarkDecorator(new BasicReportGenerator(csvReport));
        System.out.println(watermarkedCsv.generate());

        ReportDirector jsonDirector = new ReportDirector(new JsonReportBuilder());
        Report jsonReport = jsonDirector.buildReport(generalInfo, statistics, transactionDetails, summary);
        ReportGenerator compressedJson = new CompressionDecorator(new BasicReportGenerator(jsonReport));
        System.out.println(compressedJson.generate());
    }
}
