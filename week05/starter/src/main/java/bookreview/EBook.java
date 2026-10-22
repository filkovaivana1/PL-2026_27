package bookreview;

// A digital book.
// Task 2: finish this class. Use PrintedBook, which you wrote in Task 1, as your model.
public class EBook extends Book {
    // TODO: a private field for the megabytes

    public EBook(String title, String author, String genre, int year, double megabytes) {
        super(title, author, genre, year);
        // TODO: store the megabytes
    }

    public double getMegabytes() {
        return 0.0; // TODO
    }

    // TODO: override format() so that it returns "ebook"
    // TODO: override sizeInfo() so that it returns for example "1.4 MB"
    // Do not forget @Override.
}
