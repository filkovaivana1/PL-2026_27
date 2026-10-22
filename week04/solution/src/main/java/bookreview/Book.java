package bookreview;

import java.util.Objects;

// One book in the catalog of the Book Review Platform.
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
        if (title == null || title.isBlank()) {
            this.title = "Untitled";
        } else {
            this.title = title;
        }
        this.author = author;
        this.genre = genre;
        setYear(year);
    }

    // Task 2: a shorter way to create a book
    public Book(String title, String author) {
        this(title, author, "Unknown", 0);
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

    public void setYear(int year) {
        if (year >= 1450 && year <= 2100) {
            this.year = year;
        }
    }


        // Task 2: two books are equal when title and author are equal. The id does not count.
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Book that)) {
            return false;
        }
        return Objects.equals(title, that.title) && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    @Override
    public String toString() {
        return "#" + id + " " + title + " by " + author + " (" + year + "), " + genre;
    }
}
