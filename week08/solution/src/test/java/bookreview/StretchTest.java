package bookreview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

// Stretch. Create the class CountingBookRepository. It implements BookRepository
// AND has a BookRepository inside (a decorator). Every call is passed on to the inner one.
// findById and findByAuthor also count one lookup each. getLookups() returns the number.
// To activate this test, remove the two comment lines marked below.
class StretchTest {

    @Test
    void stretch_countingRepository() {
        Book emma = new PrintedBook("Emma", "Jane Austen", "Classic", 1815, 474);
        CountingBookRepository counting = new CountingBookRepository(new MapBookRepository());
        counting.add(emma);
        ReviewService service = new ReviewService(counting);
        service.addReview(new User("ana", "ana@uacs.edu.mk"), emma.getId(), 4, "");
        service.booksByAuthorSorted("Jane Austen");
        assertEquals(2, counting.getLookups());
        assertSame(emma, counting.findById(emma.getId()));
        assertEquals(3, counting.getLookups());
    }
}
