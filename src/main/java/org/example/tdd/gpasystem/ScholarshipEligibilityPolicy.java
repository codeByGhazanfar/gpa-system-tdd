package org.example.tdd.gpasystem;

public class ScholarshipEligibilityPolicy {
    private static final double MIN_CGPA = 3.5;
    private static final int MIN_CREDITS = 24;

    public boolean isEligible(IStudent student) {
        if (student == null) {
            return false;
        }
        return student.calculateCumulativeGpa() >= MIN_CGPA
                && student.getCompletedCourseCredits() >= MIN_CREDITS;
    }
}
