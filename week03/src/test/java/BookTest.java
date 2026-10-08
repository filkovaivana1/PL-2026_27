import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BookTest {

    @Test
    void task2_constructorAndGetters() {
        Book dune = new Book("Dune", "Frank Herbert", "Science fiction", 1965);
        assertEquals("Dune", dune.getTitle());
        assertEquals("Frank Herbert", dune.getAuthor());
        assertEquals("Science fiction", dune.getGenre());
        assertEquals(1965, dune.getYear());
    }

    @Test
    void task2_emptyTitleBecomesUntitled() {
        assertEquals("Untitled", new Book("", "Nobody", "Classic", 1900).getTitle());
        assertEquals("Untitled", new Book("   ", "Nobody", "Classic", 1900).getTitle());
        assertEquals("Untitled", new Book(null, "Nobody", "Classic", 1900).getTitle());
    }

    @Test
    void task2_setYearRefusesImpossibleYears() {
        Book dune = new Book("Dune", "Frank Herbert", "Science fiction", 1965);
        dune.setYear(3000);
        assertEquals(1965, dune.getYear());
        dune.setYear(1200);
        assertEquals(1965, dune.getYear());
        dune.setYear(1966);
        assertEquals(1966, dune.getYear());
    }

    @Test
    void task2_constructorUsesTheRuleForTheYear() {
        Book normal = new Book("Normal", "Nobody", "Classic", 1999);
        assertEquals(1999, normal.getYear());
        Book strange = new Book("Strange", "Nobody", "Classic", 99999);
        assertEquals(0, strange.getYear());
    }

    @Test
    void task2_setGenre() {
        Book dune = new Book("Dune", "Frank Herbert", "Science fiction", 1965);
        dune.setGenre("Classic");
        assertEquals("Classic", dune.getGenre());
    }

    @Test
    void task2_isOlderThan() {
        Book dune = new Book("Dune", "Frank Herbert", "Science fiction", 1965);
        Book emma = new Book("Emma", "Jane Austen", "Classic", 1815);
        assertTrue(emma.isOlderThan(dune));
        assertFalse(dune.isOlderThan(emma));
        assertFalse(dune.isOlderThan(dune));
    }

    @Test
    void task3_everyBookGetsTheNextId() {
        Book first = new Book("A", "X", "Classic", 1900);
        Book second = new Book("B", "Y", "Classic", 1901);
        Book third = new Book("C", "Z", "Classic", 1902);
        assertEquals(first.getId() + 1, second.getId());
        assertEquals(first.getId() + 2, third.getId());
    }

    @Test
    void task3_createdCountGrowsWithEveryBook() {
        int before = Book.getCreatedCount();
        new Book("A", "X", "Classic", 1900);
        new Book("B", "Y", "Classic", 1901);
        assertEquals(before + 2, Book.getCreatedCount());
    }

    @Test
    void task3_toString() {
        Book dune = new Book("Dune", "Frank Herbert", "Science fiction", 1965);
        assertEquals("#" + dune.getId() + " Dune by Frank Herbert (1965), Science fiction", dune.toString());
    }
}
