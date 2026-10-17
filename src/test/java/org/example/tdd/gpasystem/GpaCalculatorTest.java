package org.example.tdd.gpasystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GpaCalculatorTest {

    private GpaCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new GpaCalculator();
    }

    @Test
    @DisplayName("Grade points map correctly from percentages")
    void testGradePointMapping() {
        assertEquals(4.0, GradingPolicyManager.evaluateGradePoints(95));
        assertEquals(4.0, GradingPolicyManager.evaluateGradePoints(90));
        assertEquals(3.0, GradingPolicyManager.evaluateGradePoints(85));
        assertEquals(2.0, GradingPolicyManager.evaluateGradePoints(75));
        assertEquals(1.0, GradingPolicyManager.evaluateGradePoints(65));
        assertEquals(0.0, GradingPolicyManager.evaluateGradePoints(59));
    }

    @Test
    @DisplayName("Semester GPA is credit-weighted average of grade points")
    void testSemesterGpa() {
        Student s = TestDataGenerator.studentWithOneSemester("S1", 95, 85, 75, 65);
        // (4 + 3 + 2 + 1) / 4 = 2.5
        assertEquals(2.5, s.calculateSemesterGpa(1), 0.001);
    }

    @Test
    @DisplayName("Invalid semester number returns 0")
    void testInvalidSemesterNumber() {
        Student s = TestDataGenerator.studentWithOneSemester("S1", 95, 85, 75, 65);
        assertEquals(0.0, s.calculateSemesterGpa(0));
        assertEquals(0.0, s.calculateSemesterGpa(5));
    }

    @Test
    @DisplayName("Cumulative GPA ignores incomplete semesters")
    void testCumulativeGpaIgnoresIncomplete() {
        Student s = TestDataGenerator.studentWithOneSemester("S1", 95, 95, 95, 95);
        s.addSemester(TestDataGenerator.inProgressSemester(2, 50, 50));
        assertEquals(4.0, s.calculateCumulativeGpa(), 0.001);
        assertEquals(12, s.getCompletedCourseCredits());
    }

    @Test
    @DisplayName("Completed semester with fewer than 4 courses is rejected")
    void testCompletedSemesterTooFewCourses() {
        assertThrows(IllegalArgumentException.class,
                () -> TestDataGenerator.completedSemester(1, 90, 90, 90));
    }

    @Test
    @DisplayName("Completed semester with more than 5 courses is rejected")
    void testCompletedSemesterTooManyCourses() {
        assertThrows(IllegalArgumentException.class,
                () -> TestDataGenerator.completedSemester(1, 90, 90, 90, 90, 90, 90));
    }

    @Test
    @DisplayName("Student cannot have more than 8 semesters")
    void testMaxEightSemesters() {
        Student s = new Student("S1", "Test");
        for (int i = 1; i <= 10; i++) {
            s.addSemester(TestDataGenerator.completedSemester(i, 90, 90, 90, 90));
        }
        assertEquals(8, s.getSemesters().size());
    }

    @Test
    @DisplayName("Average performer is the student closest to the mean CGPA")
    void testFindAveragePerformer() {
        IStudent low = new FakeStudent("L", 2.0, 30);
        IStudent mid = new FakeStudent("M", 3.0, 30);
        IStudent high = new FakeStudent("H", 4.0, 30);
        List<IStudent> students = Arrays.asList(low, mid, high);
        assertSame(mid, calculator.findAveragePerformer(students));
    }

    @Test
    @DisplayName("Empty or null collection returns null")
    void testFindAveragePerformerEmpty() {
        assertNull(calculator.findAveragePerformer(new ArrayList<>()));
        assertNull(calculator.findAveragePerformer(null));
    }

    @Test
    @DisplayName("Single student is the average performer")
    void testSingleStudent() {
        IStudent only = new FakeStudent("O", 3.2, 24);
        assertSame(only, calculator.findAveragePerformer(List.of(only)));
    }
}
