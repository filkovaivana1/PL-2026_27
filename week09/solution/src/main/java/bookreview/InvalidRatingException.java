package bookreview;

// Week 9, task 1: a checked exception. The caller must catch it or declare it.
// A wrong rating comes from a user, and the program can react: ask again.
public class InvalidRatingException extends Exception {
    public InvalidRatingException(int rating) {
        super("Rating must be from 1 to 5, was " + rating);
    }
}
