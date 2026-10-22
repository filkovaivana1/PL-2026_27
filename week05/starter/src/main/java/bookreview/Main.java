package bookreview;

// A small demo of the platform with three kinds of books.
public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book dune = new AudioBook("Dune", "Frank Herbert", "Science fiction", 1965, 1260);
        Book emma = new PrintedBook("Emma", "Jane Austen", "Classic", 1815, 474);
        Book neuromancer = new EBook("Neuromancer", "William Gibson", "Science fiction", 1984, 1.4);
        library.addBook(dune);
        library.addBook(emma);
        library.addBook(neuromancer);
        library.addBook(new AudioBook("Persuasion", "Jane Austen", "Classic", 1817, 510));

        for (Book book : library.findBooks(1800, 2000)) {
            System.out.println(book);          // one call, four different answers
        }

        System.out.println("Formats: " + library.countByFormat());
        System.out.println("Listening time: " + library.totalListeningMinutes() + " min");
    }
}
