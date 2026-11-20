package bookreview;

import java.util.List;

// Week 8, stretch task: a repository that wraps another repository and counts the lookups.
// It is a BookRepository and it has a BookRepository: a decorator.
public class CountingBookRepository implements BookRepository {
    private final BookRepository inner;
    private int lookups = 0;

    public CountingBookRepository(BookRepository inner) {
        this.inner = inner;
    }

    public int getLookups() {
        return lookups;
    }

    @Override
    public boolean add(Book book) {
        return inner.add(book);
    }

    @Override
    public Book findById(int id) {
        lookups++;
        return inner.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return inner.findAll();
    }

    @Override
    public List<Book> findByAuthor(String author) {
        lookups++;
        return inner.findByAuthor(author);
    }

    @Override
    public int count() {
        return inner.count();
    }
}
