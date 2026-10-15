// The first runnable program of the Book Review Platform.
// Optional program argument: a genre, for example  Classic
public class Catalog {
    public static void main(String[] args) {
        Book[] shelf = new Book[6];
        shelf[0] = new Book("Dune", "Frank Herbert", "Science fiction", 1965);
        shelf[1] = new Book("Emma", "Jane Austen", "Classic", 1815);
        shelf[2] = new Book("Neuromancer", "William Gibson", "Science fiction", 1984);
        shelf[3] = new Book("Jane Eyre", "Charlotte Bronte", "Classic", 1847);

        System.out.println("Books on the shelf: " + CatalogTools.countBooks(shelf));
        for (Book book : shelf) {
            if (book != null) {
                System.out.println(book);
            }
        }

        System.out.println("Oldest: " + CatalogTools.oldest(shelf));

        if (args.length > 0) {
            String genre = args[0];
            System.out.println(genre + ": " + CatalogTools.countByGenre(shelf, genre));
        }
    }
}
