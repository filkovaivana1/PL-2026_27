package trial;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Assignment 2. A semester has courses (composition).
public class Semester {
    private List<Course> courses = new ArrayList<>();

    // A course with a code that is already there is refused.
    public boolean addCourse(Course course) {
        if (courses.contains(course)) {
            return false;
        }
        courses.add(course);
        return true;
    }

    public int courseCount() {
        return courses.size();
    }

    public int totalEcts() {
        int total = 0;
        for (Course course : courses) {
            total += course.getEcts();
        }
        return total;
    }

    // points: the points of one student, by course code. A course without an entry counts as not passed.
    public int passedEcts(Map<String, Integer> points) {
        int total = 0;
        for (Course course : courses) {
            Integer result = points.get(course.getCode());
            if (result != null && course.isPassed(result)) {
                total += course.getEcts();
            }
        }
        return total;
    }
}
