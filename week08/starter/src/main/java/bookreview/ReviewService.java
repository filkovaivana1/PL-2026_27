package bookreview;

import java.util.ArrayList;
import java.util.List;

// Task 4: the service gets its repository from outside, through the constructor.
// It must work with any BookRepository. Never write new InMemoryBookRepository() in this class.
public class ReviewService {
    // TODO: a private final field for the repository
    private final List<Review> reviews = new ArrayList<>();

    public ReviewService(BookRepository books) {
        // TODO: store the repository
    }

    // Refused with false when the user is null or no book has this id.
    public boolean addReview(User user, int bookId, int rating, String text) {
        return false; // TODO
    }

    public int reviewCount(int bookId) {
        return 0; // TODO
    }

    // 0.0 when the book has no review.
    public double averageRating(int bookId) {
        return 0.0; // TODO
    }

    // The books of one author, sorted with compareTo of Book (task 1).
    public List<Book> booksByAuthorSorted(String author) {
        return new ArrayList<>(); // TODO
    }
}
