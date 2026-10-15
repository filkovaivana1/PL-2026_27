// Helper methods that work on a shelf: an array of books in which some places may be empty (null).
public class CatalogTools {

    public static int countBooks(Book[] shelf) {
        int count = 0;
        for (Book book : shelf) {
            if (book != null) {
                count++;
            }
        }
        return count;
    }

    public static Book oldest(Book[] shelf) {
        Book oldest = null;
        for (Book book : shelf) {
            if (book != null && (oldest == null || book.isOlderThan(oldest))) {
                oldest = book;
            }
        }
        return oldest;
    }

    public static int countByGenre(Book[] shelf, String genre) {
        int count = 0;
        for (Book book : shelf) {
            if (book != null && book.getGenre().equalsIgnoreCase(genre)) {
                count++;
            }
        }
        return count;
    }

    public static Book[] sortedByYear(Book[] shelf) {
        Book[] result = new Book[countBooks(shelf)];
        int next = 0;
        for (Book book : shelf) {
            if (book != null) {
                result[next] = book;
                next++;
            }
        }
        // selection sort: put the oldest remaining book at position i
        for (int i = 0; i < result.length - 1; i++) {
            int oldest = i;
            for (int k = i + 1; k < result.length; k++) {
                if (result[k].isOlderThan(result[oldest])) {
                    oldest = k;
                }
            }
            Book keep = result[i];
            result[i] = result[oldest];
            result[oldest] = keep;
        }
        return result;
    }
}
