package bookreview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;

class HierarchyTest {

    @Test
    void task2_ebook() {
        EBook book = new EBook("Neuromancer", "William Gibson", "Science fiction", 1984, 1.4);
        assertEquals(1.4, book.getMegabytes());
        assertEquals("ebook", book.format());
        assertEquals("1.4 MB", book.sizeInfo());
    }

    @Test
    void task2_audioBook() {
        AudioBook book = new AudioBook("Dune", "Frank Herbert", "Science fiction", 1965, 1260);
        assertEquals(1260, book.getMinutes());
        assertEquals("audio", book.format());
        assertEquals("1260 min", book.sizeInfo());
    }

    @Test
    void task3_bookIsAbstract() {
        // This line asks Java itself whether the class Book is declared abstract.
        assertTrue(Modifier.isAbstract(Book.class.getModifiers()), "Book must be abstract");
    }

    @Test
    void task3_toStringShowsFormatAndSize() {
        Book dune = new AudioBook("Dune", "Frank Herbert", "Science fiction", 1965, 1260);
        assertEquals("#" + dune.getId() + " Dune by Frank Herbert (1965), Science fiction [audio, 1260 min]",
                dune.toString());
        Book emma = new PrintedBook("Emma", "Jane Austen", "Classic", 1815, 474);
        assertTrue(emma.toString().endsWith("Classic [printed, 474 pages]"));
    }
}
