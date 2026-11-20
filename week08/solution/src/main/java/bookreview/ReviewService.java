package bookreview;

import java.util.ArrayList;
import java.util.List;

// Week 8, task 4: the service gets its repository from outside, through the constructor.
// It works with any BookRepository: the list one, the map one, or a fake one in a test.
public class ReviewService {
    private final BookRepository books;
    private final List<Review> reviews = new ArrayList<>();

    public ReviewService(BookRepository books) {
        this.books = books;
    }

    // Refused with false when the user is null or no book has this id.
    public boolean addReview(User user, int bookId, int rating, String text) {
        Book book = books.findById(bookId);
        if (user == null || book == null) {
            return false;
        }
        reviews.add(new Review(user, book, rating, text));
        return true;
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
