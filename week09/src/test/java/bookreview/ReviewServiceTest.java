package bookreview;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Task 2.
class ReviewServiceTest {
    private ReviewService service;
    private User ana;
    private Book emma;

    @BeforeEach
    void setUp() {
        BookRepository repository = new InMemoryBookRepository();
        emma = new PrintedBook("Emma", "Jane Austen", "Classic", 1815, 474);
        repository.add(emma);
        service = new ReviewService(repository);
        ana = new User("ana", "ana@uacs.edu.mk");
    }

    @Test
    void task2_findBook() {
        assertSame(emma, service.findBook(emma.getId()));
        BookNotFoundException e = assertThrows(BookNotFoundException.class, () -> service.findBook(-1));
        assertEquals("No book with id -1", e.getMessage());
    }

    @Test
    void task2_aValidReviewIsStored() throws InvalidRatingException {
        service.addReview(ana, emma.getId(), 5, "Loved it");
        service.addReview(ana, emma.getId(), 4, "");
        assertEquals(2, service.reviewCount(emma.getId()));
        assertEquals(4.5, service.averageRating(emma.getId()));
    }

    @Test
    void task2_badRatingsAreRefused() {
        assertThrows(InvalidRatingException.class, () -> service.addReview(ana, emma.getId(), 0, ""));
        assertThrows(InvalidRatingException.class, () -> service.addReview(ana, emma.getId(), 6, ""));
        assertDoesNotThrow(() -> service.addReview(ana, emma.getId(), 1, ""));
        assertEquals(1, service.reviewCount(emma.getId()));
    }

    @Test
    void task2_unknownBookAndMissingUser() {
        assertThrows(BookNotFoundException.class, () -> service.addReview(ana, -1, 3, ""));
        assertThrows(IllegalArgumentException.class, () -> service.addReview(null, emma.getId(), 3, ""));
        assertEquals(0, service.reviewCount(emma.getId()));
    }
}
