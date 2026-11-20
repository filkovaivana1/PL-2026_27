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

    // Week 9, task 2: the book, or a BookNotFoundException.
    public Book findBook(int bookId) {
        Book book = books.findById(bookId);
        if (book == null) {
            throw new BookNotFoundException(bookId);
        }
        return book;
    }

    // Week 9: bad input is refused with an exception, not with false.
    public void addReview(User user, int bookId, int rating, String text) throws InvalidRatingException {
        if (user == null) {
            throw new IllegalArgumentException("user must not be null");
        }
        Book book = findBook(bookId);
        if (rating < 1 || rating > 5) {
            throw new InvalidRatingException(rating);
        }
        reviews.add(new Review(user, book, rating, text));
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
