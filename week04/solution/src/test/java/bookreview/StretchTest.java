package bookreview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StretchTest {

    @Test
    void stretch_topRated() {
        Library library = new Library();
        assertNull(library.topRated());
        Book dune = new Book("Dune", "Frank Herbert", "Science fiction", 1965);
        Book emma = new Book("Emma", "Jane Austen", "Classic", 1815);
        library.addBook(dune);
        library.addBook(emma);
        library.registerUser(new User("ana", "ana@example.com"));
        library.addReview("ana", dune, 3, "ok");
        library.addReview("ana", emma, 5, "lovely");
        assertSame(emma, library.topRated());
    }

    @Test
    void stretch_removeBooksOlderThan() {
        Library library = new Library();
        library.addBook(new Book("Emma", "Jane Austen", "Classic", 1815));
        library.addBook(new Book("Persuasion", "Jane Austen", "Classic", 1817));
        library.addBook(new Book("Dune", "Frank Herbert", "Science fiction", 1965));
        assertEquals(2, library.removeBooksOlderThan(1900));
        assertEquals(1, library.bookCount());
        assertEquals(0, library.removeBooksOlderThan(1900));
    }
}
