package bookreview;

// A book that is read to you.
public class AudioBook extends Book {
    private int minutes;

    public AudioBook(String title, String author, String genre, int year, int minutes) {
        super(title, author, genre, year);
        this.minutes = minutes;
    }

    public int getMinutes() {
        return minutes;
    }

    @Override
    public String format() {
        return "audio";
    }

    @Override
    public String sizeInfo() {
        return minutes + " min";
    }
}
