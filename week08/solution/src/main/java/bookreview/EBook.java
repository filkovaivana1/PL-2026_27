package bookreview;

// A digital book.
public class EBook extends Book {
    private double megabytes;

    public EBook(String title, String author, String genre, int year, double megabytes) {
        super(title, author, genre, year);
        this.megabytes = megabytes;
    }

    public double getMegabytes() {
        return megabytes;
    }

    @Override
    public String format() {
        return "ebook";
    }

    @Override
    public String sizeInfo() {
        return megabytes + " MB";
    }
}
