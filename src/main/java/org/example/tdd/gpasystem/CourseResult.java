package org.example.tdd.gpasystem;

public class CourseResult {
    private String courseName;
    private int credits;
    private double percentage;
    private double gradePoints;

    public CourseResult(String courseName, int credits, double percentage) {
        this.courseName = courseName;
        this.credits = credits;
        this.percentage = percentage;
        this.gradePoints = GradingPolicyManager.evaluateGradePoints(percentage);
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    public double getPercentage() {
        return percentage;
    }

    public double getGradePoints() {
        return gradePoints;
    }
}
