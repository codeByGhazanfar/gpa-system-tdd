package org.example.tdd.gpasystem;

import java.util.ArrayList;
import java.util.List;

public class Student implements IStudent {
    private String id;
    private String name;
    private List<SemesterRecord> semesters;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.semesters = new ArrayList<>();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<SemesterRecord> getSemesters() {
        return semesters;
    }

    public void addSemester(SemesterRecord semester) {
        if (this.semesters.size() < 8) {
            this.semesters.add(semester);
        }
    }

    @Override
    public double calculateSemesterGpa(int semesterNumber) {
        if (semesterNumber < 1 || semesterNumber > semesters.size()) {
            return 0.0;
        }
        SemesterRecord record = semesters.get(semesterNumber - 1);
        return record.calculateGpa();
    }

    @Override
    public double calculateCumulativeGpa() {
        double totalQualityPoints = 0;
        int totalCredits = 0;

        for (SemesterRecord record : semesters) {
            if (record.isCompleted()) {
                totalQualityPoints += record.calculateQualityPoints();
                totalCredits += record.getTotalCredits();
            }
        }

        if (totalCredits == 0) return 0.0;
        return totalQualityPoints / totalCredits;
    }

    @Override
    public int getCompletedCourseCredits() {
        int credits = 0;
        for (SemesterRecord record : semesters) {
            if (record.isCompleted()) {
                credits += record.getTotalCredits();
            }
        }
        return credits;
    }
}
