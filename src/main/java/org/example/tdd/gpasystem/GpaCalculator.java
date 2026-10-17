package org.example.tdd.gpasystem;

import java.util.Collection;

public class GpaCalculator {

    public IStudent findAveragePerformer(Collection<IStudent> students) {
        if (students == null || students.isEmpty()) {
            return null;
        }

        double totalCgpa = 0;
        int count = 0;
        for (IStudent s : students) {
            totalCgpa += s.calculateCumulativeGpa();
            count++;
        }
        double mean = totalCgpa / count;

        IStudent closestStudent = null;
        double minDifference = Double.MAX_VALUE;

        for (IStudent s : students) {
            double diff = Math.abs(s.calculateCumulativeGpa() - mean);
            if (diff < minDifference) {
                minDifference = diff;
                closestStudent = s;
            }
        }
        return closestStudent;
    }
}
