**GPA System - Test-Driven Development (TDD) Lab Task**

A Maven-based Java application developed using Test-Driven Development (TDD) principles as part of the Software Quality Engineering (SQE) lab assignments at **COMSATS University Islamabad, Abbottabad Campus**.

**Student Information**
* **Name:** Ghazanfar Khan
* **Registration ID:** SP24-BSE-019
* **Program:** Bachelor of Science in Software Engineering (BSE - Semester 6)

---

Project Architecture & Components

The project follows standard Maven conventions (`src/main/java` and `src/test/java`):

* **`IPerson.java` & `IStudent.java`**: Core interfaces defining student attributes and academic behavior contracts.
* **`Student.java`**: Implements student records and term indexing.
* **`SemesterRecord.java` & `CourseResult.java`**: Manages course grades, credits, and semester tracking.
* **`GradingPolicyManager.java`**: Handles mapping percentage grades to letter grades and grade points.
* **`GpaCalculator.java`**: Computes weighted semester GPAs, cumulative GPAs, and statistics.
* **`ScholarshipEligibilityPolicy.java`**: Evaluates scholarship criteria based on academic thresholds.

---

## Lab Task Requirements: Scholarship Policy
Implements the COMSATS Scholarship Eligibility policy verifying that:
1. **Cumulative GPA $\ge$ 3.5**
2. **Completed Course Credits $\ge$ 24**

The test suite covers:
* Students meeting both requirements.
* Students missing individual requirements (GPA or credits).
* Boundary threshold cases (landing exactly on 3.5 CGPA and 24 credits).
* Students with zero completed coursework.

---

## Test Execution & Verification

The project uses **JUnit 5** and **Maven** for rigorous test automation. All unit tests pass successfully.

To run the test suite locally, execute the following commands in your terminal:

```bash
cd gpa-system-tdd
mvn clean test
