package corte2.semana1.DOSWLearningAnalyticsSystem;

import java.util.List;

public class Student {
    private String id;
    private String name;
    private String team;
    private List<Grade> grades;

    // Constructores, Getters y Setters
    public String getName() { return name; }
    public String getTeam() { return team; }
    public List<Grade> getGrades() { return grades; }
}
