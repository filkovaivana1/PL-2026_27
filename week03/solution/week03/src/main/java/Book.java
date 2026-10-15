// One book in the catalog of the Book Review Platform.
public class Book {
    private static int nextId = 1;      // shared by all books
    private int id;
    private String title;
    private String author;
    private String genre;
    private int year;

    public Book(String title, String author, String genre, int year) {
        this.id = nextId;
        nextId++;
        if (title == null || title.isBlank()) {
            this.title = "Untitled";
        } else {
            this.title = title;
        }
        this.author = author;
        this.genre = genre;
        setYear(year);
    }

    public static int getCreatedCount() {
        return nextId - 1;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    // Accepts only years from 1450 to 2100. Anything else is ignored.
    public void setYear(int year) {
        if (year >= 1450 && year <= 2100) {
            this.year = year;
        }
    }

    public boolean isOlderThan(Book other) {
        return this.year < other.year;
    }


    @Override
    public String toString() {
        return "#" + id + " " + title + " by " + author + " (" + year + "), " + genre;
    }
}
