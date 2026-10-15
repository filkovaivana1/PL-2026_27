package bookreview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// The heart of the platform: it has books, users and reviews (composition).
public class Library {
    private List<Book> books = new ArrayList<>();
    private Map<String, User> users = new HashMap<>();
    // Task 5: add a list for the reviews

    // ----- Task 3: books and users -----

    // Adds the book and returns true. A book that is already there is refused: return false.
    public boolean addBook(Book book) {
        return false; // TODO
    }

    public int bookCount() {
        return 0; // TODO
    }

    // Stores the user under the username and returns true. A taken username is refused: return false.
    public boolean registerUser(User user) {
        return false; // TODO
    }

    // The user with this username, or null.
    public User findUser(String username) {
        return null; // TODO
    }

    // ----- Task 4: overloaded search -----

    // All books of this author. Upper and lower case do not matter.
    public List<Book> findBooks(String author) {
        return new ArrayList<>(); // TODO
    }

    // Same name, other parameters: an overload.
    // All books with fromYear <= year <= toYear.
    public List<Book> findBooks(int fromYear, int toYear) {
        return new ArrayList<>(); // TODO
    }

    // ----- Task 5: reviews -----
    // Creates a Review and stores it. Returns false when the username is unknown
    // or when the book is not in this library.
    public boolean addReview(String username, Book book, int rating, String text) {
        return false; // TODO
    }

    // The average rating of this book, or 0.0 when it has no review.
    public double averageRating(Book book) {
        return 0.0; // TODO
    }

    // How many books each genre has. Use a TreeMap so the genres are sorted.
    public Map<String, Integer> countByGenre() {
        return new HashMap<>(); // TODO
    }

    // ----- Stretch -----

    // The book with the highest average rating, or null when the library is empty.
    public Book topRated() {
        return null; // TODO
    }

    // Removes all books published before this year and returns how many were removed.
    // Careful: removing while looping. See the lecture.
    public int removeBooksOlderThan(int year) {
        return 0; // TODO
    }
}
