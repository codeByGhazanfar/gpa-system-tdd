package org.example.tdd.gpasystem;

import java.util.ArrayList;
import java.util.List;
public class TestDataGenerator {

    /** Builds a list of courses, each 3 credits, with the given percentages. */
    public static List<CourseResult> courses(double... percentages) {
        List<CourseResult> list = new ArrayList<>();
        for (int i = 0; i < percentages.length; i++) {
            list.add(new CourseResult("Course" + (i + 1), 3, percentages[i]));
        }
        return list;
    }

    public static SemesterRecord completedSemester(int number, double... percentages) {
        return new SemesterRecord(number, courses(percentages), true);
    }

    public static SemesterRecord inProgressSemester(int number, double... percentages) {
        return new SemesterRecord(number, courses(percentages), false);
    }
    public static Student studentWithOneSemester(String id, double... percentages) {
        Student s = new Student(id, "Student " + id);
        s.addSemester(completedSemester(1, percentages));
        return s;
    }
}
