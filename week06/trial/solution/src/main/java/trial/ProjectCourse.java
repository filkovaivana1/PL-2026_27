package trial;

// A course with a project. Passed with 60 points or more, and only when the project was handed in.
public class ProjectCourse extends Course {
    private boolean projectHandedIn;

    public ProjectCourse(String code, String title, int ects) {
        super(code, title, ects);
    }

    public void handInProject() {
        projectHandedIn = true;
    }

    public boolean isProjectHandedIn() {
        return projectHandedIn;
    }

    @Override
    public boolean isPassed(int points) {
        return projectHandedIn && points >= 60;
    }

    @Override
    public String kind() {
        return "project";
    }
}
