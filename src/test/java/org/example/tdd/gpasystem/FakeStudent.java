package org.example.tdd.gpasystem;

import java.util.ArrayList;
import java.util.List;

public class FakeStudent implements IStudent {
    private String id;
    private String name;
    private double cumulativeGpa;
    private int completedCredits;

    public FakeStudent(String id, double cumulativeGpa, int completedCredits) {
        this.id = id;
        this.name = "Fake Student";
        this.cumulativeGpa = cumulativeGpa;
        this.completedCredits = completedCredits;
    }

    @Override
    public String getId() { return id; }

    @Override
    public String getName() { return name; }

    @Override
    public List<SemesterRecord> getSemesters() { return new ArrayList<>(); }

    @Override
    public double calculateSemesterGpa(int semesterNumber) { return cumulativeGpa; }

    @Override
    public double calculateCumulativeGpa() { return cumulativeGpa; }

    @Override
    public int getCompletedCourseCredits() { return completedCredits; }
}
