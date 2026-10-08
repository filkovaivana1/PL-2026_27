import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class StretchTest {

    @Test
    void stretch_sortedByYear() {
        Book[] shelf = new Book[5];
        shelf[0] = new Book("Dune", "Frank Herbert", "Science fiction", 1965);
        shelf[2] = new Book("Emma", "Jane Austen", "Classic", 1815);
        shelf[4] = new Book("Neuromancer", "William Gibson", "Science fiction", 1984);

        Book[] sorted = CatalogTools.sortedByYear(shelf);

        assertEquals(3, sorted.length);
        assertEquals("Emma", sorted[0].getTitle());
        assertEquals("Dune", sorted[1].getTitle());
        assertEquals("Neuromancer", sorted[2].getTitle());
        assertEquals("Dune", shelf[0].getTitle());   // the shelf itself is unchanged
        assertNull(shelf[1]);
    }
}
