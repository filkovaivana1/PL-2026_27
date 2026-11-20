package bookreview;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

// Stretch. Make Book Serializable and write the class BookSnapshot with two static methods:
//   void save(List<Book> books, Path file) throws IOException
//   List<Book> load(Path file) throws IOException, ClassNotFoundException
// Use ObjectOutputStream and ObjectInputStream, each in a try with resources.
// To activate this test, remove the two comment lines marked below.
class StretchTest {

    @TempDir
    Path folder;

    @Test
    void stretch_snapshot() throws Exception {
        List<Book> books = List.of(
                new PrintedBook("Emma", "Jane Austen", "Classic", 1815, 474),
                new EBook("Dune", "Frank Herbert", "Science fiction", 1965, 1.4));
        Path file = folder.resolve("books.bin");
        BookSnapshot.save(books, file);
        List<Book> loaded = BookSnapshot.load(file);
        assertEquals(books, loaded);
        assertEquals(1.4, ((EBook) loaded.get(1)).getMegabytes());
    }
}
