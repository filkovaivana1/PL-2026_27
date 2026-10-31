package trial;

import java.util.ArrayList;
import java.util.List;

// Assignment 1. A student with an index number, a name and a list of grades from 5 to 10.
public class Student {
    private String index;
    private String name;
    private List<Integer> grades = new ArrayList<>();

    public Student(String index, String name) {
        this.index = index;
        if (name == null || name.isBlank()) {
            this.name = "Unknown";
        } else {
            this.name = name;
        }
    }

    public String getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    // Only grades from 5 to 10 are accepted.
    public boolean addGrade(int grade) {
        if (grade < 5 || grade > 10) {
            return false;
        }
        grades.add(grade);
        return true;
    }

    public int gradeCount() {
        return grades.size();
    }

    // Passed exams are the grades from 6 to 10.
    public int passedCount() {
        int count = 0;
        for (int grade : grades) {
            if (grade >= 6) {
                count++;
            }
        }
        return count;
    }

    // The average of the passed exams only. 0.0 when nothing is passed yet.
    public double average() {
        int sum = 0;
        int count = 0;
        for (int grade : grades) {
            if (grade >= 6) {
                sum += grade;
                count++;
            }
        }
        if (count == 0) {
            return 0.0;
        }
        return (double) sum / count;
    }

    @Override
    public String toString() {
        return index + " " + name + ", passed " + passedCount() + ", average " + average();
    }
}
