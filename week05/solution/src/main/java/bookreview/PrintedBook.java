package bookreview;

// A book on paper.
public class PrintedBook extends Book {
    protected int pages;

    public PrintedBook(String title, String author, String genre, int year, int pages) {
        super(title, author, genre, year);
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String format() {
        return "printed";
    }

    @Override
    public String sizeInfo() {
        return pages + " pages";
    }
}
