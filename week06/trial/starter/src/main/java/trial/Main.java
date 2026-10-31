package trial;

import java.util.HashMap;
import java.util.Map;

// Run this class to compare your output with the expected output on the assignment paper.
public class Main {
    public static void main(String[] args) {
        Student ana = new Student("4711", "Ana Petrova");
        ana.addGrade(10);
        ana.addGrade(5);
        ana.addGrade(8);
        System.out.println("Grade 11 accepted? " + ana.addGrade(11));
        System.out.println(ana);

        Semester semester = new Semester();
        ProjectCourse web = new ProjectCourse("CSCI2440", "Internet Programming", 6);
        semester.addCourse(new LectureCourse("CSCI2430", "Programming Languages", 6));
        semester.addCourse(web);
        System.out.println("Same code again? " + semester.addCourse(new LectureCourse("CSCI2430", "Copy", 3)));

        Map<String, Integer> points = new HashMap<>();
        points.put("CSCI2430", 55);
        points.put("CSCI2440", 80);
        System.out.println("Passed ECTS before the project: " + semester.passedEcts(points));
        web.handInProject();
        System.out.println("Passed ECTS after the project: " + semester.passedEcts(points));
        System.out.println(web);
    }
}
