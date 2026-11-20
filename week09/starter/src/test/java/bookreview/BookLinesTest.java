package bookreview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

// Task 3.
class BookLinesTest {

    @Test
    void task3_toLine() {
        assertEquals("printed;Emma;Jane Austen;Classic;1815;474",
                BookLines.toLine(new PrintedBook("Emma", "Jane Austen", "Classic", 1815, 474)));
        assertEquals("ebook;Dune;Frank Herbert;Science fiction;1965;1.4",
                BookLines.toLine(new EBook("Dune", "Frank Herbert", "Science fiction", 1965, 1.4)));
        assertEquals("audio;Persuasion;Jane Austen;Classic;1817;510",
                BookLines.toLine(new AudioBook("Persuasion", "Jane Austen", "Classic", 1817, 510)));
    }

    @Test
    void task3_fromLineCreatesTheRightKind() {
        Book book = BookLines.fromLine("audio;Persuasion;Jane Austen;Classic;1817;510");
        assertTrue(book instanceof AudioBook);
        assertEquals("Persuasion", book.getTitle());
        assertEquals(1817, book.getYear());
        assertEquals(510, ((AudioBook) book).getMinutes());
        assertEquals(1.4, ((EBook) BookLines.fromLine("ebook;Dune;Frank Herbert;Science fiction;1965;1.4")).getMegabytes());
    }

    @Test
    void task3_roundTrip() {
        Book emma = new PrintedBook("Emma", "Jane Austen", "Classic", 1815, 474);
        Book copy = BookLines.fromLine(BookLines.toLine(emma));
        assertEquals(emma, copy);
        assertEquals(474, ((PrintedBook) copy).getPages());
    }

    @Test
    void task3_badLinesAreRefused() {
        assertThrows(IllegalArgumentException.class, () -> BookLines.fromLine("printed;Emma;Jane Austen"));
        assertThrows(IllegalArgumentException.class, () -> BookLines.fromLine("scroll;Emma;Jane Austen;Classic;1815;1"));
        // NumberFormatException is a subclass of IllegalArgumentException, so this passes too
        assertThrows(IllegalArgumentException.class, () -> BookLines.fromLine("printed;Emma;Jane Austen;Classic;soon;474"));
    }
}
