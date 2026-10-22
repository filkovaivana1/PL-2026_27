package bookreview;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

// Task 1. The record Review does not exist yet. Create src/main/java/bookreview/Review.java:
//   public record Review(User user, Book book, int rating, String text)
// with a compact constructor that keeps the rating between 1 and 5 and turns a null text into "".
class ReviewTest {
    private User ana = new User("ana", "ana@example.com");
    private Book dune = new Book("Dune", "Frank Herbert", "Science fiction", 1965);

    @Test
    void task1_accessors() {
        Review review = new Review(ana, dune, 4, "Good");
        assertEquals(ana, review.user());
        assertEquals(dune, review.book());
        assertEquals(4, review.rating());
        assertEquals("Good", review.text());
    }

    @Test
    void task1_ratingIsKeptBetween1And5() {
        assertEquals(5, new Review(ana, dune, 99, "x").rating());
        assertEquals(1, new Review(ana, dune, -3, "x").rating());
        assertEquals(1, new Review(ana, dune, 0, "x").rating());
    }

    @Test
    void task1_nullTextBecomesEmpty() {
        assertEquals("", new Review(ana, dune, 3, null).text());
    }

    @Test
    void task1_recordsWithEqualContentAreEqual() {
        assertEquals(new Review(ana, dune, 3, "ok"), new Review(ana, dune, 3, "ok"));
    }
}
