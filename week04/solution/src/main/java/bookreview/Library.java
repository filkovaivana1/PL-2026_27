package bookreview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// The heart of the platform: it has books, users and reviews (composition).
public class Library {
    private List<Book> books = new ArrayList<>();
    private Map<String, User> users = new HashMap<>();
    private List<Review> reviews = new ArrayList<>();

    // ----- Task 3: books and users -----

    public boolean addBook(Book book) {
        if (books.contains(book)) {
            return false;
        }
        books.add(book);
        return true;
    }

    public int bookCount() {
        return books.size();
    }

    public boolean registerUser(User user) {
        if (users.containsKey(user.getUsername())) {
            return false;
        }
        users.put(user.getUsername(), user);
        return true;
    }

    public User findUser(String username) {
        return users.get(username);
    }

    // ----- Task 4: overloaded search -----

    public List<Book> findBooks(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> findBooks(int fromYear, int toYear) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() >= fromYear && book.getYear() <= toYear) {
                result.add(book);
            }
        }
        return result;
    }

    // ----- Task 5: reviews -----

    public boolean addReview(String username, Book book, int rating, String text) {
        User user = findUser(username);
        if (user == null || !books.contains(book)) {
            return false;
        }
        reviews.add(new Review(user, book, rating, text));
        return true;
    }

    public double averageRating(Book book) {
        int sum = 0;
        int count = 0;
        for (Review review : reviews) {
            if (review.book().equals(book)) {
                sum += review.rating();
                count++;
            }
        }
        if (count == 0) {
            return 0.0;
        }
        return (double) sum / count;
    }

    public Map<String, Integer> countByGenre() {
        Map<String, Integer> counts = new TreeMap<>();
        for (Book book : books) {
            counts.put(book.getGenre(), counts.getOrDefault(book.getGenre(), 0) + 1);
        }
        return counts;
    }

    // ----- Stretch -----

    public Book topRated() {
        Book best = null;
        for (Book book : books) {
            if (best == null || averageRating(book) > averageRating(best)) {
                best = book;
            }
        }
        return best;
    }

    public int removeBooksOlderThan(int year) {
        int removed = 0;
        for (int i = books.size() - 1; i >= 0; i--) {
            if (books.get(i).getYear() < year) {
                books.remove(i);
                removed++;
            }
        }
        return removed;
    }
}
