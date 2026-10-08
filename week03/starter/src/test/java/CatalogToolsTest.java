import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class CatalogToolsTest {

    private Book[] shelf() {
        Book[] shelf = new Book[6];
        shelf[0] = new Book("Dune", "Frank Herbert", "Science fiction", 1965);
        shelf[2] = new Book("Emma", "Jane Austen", "Classic", 1815);
        shelf[3] = new Book("Neuromancer", "William Gibson", "Science fiction", 1984);
        shelf[5] = new Book("Jane Eyre", "Charlotte Bronte", "Classic", 1847);
        return shelf;          // places 1 and 4 stay empty on purpose
    }

    @Test
    void task4_countBooksSkipsEmptyPlaces() {
        assertEquals(4, CatalogTools.countBooks(shelf()));
        assertEquals(0, CatalogTools.countBooks(new Book[3]));
    }

    @Test
    void task4_oldest() {
        Book[] shelf = shelf();
        assertSame(shelf[2], CatalogTools.oldest(shelf));
        assertNull(CatalogTools.oldest(new Book[3]));
    }

    @Test
    void task4_countByGenreIgnoresCase() {
        assertEquals(2, CatalogTools.countByGenre(shelf(), "Classic"));
        assertEquals(2, CatalogTools.countByGenre(shelf(), "science FICTION"));
        assertEquals(0, CatalogTools.countByGenre(shelf(), "Poetry"));
    }
}
