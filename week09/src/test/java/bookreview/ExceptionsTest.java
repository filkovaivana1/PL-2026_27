package bookreview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

// Task 1 (warm up). This file does not compile until both exception classes exist.
class ExceptionsTest {

    @Test
    void task1_invalidRatingIsChecked() {
        assertTrue(Exception.class.isAssignableFrom(InvalidRatingException.class));
        assertFalse(RuntimeException.class.isAssignableFrom(InvalidRatingException.class));
        assertEquals("Rating must be from 1 to 5, was 7", new InvalidRatingException(7).getMessage());
    }

    @Test
    void task1_bookNotFoundIsUnchecked() {
        assertTrue(RuntimeException.class.isAssignableFrom(BookNotFoundException.class));
        assertEquals("No book with id 42", new BookNotFoundException(42).getMessage());
    }
}
