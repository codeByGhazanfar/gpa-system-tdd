package org.example.tdd.gpasystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScholarshipEligibilityPolicyTest {

    private ScholarshipEligibilityPolicy policy;

    @BeforeEach
    void setUp() {
        policy = new ScholarshipEligibilityPolicy();
    }

    @Test
    @DisplayName("Student meets both requirements (CGPA >= 3.5 and Credits >= 24)")
    void testMeetsBothRequirements() {
        IStudent student = new FakeStudent("STU01", 3.8, 30);
        assertTrue(policy.isEligible(student));
    }

    @Test
    @DisplayName("Student lands exactly on thresholds (CGPA = 3.5 and Credits = 24)")
    void testLandsExactlyOnThresholds() {
        IStudent student = new FakeStudent("STU02", 3.5, 24);
        assertTrue(policy.isEligible(student));
    }

    @Test
    @DisplayName("Student misses GPA requirement individually")
    void testMissesGpaRequirement() {
        IStudent student = new FakeStudent("STU03", 3.49, 30);
        assertFalse(policy.isEligible(student));
    }

    @Test
    @DisplayName("Student misses credits requirement individually")
    void testMissesCreditsRequirement() {
        IStudent student = new FakeStudent("STU04", 3.8, 20);
        assertFalse(policy.isEligible(student));
    }

    @Test
    @DisplayName("Student has no completed coursework")
    void testNoCompletedCoursework() {
        IStudent student = new FakeStudent("STU05", 0.0, 0);
        assertFalse(policy.isEligible(student));
    }
}
