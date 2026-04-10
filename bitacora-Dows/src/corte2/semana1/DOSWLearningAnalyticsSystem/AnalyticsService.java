package corte2.semana1.DOSWLearningAnalyticsSystem;

import java.util.*;
import java.util.stream.Collectors;

public class AnalyticsService {

    // 1. Obtener estudiantes del equipo DORADO
    public List<Student> getDoradoStudents(List<Student> students) {
        return students.stream()
                .filter(s -> "DORADO".equalsIgnoreCase(s.getTeam()))
                .collect(Collectors.toList());
    }

    // 2. Nombres ordenados alfabéticamente
    public List<String> getSortedNames(List<Student> students) {
        return students.stream()
                .map(Student::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    // 3. Promedio general de todos los scores
    public double getGeneralAverage(List<Student> students) {
        return students.stream()
                .flatMap(s -> s.getGrades().stream())
                .mapToDouble(Grade::getScore)
                .average()
                .orElse(0.0);
    }

    // 4. Promedio por materia de un estudiante
    public Map<String, Double> getSubjectAverageByStudent(Student student) {
        return student.getGrades().stream()
                .collect(Collectors.groupingBy(
                        Grade::getSubject,
                        Collectors.averagingDouble(Grade::getScore)
                ));
    }

    // 5. Estudiante con promedio más alto
    public Optional<Student> getTopStudent(List<Student> students) {
        return students.stream()
                .max(Comparator.comparingDouble(this::calculateStudentAverage));
    }

    // 6. Materias reprobadas por equipo
    public Map<String, Long> getFailedGradesByTeam(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getTeam,
                        Collectors.flatMapping(
                                s -> s.getGrades().stream().filter(g -> !g.isPassed()),
                                Collectors.counting()
                        )
                ));
    }

    // 7. Top 3 estudiantes con más materias aprobadas
    public List<Student> getTop3Approved(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparingLong((Student s) ->
                        s.getGrades().stream().filter(Grade::isPassed).count()).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    // 8. Agrupar por estado académico
    public Map<String, List<Student>> groupByPerformance(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(s -> {
                    double avg = calculateStudentAverage(s);
                    if (avg >= 4.5) return "ALTO RENDIMIENTO";
                    if (avg >= 3.5) return "REGULAR";
                    return "RIESGO";
                }));
    }

    // 9. Materia con más reprobaciones
    public String getMostFailedSubject(List<Student> students) {
        return students.stream()
                .flatMap(s -> s.getGrades().stream())
                .filter(g -> !g.isPassed())
                .collect(Collectors.groupingBy(Grade::getSubject, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("N/A");
    }

    // 10. Análisis avanzado Equipo DORADO (Encadenamiento complejo)
    public LinkedHashMap<String, Double> getDoradoPerformanceReport(List<Student> students) {
        return students.stream()
                .filter(s -> "DORADO".equals(s.getTeam()))
                .flatMap(s -> s.getGrades().stream())
                .filter(Grade::isPassed)
                .collect(Collectors.groupingBy(
                        Grade::getSubject,
                        Collectors.averagingDouble(Grade::getScore)
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    // Helper method
    private double calculateStudentAverage(Student s) {
        return s.getGrades().stream()
                .mapToDouble(Grade::getScore)
                .average()
                .orElse(0.0);
    }
}