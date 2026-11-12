package bookreview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Task 4.
class ReviewServiceTest {
    private BookRepository repository;
    private ReviewService service;
    private User ana;
    private Book emma;
    private Book persuasion;

    @BeforeEach
    void setUp() {
        repository = new InMemoryBookRepository();
        emma = new PrintedBook("Emma", "Jane Austen", "Classic", 1815, 474);
        persuasion = new AudioBook("Persuasion", "Jane Austen", "Classic", 1817, 510);
        repository.add(persuasion);
        repository.add(emma);
        service = new ReviewService(repository);
        ana = new User("ana", "ana@uacs.edu.mk");
    }

    @Test
    void task4_addReviewNeedsAUserAndAKnownBook() {
        assertTrue(service.addReview(ana, emma.getId(), 5, "Loved it"));
        assertFalse(service.addReview(ana, -1, 5, "No such book"));
        assertFalse(service.addReview(null, emma.getId(), 5, "No user"));
        assertEquals(1, service.reviewCount(emma.getId()));
        assertEquals(0, service.reviewCount(persuasion.getId()));
    }

    @Test
    void task4_averageRating() {
        assertEquals(0.0, service.averageRating(emma.getId()));
        service.addReview(ana, emma.getId(), 5, "");
        service.addReview(ana, emma.getId(), 4, "");
        assertEquals(4.5, service.averageRating(emma.getId()));
    }

    @Test
    void task4_booksByAuthorSorted() {
        assertEquals(List.of(emma, persuasion), service.booksByAuthorSorted("Jane Austen"));
    }

    @Test
    void task4_theServiceWorksWithAnyRepository() {
        // A fake repository, written right here. It always returns the same book.
        BookRepository fake = new BookRepository() {
            public boolean add(Book book) { return false; }
            public Book findById(int id) { return emma; }
            public List<Book> findAll() { return new ArrayList<>(); }
            public List<Book> findByAuthor(String author) { return new ArrayList<>(List.of(emma)); }
            public int count() { return 1; }
        };
        ReviewService withFake = new ReviewService(fake);
        assertTrue(withFake.addReview(ana, 12345, 3, "Any id works with the fake"));
        assertEquals(3.0, withFake.averageRating(emma.getId()));
    }
}
