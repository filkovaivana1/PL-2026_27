package bookreview;

import java.util.ArrayList;
import java.util.List;

// Week 8: the service gets its repository from outside, through the constructor.
// Week 9: it refuses bad input with exceptions.
public class ReviewService {
    private final BookRepository books;
    private final List<Review> reviews = new ArrayList<>();

    public ReviewService(BookRepository books) {
        this.books = books;
    }

    // Task 2: return the book with this id. No such book: throw a new BookNotFoundException(bookId).
    public Book findBook(int bookId) {
        return null; // TODO
    }

    // Task 2: refuse bad input with exceptions, not with false.
    // user null: IllegalArgumentException. Unknown book: BookNotFoundException (use findBook).
    // rating outside 1 to 5: InvalidRatingException. Otherwise store a new Review.
    public void addReview(User user, int bookId, int rating, String text) throws InvalidRatingException {
        // TODO
    }

    public int reviewCount(int bookId) {
        int count = 0;
        for (Review review : reviews) {
            if (review.book().getId() == bookId) {
                count++;
            }
        }
        return count;
    }

    // 0.0 when the book has no review.
    public double averageRating(int bookId) {
        int sum = 0;
        int count = 0;
        for (Review review : reviews) {
            if (review.book().getId() == bookId) {
                sum += review.rating();
                count++;
            }
        }
        if (count == 0) {
            return 0.0;
        }
        return (double) sum / count;
    }

    // The books of one author, sorted with compareTo of Book (task 1).
    public List<Book> booksByAuthorSorted(String author) {
        List<Book> result = books.findByAuthor(author);
        result.sort(null);
        return result;
    }
}
