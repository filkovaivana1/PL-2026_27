package bookreview;

import java.util.List;

// Week 8: the contract for every place where books are stored.
// ReviewService works with this interface only.
public interface BookRepository {

    // Stores the book. An equal book is refused with false.
    boolean add(Book book);

    // The book with this id, or null when there is none.
    Book findById(int id);

    // All books in the order of adding. Always a new list.
    List<Book> findAll();

    // Books by this author, any case. Empty list if none.
    List<Book> findByAuthor(String author);

    // How many books are stored.
    int count();
}
