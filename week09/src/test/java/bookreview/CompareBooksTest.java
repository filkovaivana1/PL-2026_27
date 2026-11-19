package bookreview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

// From week 8. Still green: sorting books by year and title.
class CompareBooksTest {

    @Test
    void week8_olderBooksFirst() {
        Book dune = new EBook("Dune", "Frank Herbert", "Science fiction", 1965, 1.4);
        Book emma = new PrintedBook("Emma", "Jane Austen", "Classic", 1815, 474);
        assertTrue(emma.compareTo(dune) < 0);
        assertTrue(dune.compareTo(emma) > 0);
    }

    @Test
    void week8_sameYearByTitle() {
        Book b = new PrintedBook("Beta", "X", "Test", 2000, 100);
        Book a = new PrintedBook("Alpha", "Y", "Test", 2000, 100);
        assertTrue(a.compareTo(b) < 0);
        assertEquals(0, a.compareTo(a));
    }

    @Test
    void week8_collectionsSortUsesYourCompareTo() {
        List<Book> shelf = new ArrayList<>();
        shelf.add(new EBook("Neuromancer", "William Gibson", "Science fiction", 1984, 1.4));
        shelf.add(new PrintedBook("Emma", "Jane Austen", "Classic", 1815, 474));
        shelf.add(new AudioBook("Dune", "Frank Herbert", "Science fiction", 1965, 1260));
        Collections.sort(shelf);
        assertEquals("Emma", shelf.get(0).getTitle());
        assertEquals("Dune", shelf.get(1).getTitle());
        assertEquals("Neuromancer", shelf.get(2).getTitle());
    }
}
