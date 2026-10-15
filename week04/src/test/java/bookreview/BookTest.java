package bookreview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class BookTest {

    @Test
    void task2_shortConstructor() {
        Book emma = new Book("Emma", "Jane Austen");
        assertEquals("Emma", emma.getTitle());
        assertEquals("Jane Austen", emma.getAuthor());
        assertEquals("Unknown", emma.getGenre());
        assertEquals(0, emma.getYear());
    }

    @Test
    void task2_equalWhenTitleAndAuthorAreEqual() {
        Book a = new Book("Dune", "Frank Herbert", "Science fiction", 1965);
        Book b = new Book("Dune", "Frank Herbert");
        assertEquals(a, b);
        assertNotEquals(a, new Book("Dune", "Somebody Else"));
        assertNotEquals(a, new Book("Emma", "Frank Herbert"));
        assertNotEquals(a, "Dune");
    }

    @Test
    void task2_equalBooksHaveTheSameHashCode() {
        Book a = new Book("Dune", "Frank Herbert", "Science fiction", 1965);
        Book b = new Book("Dune", "Frank Herbert");
        assertEquals(a.hashCode(), b.hashCode());
        Set<Book> unique = new HashSet<>();
        unique.add(a);
        unique.add(b);
        assertEquals(1, unique.size());
        assertTrue(unique.contains(new Book("Dune", "Frank Herbert")));
    }
}
