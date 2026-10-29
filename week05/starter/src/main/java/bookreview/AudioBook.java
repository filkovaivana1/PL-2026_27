package bookreview;

// A book that is read to you.
// Task 2: finish this class. Use PrintedBook, which you wrote in Task 1, as your model.
public class AudioBook extends Book {
    // TODO: a private field for the minutes

    public AudioBook(String title, String author, String genre, int year, int minutes) {
        super(title, author, genre, year);
        // TODO: store the minutes
    }

    public int getMinutes() {
        return 0; // TODO
    }

    // TODO: override format() so that it returns "audio"
    // TODO: override sizeInfo() so that it returns for example "1260 min"
    // Do not forget @Override.
}
