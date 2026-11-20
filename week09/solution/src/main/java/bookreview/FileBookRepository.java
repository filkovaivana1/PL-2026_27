package bookreview;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

// Week 9, task 4: a repository that survives a restart.
// It keeps the books in an InMemoryBookRepository (composition) and writes the file after every add.
public class FileBookRepository implements BookRepository {
    private final Path file;
    private final InMemoryBookRepository books = new InMemoryBookRepository();

    // Loads the file if it exists. A missing file means: no books yet.
    public FileBookRepository(Path file) {
        this.file = file;
        if (Files.exists(file)) {
            try {
                for (String line : Files.readAllLines(file)) {
                    if (!line.isBlank()) {
                        books.add(BookLines.fromLine(line));
                    }
                }
            } catch (IOException e) {
                throw new UncheckedIOException("Could not read " + file, e);
            }
        }
    }

    @Override
    public boolean add(Book book) {
        boolean added = books.add(book);
        if (added) {
            save();
        }
        return added;
    }

    // BookRepository does not allow checked exceptions, so an IOException is wrapped.
    private void save() {
        try (BufferedWriter out = Files.newBufferedWriter(file)) {
            for (Book book : books.findAll()) {
                out.write(BookLines.toLine(book));
                out.newLine();
            }
        } catch (IOException e) {
            throw new UncheckedIOException("Could not write " + file, e);
        }
    }

    @Override
    public Book findById(int id) {
        return books.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return books.findAll();
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return books.findByAuthor(author);
    }

    @Override
    public int count() {
        return books.count();
    }
}
