package bookreview;

// A small demo of the platform. Run it to see your Library at work.
public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book dune = new Book("Dune", "Frank Herbert", "Science fiction", 1965);
        Book emma = new Book("Emma", "Jane Austen", "Classic", 1815);
        library.addBook(dune);
        library.addBook(emma);
        library.addBook(new Book("Persuasion", "Jane Austen", "Classic", 1817));
        System.out.println("Added Dune again? " + library.addBook(new Book("Dune", "Frank Herbert")));

        library.registerUser(new User("ana", "ana@example.com"));
        library.registerUser(new User("marko", "marko@example.com"));

        library.addReview("ana", dune, 5, "A whole world in one book.");
        library.addReview("marko", dune, 4, "Slow start, great ending.");
        library.addReview("nobody", emma, 1, "This user does not exist.");

        System.out.println("Books: " + library.bookCount());
        System.out.println("By Jane Austen: " + library.findBooks("jane austen"));
        System.out.println("From 1900 to 2000: " + library.findBooks(1900, 2000));
        System.out.println("Average for Dune: " + library.averageRating(dune));
        System.out.println("Average for Emma: " + library.averageRating(emma));
        System.out.println("Genres: " + library.countByGenre());
    }
}
