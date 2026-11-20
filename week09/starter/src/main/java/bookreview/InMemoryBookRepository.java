package bookreview;

import java.util.ArrayList;
import java.util.List;

// Week 8, task 2: the books live in a List.
public class InMemoryBookRepository implements BookRepository {
    private final List<Book> books = new ArrayList<>();

    @Override
    public boolean add(Book book) {
        if (books.contains(book)) {
            return false;
        }
        books.add(book);
        return true;
    }

    @Override
    public Book findById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books);
    }

    @Override
    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
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
