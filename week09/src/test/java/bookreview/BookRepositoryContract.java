package bookreview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// The rules of BookRepository, written once as tests.
// This class is abstract: it does not know which repository it tests.
// InMemoryBookRepositoryTest and MapBookRepositoryTest extend it and say which one.
// The same tests run twice, once per implementation. That is polymorphism in the tests.
abstract class BookRepositoryContract {
    protected BookRepository repository;
    protected Book dune;
    protected Book emma;
    protected Book persuasion;

    // Each subclass returns a fresh, empty repository of its own kind.
    protected abstract BookRepository createRepository();

    @BeforeEach
    void setUp() {
        repository = createRepository();
        dune = new EBook("Dune", "Frank Herbert", "Science fiction", 1965, 1.4);
        emma = new PrintedBook("Emma", "Jane Austen", "Classic", 1815, 474);
        persuasion = new AudioBook("Persuasion", "Jane Austen", "Classic", 1817, 510);
    }

    @Test
    void addStoresAndCounts() {
        assertEquals(0, repository.count());
        assertTrue(repository.add(dune));
        assertTrue(repository.add(emma));
        assertEquals(2, repository.count());
    }

    @Test
    void anEqualBookIsRefused() {
        repository.add(emma);
        assertFalse(repository.add(new PrintedBook("Emma", "Jane Austen", "Classic", 1815, 300)));
        assertEquals(1, repository.count());
    }

    @Test
    void findByIdFindsTheSameObject() {
        repository.add(dune);
        repository.add(emma);
        assertSame(emma, repository.findById(emma.getId()));
        assertNull(repository.findById(-1));
    }

    @Test
    void findAllKeepsTheOrderAndReturnsACopy() {
        repository.add(persuasion);
        repository.add(dune);
        List<Book> all = repository.findAll();
        assertEquals(List.of(persuasion, dune), all);
        all.clear();
        assertEquals(2, repository.count());
        assertNotSame(repository.findAll(), repository.findAll());
    }

    @Test
    void findByAuthorIgnoresCase() {
        repository.add(dune);
        repository.add(emma);
        repository.add(persuasion);
        assertEquals(List.of(emma, persuasion), repository.findByAuthor("JANE austen"));
        assertTrue(repository.findByAuthor("Nobody").isEmpty());
    }
}
