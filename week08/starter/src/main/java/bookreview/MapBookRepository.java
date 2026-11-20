package bookreview;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Task 3: the books live in a Map from id to book. findById needs no loop.
// LinkedHashMap keeps the order in which the books were added.
public class MapBookRepository implements BookRepository {
    private final Map<Integer, Book> books = new LinkedHashMap<>();

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
