public class Book {

    private static int nextId = 1;

    private int id;
    private String title;
    private String author;
    private String genre;
    private int year;

    public Book(String title, String author, String genre, int year) {
        this.id = nextId;
        nextId++;

        if (title == null || title.isEmpty()) {
            this.title = "Untitled";
        } else {
            this.title = title;
        }

        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public static int getCreatedCount() {
        return nextId - 1;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Book.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

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
        return "# " + id + " " + title + " by " + author + " (" + year + "), " + genre;
    }
}
