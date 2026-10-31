package trial;

import java.util.Objects;

// Assignment 2. A course. Every kind of course decides by itself when it is passed.
public abstract class Course {
    private String code;
    private String title;
    private int ects;

    public Course(String code, String title, int ects) {
        this.code = code;
        this.title = title;
        if (ects < 1) {
            this.ects = 1;
        } else {
            this.ects = ects;
        }
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getEcts() {
        return ects;
    }

    public abstract boolean isPassed(int points);

    public abstract String kind();

    // Two courses are equal when their codes are equal.
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Course that)) {
            return false;
        }
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return code + " " + title + " (" + ects + " ECTS, " + kind() + ")";
    }
}
