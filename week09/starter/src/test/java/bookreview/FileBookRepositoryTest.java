package bookreview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

// Task 4. First: all tests of the week 8 contract, now against FileBookRepository.
// Then: the tests below check that the books really survive a restart.
class FileBookRepositoryTest extends BookRepositoryContract {

    @TempDir
    Path folder;     // JUnit creates an empty folder for every test and deletes it afterwards

    @Override
    protected BookRepository createRepository() {
        return new FileBookRepository(folder.resolve("books.txt"));
    }

    @Test
    void task4_aMissingFileMeansNoBooks() {
        assertEquals(0, new FileBookRepository(folder.resolve("nothing-here.txt")).count());
    }

    @Test
    void task4_everyAddWritesTheFile() throws IOException {
        Path file = folder.resolve("books.txt");
        FileBookRepository repo = new FileBookRepository(file);
        repo.add(emma);
        repo.add(dune);
        assertEquals(List.of("printed;Emma;Jane Austen;Classic;1815;474",
                "ebook;Dune;Frank Herbert;Science fiction;1965;1.4"), Files.readAllLines(file));
    }

    @Test
    void task4_theBooksSurviveARestart() {
        Path file = folder.resolve("books.txt");
        FileBookRepository before = new FileBookRepository(file);
        before.add(emma);
        before.add(persuasion);
        FileBookRepository after = new FileBookRepository(file);
        assertEquals(2, after.count());
        assertEquals(List.of(emma, persuasion), after.findAll());
        assertEquals(2, after.findByAuthor("jane austen").size());
    }

    @Test
    void task4_aBrokenFileIsReported() throws IOException {
        Path file = folder.resolve("broken.txt");
        Files.writeString(file, "printed;Emma;Jane Austen\n");
        assertThrows(IllegalArgumentException.class, () -> new FileBookRepository(file));
    }
}
