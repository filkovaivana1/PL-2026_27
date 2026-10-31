package trial;

// A course with a written exam. Passed with 50 points or more.
public class LectureCourse extends Course {
    public LectureCourse(String code, String title, int ects) {
        super(code, title, ects);
    }

    @Override
    public boolean isPassed(int points) {
        return points >= 50;
    }

    @Override
    public String kind() {
        return "lecture";
    }
}
