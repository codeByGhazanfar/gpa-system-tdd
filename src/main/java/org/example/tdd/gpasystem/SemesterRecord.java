package org.example.tdd.gpasystem;

import java.util.List;

public class SemesterRecord {
    private int semesterNumber;
    private List<CourseResult> courseResults;
    private boolean completed;

    public SemesterRecord(int semesterNumber, List<CourseResult> courseResults, boolean completed) {
        this.semesterNumber = semesterNumber;
        this.courseResults = courseResults;
        this.completed = completed;

        // Enforce completed semester course count rule (4 or 5 courses)
        if (completed && (courseResults.size() < 4 || courseResults.size() > 5)) {
            throw new IllegalArgumentException("A completed semester must contain 4 or 5 courses.");
        }
    }

    public boolean isCompleted() {
        return completed;
    }

    public int getSemesterNumber() {
        return semesterNumber;
    }

    public List<CourseResult> getCourseResults() {
        return courseResults;
    }

    public double calculateGpa() {
        double totalPoints = 0;
        int totalCredits = 0;
        for (CourseResult cr : courseResults) {
            totalPoints += cr.getGradePoints() * cr.getCredits();
            totalCredits += cr.getCredits();
        }
        if (totalCredits == 0) return 0.0;
        return totalPoints / totalCredits;
    }

    public double calculateQualityPoints() {
        double totalPoints = 0;
        for (CourseResult cr : courseResults) {
            totalPoints += cr.getGradePoints() * cr.getCredits();
        }
        return totalPoints;
    }

    public int getTotalCredits() {
        int totalCredits = 0;
        for (CourseResult cr : courseResults) {
            totalCredits += cr.getCredits();
        }
        return totalCredits;
    }
}
