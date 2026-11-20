package bookreview;

import java.util.ArrayList;
import java.util.List;

// Task 2: the books live in a List.
// Read BookRepository first: every method there says exactly what it must do.
public class InMemoryBookRepository implements BookRepository {
    private final List<Book> books = new ArrayList<>();

    @Override
    public boolean add(Book book) {
        return false; // TODO
    }

    @Override
    public Book findById(int id) {
        return null; // TODO
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(); // TODO
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return new ArrayList<>(); // TODO
    }

    @Override
    public int count() {
        return 0; // TODO
    }
}
