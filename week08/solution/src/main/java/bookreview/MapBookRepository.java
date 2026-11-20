package bookreview;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Week 8, task 3: the books live in a Map from id to book. findById needs no loop.
// LinkedHashMap keeps the order in which the books were added.
public class MapBookRepository implements BookRepository {
    private final Map<Integer, Book> books = new LinkedHashMap<>();

    @Override
    public boolean add(Book book) {
        if (books.containsValue(book)) {
            return false;
        }
        books.put(book.getId(), book);
        return true;
    }

    @Override
    public Book findById(int id) {
        return books.get(id);
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    @Override
    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public int count() {
        return books.size();
    }
}
