// One book in the catalog of the Book Review Platform.
// Tasks 2 and 3: finish this class until BookTest is green.
public class Book {
    // Task 3: a static field that holds the id for the next new book, starting at 1

    // Task 2: private fields for id, title, author, genre and year

    public Book(String title, String author, String genre, int year) {
        // Task 2: store the values in the fields.
        //   A title that is null or blank becomes "Untitled"  (hint: title.isBlank())
        //   Use setYear(year) so the rule for the year lives in one place.
        // Task 3: give this book the next id, then increase the static field.
    }

    // Task 3: how many books were created so far
    public static int getCreatedCount() {
        return 0; // TODO
    }

    public int getId() {
        return 0; // TODO
    }

    public String getTitle() {
        return null; // TODO
    }

    public String getAuthor() {
        return null; // TODO
    }

    public String getGenre() {
        return null; // TODO
    }

    public int getYear() {
        return 0; // TODO
    }

    public void setGenre(String genre) {
        // TODO
    }

    // Accepts only years from 1450 to 2100. Anything else is ignored.
    public void setYear(int year) {
        // TODO
    }

    // true when this book was published before the other book
    public boolean isOlderThan(Book other) {
        return false; // TODO
    }

    // Format:  #1 Dune by Frank Herbert (1965), Science fiction
    @Override
    public String toString() {
        return ""; // TODO
    }
}
