package bookreview;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// Week 9 demo: bad input is refused with exceptions, and the books survive a restart.
public class Main {
    public static void main(String[] args) throws IOException {
        Path file = Path.of("books.txt");
        Files.deleteIfExists(file);                  // start fresh for the demo

        FileBookRepository first = new FileBookRepository(file);
        Book emma = new PrintedBook("Emma", "Jane Austen", "Classic", 1815, 474);
        first.add(emma);
        first.add(new EBook("Dune", "Frank Herbert", "Science fiction", 1965, 1.4));
        first.add(new AudioBook("Persuasion", "Jane Austen", "Classic", 1817, 510));

        ReviewService service = new ReviewService(first);
        User ana = new User("ana", "ana@uacs.edu.mk");
        int[][] attempts = { {emma.getId(), 5}, {emma.getId(), 7}, {9999, 4} };
        for (int[] a : attempts) {
            try {
                service.addReview(ana, a[0], a[1], "");
                System.out.println("Review accepted: book " + a[0] + ", rating " + a[1]);
            } catch (InvalidRatingException | BookNotFoundException e) {
                System.out.println("Refused: " + e.getMessage());
            }
        }

        System.out.println("The file has " + Files.readAllLines(file).size() + " lines:");
        System.out.println(Files.readString(file).trim());

        FileBookRepository afterRestart = new FileBookRepository(file);
        System.out.println("After a restart: " + afterRestart.count() + " books, "
                + afterRestart.findByAuthor("jane austen").size() + " by Jane Austen");
    }
}
