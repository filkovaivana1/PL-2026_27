package bookreview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LibraryTest {
    private Library library;
    private Book dune;
    private Book emma;
    private Book persuasion;

    @BeforeEach          // runs before every test: each test gets a fresh library
    void setUp() {
        library = new Library();
        dune = new Book("Dune", "Frank Herbert", "Science fiction", 1965);
        emma = new Book("Emma", "Jane Austen", "Classic", 1815);
        persuasion = new Book("Persuasion", "Jane Austen", "Classic", 1817);
        library.addBook(dune);
        library.addBook(emma);
        library.addBook(persuasion);
    }

    @Test
    void task3_addBookRefusesDuplicates() {
        assertEquals(3, library.bookCount());
        assertFalse(library.addBook(new Book("Dune", "Frank Herbert")));
        assertEquals(3, library.bookCount());
        assertTrue(library.addBook(new Book("Neuromancer", "William Gibson")));
        assertEquals(4, library.bookCount());
    }

    @Test
    void task3_usersAreFoundByUsername() {
        User ana = new User("ana", "ana@example.com");
        assertTrue(library.registerUser(ana));
        assertSame(ana, library.findUser("ana"));
        assertNull(library.findUser("nobody"));
    }

    @Test
    void task3_aUsernameCanBeTakenOnlyOnce() {
        User first = new User("ana", "ana@example.com");
        assertTrue(library.registerUser(first));
        assertFalse(library.registerUser(new User("ana", "other@example.com")));
        assertSame(first, library.findUser("ana"));
    }

    @Test
    void task4_findBooksByAuthor() {
        List<Book> result = library.findBooks("jane AUSTEN");
        assertEquals(2, result.size());
        assertTrue(result.contains(emma));
        assertTrue(result.contains(persuasion));
        assertTrue(library.findBooks("Nobody").isEmpty());
    }

    @Test
    void task4_findBooksByYears() {
        assertEquals(List.of(emma, persuasion), library.findBooks(1800, 1900));
        assertEquals(List.of(emma), library.findBooks(1815, 1815));
        assertTrue(library.findBooks(2000, 2100).isEmpty());
    }

    @Test
    void task5_addReviewChecksUserAndBook() {
        library.registerUser(new User("ana", "ana@example.com"));
        assertTrue(library.addReview("ana", dune, 5, "Great"));
        assertFalse(library.addReview("nobody", dune, 5, "Unknown user"));
        assertFalse(library.addReview("ana", new Book("Not", "Here"), 5, "Unknown book"));
    }

    @Test
    void task5_averageRating() {
        library.registerUser(new User("ana", "ana@example.com"));
        library.registerUser(new User("marko", "marko@example.com"));
        library.addReview("ana", dune, 5, "Great");
        library.addReview("marko", dune, 4, "Good");
        library.addReview("ana", emma, 2, "Not for me");
        assertEquals(4.5, library.averageRating(dune));
        assertEquals(2.0, library.averageRating(emma));
        assertEquals(0.0, library.averageRating(persuasion));
    }

    @Test
    void task5_countByGenre() {
        Map<String, Integer> counts = library.countByGenre();
        assertEquals(2, counts.size());
        assertEquals(2, counts.get("Classic"));
        assertEquals(1, counts.get("Science fiction"));
        assertEquals("[Classic, Science fiction]", counts.keySet().toString());
    }
}
