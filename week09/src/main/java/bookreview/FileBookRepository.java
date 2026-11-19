package bookreview;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

// Task 4: a repository that survives a restart.
// Keep the books in the InMemoryBookRepository below (composition) and write the file after every add.
public class FileBookRepository implements BookRepository {
    private final Path file;
    private final InMemoryBookRepository books = new InMemoryBookRepository();

    // TODO: if the file exists, read all lines and add BookLines.fromLine(line) for each line that is not blank.
    // Files.readAllLines throws IOException: catch it and throw new UncheckedIOException("Could not read " + file, e).
    public FileBookRepository(Path file) {
        this.file = file;
    }

    // TODO: add to books. Only if that worked, write the whole file again (a private method save()).
    @Override
    public boolean add(Book book) {
        return false; // TODO
    }

    // TODO: the other four methods pass the call on to books.
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
