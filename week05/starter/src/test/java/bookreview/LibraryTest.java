package bookreview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LibraryTest {
    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
        library.addBook(new AudioBook("Dune", "Frank Herbert", "Science fiction", 1965, 1260));
        library.addBook(new PrintedBook("Emma", "Jane Austen", "Classic", 1815, 474));
        library.addBook(new EBook("Neuromancer", "William Gibson", "Science fiction", 1984, 1.4));
        library.addBook(new AudioBook("Persuasion", "Jane Austen", "Classic", 1817, 510));
    }

    @Test
    void theLibraryOfWeek4StillWorks() {
        assertEquals(4, library.bookCount());
        assertFalse(library.addBook(new PrintedBook("Emma", "Jane Austen", "Classic", 1815, 300)));
        List<Book> austen = library.findBooks("Jane Austen");
        assertEquals(2, austen.size());
    }

    @Test
    void task4_countByFormat() {
        assertEquals("{audio=2, ebook=1, printed=1}", library.countByFormat().toString());
        assertTrue(new Library().countByFormat().isEmpty());
    }

    @Test
    void task4_totalListeningMinutes() {
        assertEquals(1770, library.totalListeningMinutes());
        assertEquals(0, new Library().totalListeningMinutes());
    }
}
