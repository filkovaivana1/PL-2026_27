public class CatalogTools {
    public static Book oldestBook(Book[] books) {

        Book oldest = null;
        for (Book book : books) {
            if (book != null && ((oldest == null) || book.isOlderThan(oldest))) {
                oldest = book;
            }
        }
        return oldest;
    }

    public static int countByGenre(Book[] books, String genre) {

        int count = 0;

        for (Book book : books) {
            if (book != null && book.getGenre().equalsIgnoreCase(genre)) {
                count++;
            }
        }
       return count;
    }

}
