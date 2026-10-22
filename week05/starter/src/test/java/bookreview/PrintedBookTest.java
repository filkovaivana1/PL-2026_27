package bookreview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

// Task 1. The class PrintedBook does not exist yet. Create it:
//   public class PrintedBook extends Book
// with one more field: int pages.
class PrintedBookTest {

    @Test
    void task1_aPrintedBookIsABook() {
        Book emma = new PrintedBook("Emma", "Jane Austen", "Classic", 1815, 474);
        assertTrue(emma instanceof Book);
        assertEquals("Emma", emma.getTitle());          // inherited
        assertEquals("Jane Austen", emma.getAuthor());  // inherited
        assertEquals(1815, emma.getYear());             // inherited
    }

    @Test
    void task1_pages() {
        PrintedBook emma = new PrintedBook("Emma", "Jane Austen", "Classic", 1815, 474);
        assertEquals(474, emma.getPages());
    }

    @Test
    void task1_theRulesOfBookStillHold() {
        PrintedBook strange = new PrintedBook("", "Nobody", "Classic", 99999, 10);
        assertEquals("Untitled", strange.getTitle());
        assertEquals(0, strange.getYear());
    }

    @Test
    void task1_formatAndSize() {
        Book emma = new PrintedBook("Emma", "Jane Austen", "Classic", 1815, 474);
        assertEquals("printed", emma.format());
        assertEquals("474 pages", emma.sizeInfo());
    }
}
