package corte2.semana1.DOSWLearningAnalyticsSystem;

import java.time.LocalDate;

public class Grade {
    private String subject;
    private double score;
    private LocalDate date;
    private boolean passed;

    // Constructores, Getters y Setters
    public String getSubject() { return subject; }
    public double getScore() { return score; }
    public boolean isPassed() { return passed; }
}
