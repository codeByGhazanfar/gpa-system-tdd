package org.example.tdd.gpasystem;

public class GradingPolicyManager {
    public static double evaluateGradePoints(double percentage) {
        if (percentage >= 90) return 4.0;
        if (percentage >= 80) return 3.0;
        if (percentage >= 70) return 2.0;
        if (percentage >= 60) return 1.0;
        return 0.0;
    }
}
