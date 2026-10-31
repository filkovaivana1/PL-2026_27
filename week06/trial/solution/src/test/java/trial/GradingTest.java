package trial;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

// FOR THE INSTRUCTORS. The students do not get this file during the trial or the exam.
// Copy a student's src/main/java/trial next to it and run it as a first check before the defence.
class GradingTest {

    @Test
    void a1_constructorAndName() {
        assertEquals("4711", new Student("4711", "Ana").getIndex());
        assertEquals("Ana", new Student("4711", "Ana").getName());
        assertEquals("Unknown", new Student("1", " ").getName());
        assertEquals("Unknown", new Student("1", null).getName());
    }

    @Test
    void a1_onlyGradesFrom5To10() {
        Student s = new Student("1", "Ana");
        assertTrue(s.addGrade(5));
        assertTrue(s.addGrade(10));
        assertFalse(s.addGrade(4));
        assertFalse(s.addGrade(11));
        assertEquals(2, s.gradeCount());
    }

    @Test
    void a1_passedCountAndAverage() {
        Student s = new Student("1", "Ana");
        assertEquals(0.0, s.average());
        s.addGrade(5);
        assertEquals(0, s.passedCount());
        assertEquals(0.0, s.average());
        s.addGrade(10);
        s.addGrade(7);
        assertEquals(2, s.passedCount());
        assertEquals(8.5, s.average());
    }

    @Test
    void a1_toString() {
        Student s = new Student("4711", "Ana Petrova");
        s.addGrade(10);
        s.addGrade(5);
        s.addGrade(8);
        assertEquals("4711 Ana Petrova, passed 2, average 9.0", s.toString());
    }

    @Test
    void a2_courseIsAbstractAndProtectsEcts() {
        assertTrue(Modifier.isAbstract(Course.class.getModifiers()));
        assertEquals(1, new LectureCourse("X", "x", 0).getEcts());
        assertEquals(6, new LectureCourse("X", "x", 6).getEcts());
    }

    @Test
    void a2_passRules() {
        Course lecture = new LectureCourse("L", "l", 6);
        assertTrue(lecture.isPassed(50));
        assertFalse(lecture.isPassed(49));
        ProjectCourse project = new ProjectCourse("P", "p", 6);
        assertFalse(project.isPassed(100));
        project.handInProject();
        assertTrue(project.isPassed(60));
        assertFalse(project.isPassed(59));
    }

    @Test
    void a2_equalsByCodeAndToString() {
        assertEquals(new LectureCourse("C1", "a", 6), new ProjectCourse("C1", "b", 3));
        assertNotEquals(new LectureCourse("C1", "a", 6), new LectureCourse("C2", "a", 6));
        assertEquals(new LectureCourse("C1", "a", 6).hashCode(), new ProjectCourse("C1", "b", 3).hashCode());
        assertEquals("C1 Java (6 ECTS, lecture)", new LectureCourse("C1", "Java", 6).toString());
        assertEquals("C2 Web (3 ECTS, project)", new ProjectCourse("C2", "Web", 3).toString());
    }

    @Test
    void a2_semester() {
        Semester semester = new Semester();
        ProjectCourse web = new ProjectCourse("C2", "Web", 3);
        assertTrue(semester.addCourse(new LectureCourse("C1", "Java", 6)));
        assertTrue(semester.addCourse(web));
        assertFalse(semester.addCourse(new LectureCourse("C1", "Copy", 9)));
        assertEquals(2, semester.courseCount());
        assertEquals(9, semester.totalEcts());

        Map<String, Integer> points = new HashMap<>();
        assertEquals(0, semester.passedEcts(points));
        points.put("C1", 55);
        points.put("C2", 80);
        assertEquals(6, semester.passedEcts(points));
        web.handInProject();
        assertEquals(9, semester.passedEcts(points));
    }
}
