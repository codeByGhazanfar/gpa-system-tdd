package org.example.tdd.gpasystem;

import java.util.List;

public interface IStudent extends IPerson {
    String getId();
    List<SemesterRecord> getSemesters();
    double calculateSemesterGpa(int semesterNumber);
    double calculateCumulativeGpa();
    int getCompletedCourseCredits();
}
