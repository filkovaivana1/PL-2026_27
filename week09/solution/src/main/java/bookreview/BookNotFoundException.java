package bookreview;

// Week 9, task 2: an unchecked exception. Asking for a book that does not exist
// is a programming error or a stale id, not something every caller must plan for.
public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(int id) {
        super("No book with id " + id);
    }
}
